package iad.controller;

import iad.dto.ImageRow;
import iad.model.Image;
import iad.repository.ImageRepository;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    private ImageRepository imageRepository;

    public ImageController(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> saveImage(@RequestParam("file") MultipartFile file){
        try {
            Image image = new Image(file.getBytes(), file.getOriginalFilename());
            imageRepository.save(image);
            return new ResponseEntity<>("image saved", HttpStatus.OK);
        } catch (IOException e){
            return new ResponseEntity<>("image was not saved", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable long id){
        Optional<Image> imageOptional = imageRepository.findById(id);

        ResponseEntity<byte[]> responseEntity;
        if (imageOptional.isPresent()){
            responseEntity = ResponseEntity.ok().cacheControl(CacheControl.maxAge(7, TimeUnit.DAYS))
                    .body(imageOptional.get().getData());
        }
        else
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return responseEntity;
    }


    @GetMapping
    public ResponseEntity<List<ImageRow>> getImages(){
        List<ImageRow> rows = imageRepository.getImageRows();

        if (rows != null){
            return ResponseEntity.ok(rows);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
