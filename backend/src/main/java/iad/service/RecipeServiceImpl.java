package iad.service;

import iad.dto.ResourceDto;
import iad.dto.ResourceInventoryDto;
import iad.dto.recipe.RecipeIn;
import iad.dto.recipe.RecipeOut;
import iad.dto.recipe.ResourceIn;
import iad.model.*;
import iad.repository.RecipeRepository;
import iad.repository.ResourceRepository;
import iad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

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

    @Override
    public List<RecipeOut> getUserRecipes(String username) {

        User user = userRepository.findByUsername(username);

        List<RecipeOut> res = new ArrayList<>(user.getRecipes().size());

        for (Recipe recipe: user.getRecipes()){
            Resource rr = recipe.getResultResource();
            RecipeOut recipeOut = new RecipeOut(recipe.getRecipeId() ,new ResourceDto(rr.getResourceId(), rr.getName(), rr.getDescription(),
                    rr.getTier(), rr.getImageId(), rr.getAsset().getName()));

            for (RecipeResource recRes: recipe.getResources()){
                rr = resourceRepository.findByResourceId(recRes.getId().getResourceId());
                recipeOut.resources.add(new ResourceInventoryDto(rr.getResourceId(), rr.getName(), rr.getDescription(),
                        rr.getTier(), rr.getImageId(), rr.getAsset().getName(), recRes.getQuantity()));
            }

            res.add(recipeOut);

        }
        return res;
    }

    @Override
    public List<RecipeOut> getAllRecipes() {
        List<RecipeOut> res = new LinkedList<>();

        for (Recipe recipe: recipeRepository.findAll()){
            Resource rr = recipe.getResultResource();
            RecipeOut recipeOut = new RecipeOut(recipe.getRecipeId(), new ResourceDto(rr.getResourceId(), rr.getName(), rr.getDescription(),
                    rr.getTier(), rr.getImageId(), rr.getAsset().getName()));

            for (RecipeResource recRes: recipe.getResources()){
                rr = resourceRepository.findByResourceId(recRes.getId().getResourceId());
                recipeOut.resources.add(new ResourceInventoryDto(rr.getResourceId(), rr.getName(), rr.getDescription(),
                        rr.getTier(), rr.getImageId(), rr.getAsset().getName(), recRes.getQuantity()));
            }

            res.add(recipeOut);

        }

        return res;
    }
}
