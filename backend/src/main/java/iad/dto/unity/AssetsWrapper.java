package iad.dto.unity;


import iad.model.Asset;

import java.util.List;

public class AssetsWrapper {
    public List<Asset> assets;

    public AssetsWrapper(){

    }

    public AssetsWrapper(List<Asset> assets){
        this.assets = assets;
    }
}
