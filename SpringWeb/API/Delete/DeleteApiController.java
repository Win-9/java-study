package com.example.delete.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class DeleteApiController {

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable String userId, @RequestParam String account){
        System.out.println(userId);
        System.out.println(account);
    }
}
