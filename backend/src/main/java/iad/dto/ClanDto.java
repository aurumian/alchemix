package iad.dto;

import java.io.Serializable;

public class ClanDto implements Serializable {

    private String name;

    private String description;

    private long imageId;

    public ClanDto(){

    }

    public ClanDto(String name, String description, long imageId){
        this.name = name;
        this.description = description;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }
}
