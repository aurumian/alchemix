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

