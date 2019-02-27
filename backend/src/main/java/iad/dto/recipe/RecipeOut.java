package iad.dto.recipe;

import iad.dto.ResourceDto;
import iad.dto.ResourceInventoryDto;

import java.util.LinkedList;
import java.util.List;

public class RecipeOut {

    public ResourceDto resResource;

    public List<ResourceInventoryDto> resources;

    public RecipeOut(){

    }

    public RecipeOut(ResourceDto resResource){
        this.resResource = resResource;
        this.resources = new LinkedList<>();
    }
}
