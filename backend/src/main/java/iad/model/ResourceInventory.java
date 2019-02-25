package iad.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RESOURCE_INVENTORY")
public class ResourceInventory implements Serializable{

    @EmbeddedId
    private ResourceInventoryKey id;

    private long quantity;

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public ResourceInventory(){

    }

    public ResourceInventory(ResourceInventoryKey id, long quantity){
        this.id = id;
        this.quantity = quantity;
    }

    public ResourceInventoryKey getId() {
        return id;
    }

    public void setId(ResourceInventoryKey id) {
        this.id = id;
    }
}

