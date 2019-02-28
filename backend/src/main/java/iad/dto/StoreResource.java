package iad.dto;

public class StoreResource extends ResourceDto{

    public long quantity;

    public long price;

    public long sellerId;

    public StoreResource(){

    }

    public StoreResource(String name, String description, long tier, long imageId, long quantity, long price, long sellerId, long resourceId){
        super(resourceId, name, description, tier, imageId, "");
        this.quantity = quantity;
        this.price = price;
        this.sellerId = sellerId;
    }
}
