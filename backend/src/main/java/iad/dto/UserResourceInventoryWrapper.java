package iad.dto;

import java.util.List;

public class UserResourceInventoryWrapper {
    public List<ResourceInventoryDto> resources;

    public UserResourceInventoryWrapper(){

    }

    public UserResourceInventoryWrapper(List<ResourceInventoryDto> resources){
        this.resources = resources;
    }
}
