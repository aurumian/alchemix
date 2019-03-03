package iad.controller;

import iad.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @CrossOrigin("*")
    @GetMapping("/api/file/get/**")
    public ResponseEntity getAssetBundle(HttpServletRequest request){

        String filename = request.getRequestURI();
        filename = filename.substring(14);

        System.out.println("fetching file: " + filename);



        return ResponseEntity.ok()/*.header("Access-Control-Allow-Origin", "*")*/.body(fileRepository.getByFilename(filename));
    }
}
