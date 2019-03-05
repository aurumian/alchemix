package iad.service;

import iad.dto.recipe.RecipeIn;
import iad.dto.recipe.ResourceIn;
import iad.model.Recipe;
import iad.model.RecipeResource;
import iad.model.RecipeResourceKey;
import iad.model.User;
import iad.repository.RecipeRepository;
import iad.repository.RecipeResourceRepository;
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
    InventoryService inventoryService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RecipeResourceRepository recipeResourceRepository;

    @Override
    public void craft(RecipeIn recipeIn, String username) {

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

        if (recipes.size() == 1){
            long recipeId = recipes.iterator().next();
            if (recipeResourceRepository.countRecipeResourceById_Recipe_RecipeId(recipeId) == recipeIn.resources.size()){
                recipe = recipeRepository.findOneByRecipeId(recipeId);
            }
        }

        if (recipe == null)
            //temporary, until we make default craft resource (low-poly poo)
            throw new RuntimeException("No such recipe");

        User user = userRepository.findByUsername(username);
        //Add crafted resource user resource inventory
        inventoryService.addResourceToInventory(recipe.getResultResource(), user, 1);

        //Update user recipe inventory if user discovered new recipe
        user.getRecipes().add(recipe);
    }
}
