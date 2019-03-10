package iad.service;

import iad.dto.ResourceDto;
import iad.dto.recipe.RecipeIn;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CraftService {
    ResourceDto craft(RecipeIn recipe, String username);
}
