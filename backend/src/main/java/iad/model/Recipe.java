package iad.model;

import javax.persistence.*;

@Entity
public class Recipe {

    @Id
    @SequenceGenerator(name = "recipe_seq", sequenceName = "recipe_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_seq")
    @Column(name = "RECIPE_ID")
    private long recipeId;
    @Column(name = "RESULT_RESOURCE_ID")
    private long resultResoutceId;

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    public long getResultResoutceId() {
        return resultResoutceId;
    }

    public void setResultResoutceId(long resultResoutceId) {
        this.resultResoutceId = resultResoutceId;
    }
}
