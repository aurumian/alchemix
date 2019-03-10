package iad.service;

import iad.dto.ResourceDto;
import iad.dto.recipe.RecipeIn;
import iad.dto.recipe.ResourceIn;
import iad.model.*;
import iad.repository.RecipeRepository;
import iad.repository.RecipeResourceRepository;
import iad.repository.ResourceRepository;
import iad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CraftServiceImpl implements CraftService{

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private RecipeResourceRepository recipeResourceRepository;

    @Override
    public ResourceDto craft(RecipeIn recipeIn, String username) {

        //get recipe resources
        //and remove resources from user inventory
        List<Long> ids = new ArrayList<>(recipeIn.resources.size());
        for (ResourceIn resourceIn: recipeIn.resources) {
            ids.add(resourceIn.resourceId);
            inventoryService.removeResourceFromInventory(resourceIn.resourceId, username, resourceIn.quantity);
        }

        //Search for recipe
        Set<Long> recipes = recipeResourceRepository.getRecipeIds(recipeIn.resources.get(0).resourceId,
                recipeIn.resources.get(0).quantity);
        int count = 1;
        while (count < recipeIn.resources.size() && recipes.size() > 0){
            recipes.retainAll(recipeResourceRepository.getRecipeIds(recipeIn.resources.get(count).resourceId,
                    recipeIn.resources.get(count).quantity));
            count ++;
        }
        Recipe recipe = null;

        //look through resulting recipes for one with the same number of ingredients as the recipeIn's
        for (long recipeId: recipes)
            if (recipeResourceRepository.countRecipeResourceById_Recipe_RecipeId(recipeId) == recipeIn.resources.size()){
                recipe = recipeRepository.findOneByRecipeId(recipeId);
                break;
            }


        Resource resource;
        if (recipe == null)
            resource = resourceRepository.findByResourceId(4);
        else
            resource = recipe.getResultResource();

        User user = userRepository.findByUsername(username);
        //Add crafted resource user resource inventory
        inventoryService.addResourceToInventory(resource, user, 1);

        //Update user recipe inventory if user discovered new recipe
        user.getRecipes().add(recipe);

        return new ResourceDto(resource.getResourceId(), resource.getName(), resource.getDescription(),
                resource.getTier(), resource.getImageId(), resource.getAsset().getName());
    }
}
