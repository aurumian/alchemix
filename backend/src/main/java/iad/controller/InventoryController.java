package iad.controller;

import iad.dto.UserResourceInventoryWrapper;
import iad.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/admin/api/inventory/add")
    public ResponseEntity addResource(@RequestParam long resourceId, @RequestParam long quantity, Principal principal){
        inventoryService.addResourceToInventory(resourceId, principal.getName(), quantity);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/api/inventory/my-resources")
    public ResponseEntity<UserResourceInventoryWrapper> getMyResources(Principal principal){
        return ResponseEntity.ok(new UserResourceInventoryWrapper(inventoryService.getUserInventory(principal.getName())));
    }
}
