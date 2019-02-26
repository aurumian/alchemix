package iad.dto;

public class ResourceDto {

    public long resourceId;

    public String name;

    public String description;

    public long tier;

    public long imageId;

    public long assetBundleId;

    public ResourceDto(){

    }

    public ResourceDto(long resourceId, String name, String description, long tier, long imageId, long assetBundleId){
        this.name = name;
        this.description = description;
        this.tier = tier;
        this.imageId = imageId;
        this.assetBundleId = assetBundleId;
        this.resourceId = resourceId;
    }

}
