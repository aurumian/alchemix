package iad.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RESOURCE_INVENTORY")
public class ResourceInventory {

    @EmbeddedId
    private ResourceInventoryKey resourceInventoryKey;
    private int quantity;

    public ResourceInventoryKey getResourceInventoryKey() {
        return resourceInventoryKey;
    }

    public void setResourceInventoryKey(ResourceInventoryKey resourceInventoryKey) {
        this.resourceInventoryKey = resourceInventoryKey;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

@Embeddable
class ResourceInventoryKey implements Serializable {
    @Column(name = "USER_ID", nullable = false)
    private long userId;
    @Column(name = "RESOURCE_ID", nullable = false)
    private long resourceId;

    protected ResourceInventoryKey(){

    }

    public ResourceInventoryKey(long userId, long resourceId){
        this.userId = userId;
        this.resourceId = resourceId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof ResourceInventoryKey)) return false;
        ResourceInventoryKey other = (ResourceInventoryKey) o;
        return this.userId == other.userId && this.resourceId == other.resourceId;
    }
}
