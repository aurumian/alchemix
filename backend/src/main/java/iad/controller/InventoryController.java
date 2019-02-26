package iad.controller;

import iad.dto.ResourceInventoryDto;
import iad.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/api/inventory/my-resources")
    public ResponseEntity<List<ResourceInventoryDto>> getMyResources(Principal principal){
        return ResponseEntity.ok(inventoryService.getUserInventory(principal.getName()));
    }
}
