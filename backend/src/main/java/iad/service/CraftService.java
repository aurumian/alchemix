package iad.service;

import iad.dto.recipe.RecipeIn;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CraftService {
    void craft(RecipeIn recipe, String username);
}
