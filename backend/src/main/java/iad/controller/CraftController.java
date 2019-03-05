package iad.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import iad.dto.recipe.RecipeIn;
import iad.service.CraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.Principal;

@RestController
public class CraftController {

    @Autowired
    CraftService craftService;

    @PostMapping("/api/craft")
    public ResponseEntity craft(@RequestParam String recipeStr, Principal principal) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println(recipeStr);

        RecipeIn recipe = objectMapper.readValue(recipeStr, RecipeIn.class);

        craftService.craft(recipe, principal.getName());

        return ResponseEntity.ok("Crafted successfully");
    }
}
