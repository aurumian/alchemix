package iad.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "recipe_resource")
public class RecipeResource {
    @EmbeddedId
    private RecipeResourceKey id;

    private long quantity;

    public RecipeResource(){

    }

    public RecipeResource(RecipeResourceKey id, long quantity){
        this.id = id;
        this.quantity = quantity;
    }

    public RecipeResourceKey getId() {
        return id;
    }

    public void setId(RecipeResourceKey id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
