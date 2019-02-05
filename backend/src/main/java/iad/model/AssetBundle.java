package iad.model;

import javax.persistence.*;

@Entity
@Table(name = "ASSET_BUNDLE")
public class AssetBundle {

    @Id
    @SequenceGenerator(name = "asset_bundle_seq", sequenceName = "asset_bundle_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asset_bundle_seq")
    @Column(name = "ASSET_BUNDLE_ID")
    private long assetBundleId;

    private byte[] bundle;

    public long getAssetBundleId() {
        return assetBundleId;
    }

    public void setAssetBundleId(long assetBundleId) {
        this.assetBundleId = assetBundleId;
    }

    public byte[] getBundle() {
        return bundle;
    }

    public void setBundle(byte[] bundle) {
        this.bundle = bundle;
    }
}
