package iad.service;

import iad.dto.recipe.RecipeIn;
import iad.dto.recipe.RecipeOut;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface RecipeService {
    void addRecipe(RecipeIn recipe);

    List<RecipeOut> getUserRecipes(String username);

    List<RecipeOut> getAllRecipes();
}
