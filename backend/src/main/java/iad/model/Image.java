package iad.model;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @Column(name = "IMAGE_ID")
    @SequenceGenerator(name = "image_seq", sequenceName = "image_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq")
    private long imageId;

    private String name;

    @Basic(fetch = FetchType.LAZY)
    private byte[] data;

    public Image(){ }

    public Image(byte[] data, String name){
        this.data = data;
        this.name = name;
    }

    public Image(long imageId, String name){
        this.imageId = imageId;
        this.name = name;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
