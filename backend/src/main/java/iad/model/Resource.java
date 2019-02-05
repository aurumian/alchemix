package iad.model;

import javax.persistence.*;

@Entity
public class Resource {

    @Id
    @SequenceGenerator(name = "resource_seq", sequenceName = "resource_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resource_seq")
    @Column(name = "RESOURCE_ID")
    private long resourceId;

    private String name;

    private long tier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMAGE_ID")
    private Image image;

    @Column(name = "ASSET_BUNDLE_ID")
    private long assetBundleId;

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
}
