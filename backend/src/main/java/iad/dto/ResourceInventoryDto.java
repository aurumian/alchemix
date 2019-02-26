package iad.dto;

public class ResourceInventoryDto extends ResourceDto{


    public long quantity;

    public ResourceInventoryDto(){

    }

    public ResourceInventoryDto(String name, String description, long tier, long imageId, long assetBundleId, long quantity){
        super(name, description, tier, imageId, assetBundleId);
        this.quantity = quantity;
    }
}
