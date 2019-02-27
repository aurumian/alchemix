package iad.service;

import iad.dto.recipe.RecipeIn;
import iad.dto.recipe.ResourceIn;
import iad.model.Recipe;
import iad.model.RecipeResource;
import iad.model.RecipeResourceKey;
import iad.model.Resource;
import iad.repository.RecipeRepository;
import iad.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public void addRecipe(RecipeIn recipeIn) {
        Recipe recipe = new Recipe();
        Resource resResource = resourceRepository.findByResourceId(recipeIn.resResourceId);

        if (resResource == null)
            throw new IllegalArgumentException("No resource found with resResourceId " + recipeIn.resResourceId);

        recipe.setResultResource(resResource);
        recipe.setResources(new HashSet<>());

        for (ResourceIn in: recipeIn.resources){
            if (recipeIn.resResourceId == in.resourceId)
                throw new IllegalArgumentException("resourceId cannot be equal to resResourceId");
            recipe.getResources().add(new RecipeResource(new RecipeResourceKey(in.resourceId, recipe), in.quantity));
        }

        recipeRepository.save(recipe);
    }
}
