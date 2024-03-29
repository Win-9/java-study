package com.example.server.controller;


import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
@RequestMapping("/api/server")
@Slf4j
public class ServerApiController {

    //https://openapi.naver.com/v1/search/local.json?
    // query=%EC%A3%BC%EC%8B%9D
    // &display=10
    // &start=1
    // &sort=random
    @GetMapping("/naver")
    public String naver(){

        String query="조유진";
        String encode= Base64.getEncoder().encodeToString(query.getBytes(StandardCharsets.UTF_8));

        URI uri= UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .queryParam("query","조유진")
                .queryParam("display",10)
                .queryParam("start",1)
                .queryParam("sort","random")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        RestTemplate restTemplate=new RestTemplate();

        RequestEntity<Void>req=RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id","GWfP0exvbNWuOLtsQruq")
                .header("X-Naver-Client-Secret","c7KDiO7jlG")
                .build();


        ResponseEntity<String> result=restTemplate.exchange(req,String.class);

        return result.getBody();
    }

    @GetMapping("/hello")
    public User hello(@RequestParam String name,@RequestParam int age){
        User user=new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public Req<User> post(@RequestBody Req<User> user,
                          @PathVariable int userId,
                          @PathVariable String userName,
                          @RequestHeader("x-authorization") String authorization,
                          @RequestHeader("custom-header")String customheader){
        log.info("userId:{},username:{}",userId,userName);
        log.info("authorization:{},cutom{}",authorization,customheader);
        log.info("client req:{}",user);

        Req<User>response=new Req<>();
        response.setHeader(new Req.Header());
        response.setBody(user.getBody());
        return response ;
    }
}
