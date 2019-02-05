package iad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "RECIPE_INVENTORY")
public class RecipeInventory implements Serializable {

    @Id
    @Column(name = "USER_ID")
    private long userId;
    @Id
    @Column(name = "RECIPE_ID")
    private long recipeId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RecipeInventory)) return false;
        RecipeInventory other = (RecipeInventory) obj;
        return this.userId == other.userId && this.recipeId == other.userId;
    }
}
