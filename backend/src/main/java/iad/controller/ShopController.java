package iad.controller;

import iad.dto.StoreResource;
import iad.model.ResourceOnSale;
import iad.repository.ResourceOnSaleRepository;
import iad.repository.RoleRepository;
import iad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        //validate
        ResourceOnSale resourceOnSale;

        //return new quantity
        return ResponseEntity.ok(null);
    }

}
