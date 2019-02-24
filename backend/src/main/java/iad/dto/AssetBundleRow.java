package iad.dto;

import java.io.Serializable;

public class AssetBundleRow implements Serializable {
    private long assetBundleId;

    private String name;

    public AssetBundleRow(){

    }

    public AssetBundleRow(long assetBundleId, String name){
        this.assetBundleId = assetBundleId;
        this.name = name;
    }

    public long getAssetBundleId() {
        return assetBundleId;
    }

    public void setAssetBundleId(long assetBundleId) {
        this.assetBundleId = assetBundleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
