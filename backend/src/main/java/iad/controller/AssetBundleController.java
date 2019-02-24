package iad.controller;

import iad.dto.AssetBundleRow;
import iad.model.AssetBundle;
import iad.repository.AssetBundleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class AssetBundleController {

    @Autowired
    private AssetBundleRepository assetBundleRepository;

    @PostMapping("/admin/api/asset_bundle/add")
    public ResponseEntity<Long> saveAssetBundle(@RequestParam MultipartFile file) throws IOException {

        AssetBundle assetBundle = assetBundleRepository.save(new AssetBundle(file.getOriginalFilename(), file.getBytes()));

        return ResponseEntity.ok(assetBundle.getAssetBundleId());
    }

    @GetMapping("/admin/api/asset_bundle/table")
    public ResponseEntity<List<AssetBundleRow>> getRows(){
        return ResponseEntity.ok(assetBundleRepository.getRows());
    }

    @GetMapping("/api/asset_bundle/get/{name}")
    public ResponseEntity<byte[]> getAssetBundle(@PathVariable String name){
        return ResponseEntity.ok(assetBundleRepository.getByName(name).getBundle());
    }

}
