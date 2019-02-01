package iad.model;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @Column(name = "IMAGE_ID")
    @SequenceGenerator(name = "image_seq", sequenceName = "image_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq")
    private long imageId;

    @Lob
    private byte[] data;

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
}
