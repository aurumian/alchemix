package iad.controller;

import iad.dto.recipe.RecipeIn;
import iad.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/admin/api/recipe/add")
    public ResponseEntity addRecipe(@RequestBody RecipeIn recipeIn){

        recipeService.addRecipe(recipeIn);

        return ResponseEntity.ok("successfully saved");
    }
}
