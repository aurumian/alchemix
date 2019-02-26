package iad.dto;

public class ResourceDto {

    public String name;

    public String description;

    public long tier;

    public long imageId;

    public long assetBundleId;

    public ResourceDto(){

    }

    public ResourceDto(String name, String description, long tier, long imageId, long assetBundleId){
        this.name = name;
        this.description = description;
        this.tier = tier;
        this.imageId = imageId;
        this.assetBundleId = assetBundleId;
    }

}
