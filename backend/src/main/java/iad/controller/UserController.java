package iad.controller;

import iad.dto.UserDto;
import iad.model.User;
import iad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/signup")
    public ResponseEntity<User> saveUser(@RequestParam String username, @RequestParam String password){
        User user = new User(username, passwordEncoder.encode(password));
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user));
    }


    @GetMapping("api/user/info")
    public ResponseEntity<UserDto> getUser(){
        //change to getting currently authenticated user's information
        return ResponseEntity.ok(new UserDto("name", 5, "ROLE_USER", 100));
    }
}
