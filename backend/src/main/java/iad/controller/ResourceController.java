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

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ResourceController {

    private ResourceRepository resourceRepository;

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


    @PostMapping("admin/api/create")
    public ResponseEntity<Resource> addResource(@RequestBody ResourceDto resourceDto){
        Resource resource = new Resource(resourceDto);

        return new ResponseEntity<>(resourceRepository.save(resource), HttpStatus.OK);
    }

}
