package iad.controller;

import iad.dto.ResourceInventoryDto;
import iad.dto.StoreResource;
import iad.model.*;
import iad.repository.ResourceInventoryRepository;
import iad.repository.ResourceOnSaleRepository;
import iad.repository.RoleRepository;
import iad.repository.UserRepository;
import iad.service.ShopService;
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
    private ShopService shopService;

    @GetMapping("/store")
    public ResponseEntity<List<StoreResource>> getStoreItems(){
        return ResponseEntity.ok(resourceOnSaleRepository.findBySellerRole(roleRepository.findByRole("ROLE_ADMIN")));
    }

    @GetMapping("/market")
    public ResponseEntity<List<StoreResource>> getMarketItems(){
        return ResponseEntity.ok(resourceOnSaleRepository.findBySellerRole(roleRepository.findByRole("ROLE_USER")));
    }

    @PostMapping("/buy")
    public ResponseEntity<Long> buyResource(@RequestParam long resourceId, @RequestParam long quantity,
                                            @RequestParam long sellerId ,Principal principal)
    {
        return ResponseEntity.ok(
                    shopService.makePurchase(resourceId, quantity, sellerId, principal.getName()));

    }

    @PostMapping("/putOnSale")
    public ResponseEntity<Long> putResourceOnSale(@RequestParam long resourceId, @RequestParam long quantity,
                                                    @RequestParam long price, Principal principal){
        return ResponseEntity.ok(shopService.putResourceOnSale(resourceId, quantity, price, principal.getName()));
    }

}
