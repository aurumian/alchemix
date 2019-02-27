package iad.service;

import iad.dto.recipe.RecipeIn;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RecipeService {
    void addRecipe(RecipeIn recipe);
}
