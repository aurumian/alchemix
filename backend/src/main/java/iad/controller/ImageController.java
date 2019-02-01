package iad.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {

    @PostMapping
    public ResponseEntity<String> saveImage(MultipartFile file){

        return null;
    }

    @GetMapping
    public ResponseEntity<byte[]> getImage(){


        return null;
    }
}
