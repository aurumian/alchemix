package iad.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ResourceOnSaleKey implements Serializable {
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "user_id")
    private User seller;

    public ResourceOnSaleKey(){}

    public ResourceOnSaleKey(User seller, Resource resource){
        this.resource = resource;
        this.seller = seller;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceOnSaleKey)) return false;

        ResourceOnSaleKey other = (ResourceOnSaleKey) obj;

        return this.resource.getResourceId() == other.resource.getResourceId() &&
                this.seller.getUserId() == other.seller.getUserId();
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
