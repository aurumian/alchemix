package iad.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RESOURCE_INVENTORY")
public class ResourceInventory implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceInventory)) return false;

        ResourceInventory other = (ResourceInventory) obj;

        return this.resource.getResourceId() == other.resource.getResourceId() &&
                this.user.getUserId() == other.user.getUserId();
    }
}

