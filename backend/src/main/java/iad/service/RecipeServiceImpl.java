package iad.service;

import iad.dto.ResourceDto;
import iad.dto.ResourceInventoryDto;
import iad.dto.recipe.RecipeIn;
import iad.dto.recipe.RecipeOut;
import iad.dto.recipe.ResourceIn;
import iad.model.*;
import iad.repository.RecipeRepository;
import iad.repository.RecipeResourceRepository;
import iad.repository.ResourceRepository;
import iad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeResourceRepository recipeResourceRepository;

    @Override
    public void addRecipe(RecipeIn recipeIn) {
        Recipe recipe = new Recipe();
        Resource resResource = resourceRepository.findByResourceId(recipeIn.resResourceId);

        if (resResource == null)
            throw new IllegalArgumentException("No resource found with resResourceId " + recipeIn.resResourceId);

        //See if recipe with the same recipe_resources exists
        Set<Long> recipes = recipeResourceRepository.getRecipeIds(recipeIn.resources.get(0).resourceId,
                recipeIn.resources.get(0).quantity);
        int count = 1;
        while (count < recipeIn.resources.size() && recipes.size() > 0){
            recipes.retainAll(recipeResourceRepository.getRecipeIds(recipeIn.resources.get(count).resourceId,
                    recipeIn.resources.get(count).quantity));
            count ++;
        }
        Recipe other = null;

        //look through resulting recipes for one with the same number of ingredients as the recipeIn's
        for (long recipeId: recipes)
            if (recipeResourceRepository.countRecipeResourceById_Recipe_RecipeId(recipeId) == recipeIn.resources.size()){
                other = recipeRepository.findOneByRecipeId(recipeId);
                break;
            }
        if (other != null)
            throw new RuntimeException("Recipe with this ingredients exists");

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
