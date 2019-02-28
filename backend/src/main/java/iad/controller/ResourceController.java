package iad.controller;

import iad.dto.ResourceDto;
import iad.model.*;
import iad.repository.AssetRepository;
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

import javax.xml.ws.Response;
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

    @Autowired
    private AssetRepository assetRepository;

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
        Resource resource = new Resource(resourceDto.name, resourceDto.tier, resourceDto.imageId,
                assetRepository.getByName(resourceDto.assetName), resourceDto.description);

        return new ResponseEntity<>(resourceRepository.save(resource), HttpStatus.OK);
    }

    @PostMapping("/admin/api/resource/putOnSale")
    public ResponseEntity<String> putOnSale(@RequestParam long resourceId, @RequestParam long quantity, @RequestParam long price, Principal principal){

        if (quantity == 0) return ResponseEntity.badRequest().body("Quantity should not be equal to 0");
        if (price <= 0) return ResponseEntity.badRequest().body("Price must be greater than 0");

        Resource resource = resourceRepository.findByResourceId(resourceId);
        if (resource == null)
            return ResponseEntity.badRequest().body("Resource with resourceId " + resourceId + " doesn't exist");

        User user = userRepository.getOneByUsername(principal.getName());

        ResourceOnSale resourceOnSale = resourceOnSaleRepository.findById(new ResourceOnSaleKey(user, resource));

        if (resourceOnSale == null)
            resourceOnSale = new ResourceOnSale(quantity, price, userRepository.getOneByUsername(principal.getName()), resourceRepository.findByResourceId(resourceId));
        else {
            if (resourceOnSale.getQuantity() > 0)
                if (quantity < 0)
                    //we want to make the resource infinite
                    resourceOnSale.setQuantity(-1);
                else
                    //we want increase quantity of the resource
                    resourceOnSale.setQuantity(resourceOnSale.getQuantity() + quantity);
            else
                if (quantity > 0)
                    //we want to make resource finite
                    resourceOnSale.setQuantity(quantity);
        }

        resourceOnSaleRepository.save(resourceOnSale);

        return ResponseEntity.ok("Put resource on sale");
    }

}
