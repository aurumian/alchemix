package iad.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "resource_on_sale")
public class ResourceOnSale implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @Id
    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "user_id")
    private User seller;

    private long quantity;

    private long price;

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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceOnSale)) return false;

        ResourceOnSale other = (ResourceOnSale) obj;

        return this.resource.getResourceId() == other.resource.getResourceId() &&
                this.seller.getUserId() == other.seller.getUserId();
    }
}
