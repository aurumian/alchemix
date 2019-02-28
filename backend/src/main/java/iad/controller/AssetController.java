package iad.controller;

import iad.model.Asset;
import iad.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class AssetController {

    @Autowired
    private AssetRepository assetRepository;

    @PostMapping("/admin/api/asset/create")
    public ResponseEntity<Long> saveAssetBundle(@RequestParam String name) {

        Asset asset = assetRepository.save(new Asset(name));

        return ResponseEntity.ok(asset.getAssetId());
    }

    @GetMapping("/admin/api/asset/table")
    public ResponseEntity<List<Asset>> getAssetBundles(){
        return ResponseEntity.ok(assetRepository.findAll());
    }

}
