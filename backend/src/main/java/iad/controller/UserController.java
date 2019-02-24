package iad.controller;

import iad.dto.UserDto;
import iad.model.ResourceInventory;
import iad.model.User;
import iad.repository.RoleRepository;
import iad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/api/signup")
    public ResponseEntity<String> saveUser(@RequestParam String username, @RequestParam String password){
        User user = new User(username, passwordEncoder.encode(password), roleRepository.findByRole("ROLE_USER"));
        userRepository.save(user);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/admin/api/addmin")
    public ResponseEntity<String> saveAdmin(@RequestParam String username, @RequestParam String password){
        User user = new User(username, passwordEncoder.encode(password), roleRepository.findByRole("ROLE_ADMIN"));
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    @PostMapping("/admin/api/hesoyam")
    public ResponseEntity<Long> addMoney(@RequestParam long money, Principal principal){
        User user = userRepository.getOneByUsername(principal.getName());
        money += user.getMoney();
        user.setMoney(money);
        userRepository.save(user);
        return ResponseEntity.ok(money);
    }


    @GetMapping("api/user/info")
    public ResponseEntity<UserDto> getUser(Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        return ResponseEntity.ok(new UserDto(user.getUsername(), user.getImageId(), user.getRole().getRole(), user.getMoney()));
    }

    @GetMapping("api/user/inventory")
    public ResponseEntity<List<ResourceInventory>> getInventory(Principal principal){

        List<ResourceInventory> resources  = new ArrayList<>();

        resources.add(new ResourceInventory());

        return ResponseEntity.ok(new ArrayList<>());
    }

}
