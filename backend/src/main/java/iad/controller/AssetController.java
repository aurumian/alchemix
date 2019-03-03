package iad.controller;

import iad.dto.unity.AssetsWrapper;
import iad.model.Asset;
import iad.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class AssetController {

    @Autowired
    private AssetRepository assetRepository;

    @PostMapping("/admin/api/asset/create")
    public ResponseEntity<Long> saveAssetBundle(@RequestParam MultipartFile file) throws IOException {

        Asset asset = assetRepository.save(new Asset(file.getOriginalFilename(), file.getBytes()));

        return ResponseEntity.ok(asset.getAssetId());
    }

    @GetMapping("/admin/api/asset/table")
    public ResponseEntity<List<Asset>> getAssets(){
        return ResponseEntity.ok(assetRepository.findAll());
    }


    @GetMapping("/admin/api/asset/assets")
    public ResponseEntity<AssetsWrapper> getAssetsWrapped(){
        return ResponseEntity.ok(new AssetsWrapper(assetRepository.findAll()));
    }

    @GetMapping("/api/asset/get/**")
    public ResponseEntity<byte[]> getAssetBundle(HttpServletRequest request){

        String name = request.getRequestURI();
        name = name.substring(15);

        System.out.println("fetching asset: " + name);

        return ResponseEntity.ok().body(assetRepository.getByName(name).getData());
    }
}
