package iad.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class RecipeResourceKey implements Serializable {

    private long resourceId;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public RecipeResourceKey(){

    }

    public RecipeResourceKey(long resourceId, Recipe recipe){
        this.resourceId = resourceId;
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RecipeResourceKey))
            return false;

        RecipeResourceKey other = (RecipeResourceKey) obj;

        return this.resourceId == other.resourceId &&
                this.recipe.getRecipeId() == other.recipe.getRecipeId();
    }



    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }
}
