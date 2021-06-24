package controller;

import dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    //text
    @GetMapping("/text")
    public String String_text(@RequestParam String account){
        return account;
    }

    //JSon
    @PostMapping
    public User json(@RequestBody User user){
        return user;
    }

    //ResponsEntity
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


}
