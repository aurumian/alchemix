package iad.controller;

import iad.dto.ResourceDto;
import iad.model.Resource;
import iad.model.ResourceInventory;
import iad.repository.ResourceRepository;
import iad.security.CustomUserPrincipal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {

    private ResourceRepository resourceRepository;

    public ResourceController(ResourceRepository resourceRepository){
        this.resourceRepository = resourceRepository;
    }

    @GetMapping
    public ResponseEntity<List<Resource>> getResources(){
        List<Resource> resources = resourceRepository.findAll();

        if (resources != null)
            return ResponseEntity.ok(resources);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }


    @PostMapping("/create")
    public ResponseEntity<Resource> addResource(@RequestBody ResourceDto resourceDto){
        Resource resource = new Resource(resourceDto);

        return new ResponseEntity<>(resourceRepository.save(resource), HttpStatus.OK);
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<ResourceInventory>> getInventory(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseEntity.ok(new ArrayList<>());
    }

}
