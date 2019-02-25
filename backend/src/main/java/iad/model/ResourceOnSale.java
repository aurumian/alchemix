package iad.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "resource_on_sale")
public class ResourceOnSale implements Serializable {

    @EmbeddedId
    private
    ResourceOnSaleKey id;

    private long quantity;

    private long price;

    public ResourceOnSale(){

    }

    public ResourceOnSale(long quantity, long price, User seller, Resource resource){
        this.quantity = quantity;
        this.price = price;
        setId(new ResourceOnSaleKey(seller, resource));
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

    public ResourceOnSaleKey getId() {
        return id;
    }

    public void setId(ResourceOnSaleKey id) {
        this.id = id;
    }
}

@Embeddable
class ResourceOnSaleKey implements Serializable{
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
