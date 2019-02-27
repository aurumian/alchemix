package iad.controller;

import iad.dto.recipe.RecipeIn;
import iad.dto.recipe.RecipeOut;
import iad.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/admin/api/recipe/add")
    public ResponseEntity addRecipe(@RequestBody RecipeIn recipeIn){

        recipeService.addRecipe(recipeIn);

        return ResponseEntity.ok("successfully saved");
    }

    @GetMapping("/admin/api/recipe/get")
    public ResponseEntity<List<RecipeOut>> getAllRecipes(){

        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @GetMapping("/api/recipe/get")
    public ResponseEntity<List<RecipeOut>> getRecipes(Principal principal){
        return ResponseEntity.ok(recipeService.getUserRecipes(principal.getName()));
    }
}
