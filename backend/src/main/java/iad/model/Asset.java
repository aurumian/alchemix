package iad.model;

import javax.persistence.*;

@Entity
@Table(name = "ASSET")
public class Asset {

    @Id
    @SequenceGenerator(name = "asset_seq", sequenceName = "asset_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asset_seq")
    @Column(name = "ASSET_ID")
    private Long assetId;

    private String name;

   public Asset(){

   }

    public Asset(String name){
       this.name = name;
   }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
