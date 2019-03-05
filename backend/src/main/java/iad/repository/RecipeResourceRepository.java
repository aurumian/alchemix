package iad.repository;

import iad.model.RecipeResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RecipeResourceRepository extends CrudRepository<RecipeResource, Long> {

    long countRecipeResourceById_Recipe_RecipeId(Long recipeId);

    @Query("select rr.id.recipe.recipeId from RecipeResource rr where rr.id.resourceId=?1 and rr.quantity=?2")
    Set<Long> getRecipeIds(Long resourceId, long quantity);
}
