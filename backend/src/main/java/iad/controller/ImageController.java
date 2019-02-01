package iad.controller;

import iad.model.Image;
import iad.repository.ImageRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
public class ImageController {

    private ImageRepository imageRepository;

    public ImageController(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

    @PostMapping("api/image/upload")
    public ResponseEntity<String> saveImage(@RequestParam("file") MultipartFile file){
        try {
            Image image = new Image(file.getBytes());
            imageRepository.save(image);
            return new ResponseEntity<>("image saved", HttpStatus.OK);
        } catch (IOException e){
            return new ResponseEntity<>("image was not saved", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("api/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable long id){
        Optional<Image> imageOptional = imageRepository.findById(id);


        ResponseEntity<byte[]> responseEntity;
        if (imageOptional.isPresent()){
            responseEntity = new ResponseEntity<>(imageOptional.get().getData(), HttpStatus.OK);
        }
        else
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return responseEntity;
    }
}
