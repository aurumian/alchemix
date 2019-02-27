package iad.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @SequenceGenerator(name = "recipe_seq", sequenceName = "recipe_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_seq")
    @Column(name = "RECIPE_ID")
    private long recipeId;

    @ManyToOne
    @JoinColumn(name = "RESULT_RESOURCE_ID", referencedColumnName = "resource_id")
    private Resource resultResource;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id.recipe")
    private Set<RecipeResource> resources;

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }


    public Resource getResultResource() {
        return resultResource;
    }

    public void setResultResource(Resource resultResource) {
        this.resultResource = resultResource;
    }

    public Set<RecipeResource> getResources() {
        return resources;
    }

    public void setResources(Set<RecipeResource> resources) {
        this.resources = resources;
    }
}
