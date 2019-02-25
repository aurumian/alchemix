package iad.dto;

public class StoreResource{

    public long resourceId;

    public String name;

    public String description;

    public long tier;

    public long imageId;

    public long quantity;

    public long price;

    public long sellerId;

    public StoreResource(){

    }

    public StoreResource(String name, String description, long tier, long imageId, long quantity, long price, long sellerId, long resourceId){
        this.name = name;
        this.description = description;
        this.tier = tier;
        this.imageId = imageId;
        this.quantity = quantity;
        this.price = price;
        this.sellerId = sellerId;
        this.resourceId = resourceId;
    }
}
