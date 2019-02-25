package iad.controller;

import iad.dto.StoreResource;
import iad.model.*;
import iad.repository.ResourceInventoryRepository;
import iad.repository.ResourceOnSaleRepository;
import iad.repository.RoleRepository;
import iad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/shop")
public class ShopController {

    @Autowired
    private ResourceOnSaleRepository resourceOnSaleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResourceInventoryRepository resourceInventoryRepository;

    @GetMapping("/store")
    public ResponseEntity<List<StoreResource>> getStoreItems(){
        return ResponseEntity.ok(resourceOnSaleRepository.findBySellerRole(roleRepository.findByRole("ROLE_ADMIN")));
    }

    @GetMapping("/market")
    public ResponseEntity<List<StoreResource>> getMarketItems(){
        return ResponseEntity.ok(resourceOnSaleRepository.findBySellerRole(roleRepository.findByRole("ROLE_USER")));
    }

    @PostMapping("/buy")
    public ResponseEntity<String> buyResource(@RequestParam long resourceId, @RequestParam long quantity,
                                            @RequestParam long sellerId ,Principal principal)
    {
        //validate
        if (quantity <= 0)
            return ResponseEntity.badRequest().body("quantity must be greater than 0");

        ResourceOnSale resourceOnSale =
                resourceOnSaleRepository.findById_Seller_UserIdAndId_Resource_ResourceId(sellerId, resourceId);

        if (resourceOnSale == null)
            return ResponseEntity.badRequest().body("No resource on sale found");

        //see if resourceOnSale has enough quantity to make a purchase
        if (resourceOnSale.getQuantity() < quantity)
            return ResponseEntity.badRequest().body("Cannot buy " + quantity + " resources. " +
            "This resource on sale has only " + resourceOnSale.getQuantity() + " resources");


        User user = userRepository.findByUsername(principal.getName());
        //See if user has enough money
        if (user.getMoney() < quantity*resourceOnSale.getPrice())
            return ResponseEntity.badRequest().body("User doesn't have enough money");


        ResourceInventory resourceInventory = resourceInventoryRepository.findById(
                new ResourceInventoryKey(user, resourceOnSale.getId().getResource()));

        //see if user already has resource with this id
        if (resourceInventory != null){
            //increase quantity user has
            resourceInventory.setQuantity(resourceInventory.getQuantity() + quantity);
        }
        else {
            //add new resource
            user.getResourceInventory().add(
                    new ResourceInventory(new ResourceInventoryKey(user,
                            resourceOnSale.getId().getResource()), quantity));
        }




        //return new quantity
        return ResponseEntity.ok(null);
    }

}
