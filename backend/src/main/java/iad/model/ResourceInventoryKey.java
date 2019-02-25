package iad.model;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ResourceInventoryKey implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    public ResourceInventoryKey(){

    }

    public ResourceInventoryKey(User user, Resource resource){
        this.user = user;
        this.resource = resource;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceInventoryKey)) return false;

        ResourceInventoryKey other = (ResourceInventoryKey) obj;

        return this.resource.getResourceId() == other.resource.getResourceId() &&
                this.user.getUserId() == other.user.getUserId();
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
