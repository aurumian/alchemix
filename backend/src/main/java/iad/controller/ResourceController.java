package iad.controller;

import iad.dto.ResourceDto;
import iad.model.Resource;
import iad.model.ResourceInventory;
import iad.model.ResourceOnSale;
import iad.model.User;
import iad.repository.ResourceOnSaleRepository;
import iad.repository.ResourceRepository;
import iad.repository.UserRepository;
import iad.security.CustomUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ResourceController {

    private ResourceRepository resourceRepository;

    @Autowired
    private ResourceOnSaleRepository resourceOnSaleRepository;

    @Autowired
    private UserRepository userRepository;

    public ResourceController(ResourceRepository resourceRepository){
        this.resourceRepository = resourceRepository;
    }

    @GetMapping
    @RequestMapping("/admin/api/resource")
    public ResponseEntity<List<Resource>> getResources(){
        List<Resource> resources = resourceRepository.findAll();

        if (resources != null)
            return ResponseEntity.ok(resources);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }


    @PostMapping("/admin/api/resource/create")
    public ResponseEntity<Resource> addResource(@RequestBody ResourceDto resourceDto){
        Resource resource = new Resource(resourceDto);

        return new ResponseEntity<>(resourceRepository.save(resource), HttpStatus.OK);
    }

    @PostMapping("/admin/api/resource/putOnSale")
    public ResponseEntity<String> putOnSale(@RequestParam long resourceId, @RequestParam long quantity, @RequestParam long price, Principal principal){
        if (quantity == 0) return ResponseEntity.badRequest().body("Quantity should not be equal to 0");
        if (price <= 0) return ResponseEntity.badRequest().body("Price must be greater than 0");
        resourceOnSaleRepository.save(new ResourceOnSale(quantity, price, userRepository.getOneByUsername(principal.getName()), resourceRepository.findByResourceId(resourceId)));

        /*
        User user = userRepository.findByUsername(principal.getName());

        ResourceOnSale resource = new ResourceOnSale(quantity, price, user, resourceRepository.findByResourceId(resourceId));

        user.getResourcesOnSale().add(resource);

        userRepository.save(user);
        */

        return ResponseEntity.ok("Put resource on sale");
    }

}
