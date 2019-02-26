package iad.dto;

public class ResourceInventoryDto extends ResourceDto{


    public long quantity;

    public ResourceInventoryDto(){

    }

    public ResourceInventoryDto(long resourceId, String name, String description, long tier, long imageId, long assetBundleId, long quantity){
        super(resourceId, name, description, tier, imageId, assetBundleId);
        this.quantity = quantity;
    }
}
