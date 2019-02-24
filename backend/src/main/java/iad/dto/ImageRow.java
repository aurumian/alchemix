package iad.dto;

import java.io.Serializable;

public class ImageRow implements Serializable {
    private Long imageId;
    private String name;
    private String image;

    public ImageRow(Long imageId, String name){
        this.imageId = imageId;
        this.name = name;
        this.image = "<img src='/api/image/" + imageId + "'>";
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
