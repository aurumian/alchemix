package iad.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Basic(fetch = FetchType.LAZY)
    @JsonIgnore
    private byte[] data;

   public Asset(){

   }

    public Asset(String name, byte[] data){
       this.name = name;
       this.data = data;
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
