package iad.model;

import iad.dto.ResourceDto;

import javax.persistence.*;

@Entity
public class Resource {

    @Id
    @SequenceGenerator(name = "resource_seq", sequenceName = "resource_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resource_seq")
    @Column(name = "RESOURCE_ID")
    private long resourceId;

    private String name;

    private String description;

    private long tier;

    @Column(name = "IMAGE_ID")
    private long imageId;

    @Column(name = "ASSET_BUNDLE_ID")
    private long assetBundleId;

    public Resource(){

    }

    public Resource(ResourceDto resourceDto){
        this.name = resourceDto.name;
        this.tier = resourceDto.tier;
        this.imageId = resourceDto.imageId;
        this.assetBundleId = resourceDto.assetBundleId;
        this.description = resourceDto.description;
    }

    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public long getTier() {
        return tier;
    }

    public void setTier(long tier) {
        this.tier = tier;
    }

    public long getAssetBundleId() {
        return assetBundleId;
    }

    public void setAssetBundleId(long assetBundleId) {
        this.assetBundleId = assetBundleId;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
