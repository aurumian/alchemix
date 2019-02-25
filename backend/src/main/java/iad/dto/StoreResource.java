package iad.dto;

public class StoreResource{

    public String name;

    public String description;

    public long tier;

    public long imageId;

    public long quantity;

    public long price;

    public StoreResource(){

    }

    public StoreResource(String name, String description, long tier, long imageId, long quantity, long price){
        this.name = name;
        this.description = description;
        this.tier = tier;
        this.imageId = imageId;
        this.quantity = quantity;
        this.price = price;
    }
}
