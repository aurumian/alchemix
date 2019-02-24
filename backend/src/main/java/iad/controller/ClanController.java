package iad.controller;

import iad.dto.ClanDto;
import iad.model.Clan;
import iad.model.Image;
import iad.model.User;
import iad.repository.ClanRepository;
import iad.repository.ImageRepository;
import iad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/clan")
public class ClanController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ClanRepository clanRepository;

    @PostMapping("/create")
    public ResponseEntity<String> createClan(@RequestParam String name, @RequestParam(required = false) MultipartFile file, Principal principal) throws IOException {

        User user = userRepository.findByUsername(principal.getName());

        if (clanRepository.existsByName(name)) return ResponseEntity.badRequest().body("Clan name already exists");
        if (clanRepository.existsByClansmen(user)) return ResponseEntity.badRequest().body("User is already in a clan");

        long imageId;
        if (file != null){
            imageId = imageRepository.save(new Image(file.getBytes(), file.getOriginalFilename())).getImageId();
        }
        else imageId = 18;

        Clan clan = new Clan(name, user, imageId);

        user.setClan(clan);

        clanRepository.save(clan);

        return ResponseEntity.ok("Clan created");
    }


    @GetMapping("/get")
    public ResponseEntity<List<ClanDto>> getClans(){
        return ResponseEntity.ok(clanRepository.getRows());
    }
}
