package iad.controller;

import java.io.Serializable;

public class ImageRow implements Serializable {
    private Long imageId;
    private String image;

    public ImageRow(Long imageId){
        this.imageId = imageId;
        this.image = "<img src='/api/image/" + imageId + "' height='80px'>";
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
}
