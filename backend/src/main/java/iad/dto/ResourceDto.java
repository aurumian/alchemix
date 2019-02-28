package iad.dto;

public class ResourceDto {

    public long resourceId;

    public String name;

    public String description;

    public long tier;

    public long imageId;

    public String assetName;

    public ResourceDto(){

    }

    public ResourceDto(long resourceId, String name, String description, long tier, long imageId, String assetName){
        this.name = name;
        this.description = description;
        this.tier = tier;
        this.imageId = imageId;
        this.assetName = assetName;
        this.resourceId = resourceId;
    }

}
