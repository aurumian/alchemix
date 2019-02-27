package iad.dto.recipe;

public class ResourceIn {
    public long resourceId;

    public long quantity;

    public ResourceIn(){

    }

    public ResourceIn(long resourceId, long quantity){
        this.resourceId = resourceId;
        this.quantity = quantity;
    }
}
