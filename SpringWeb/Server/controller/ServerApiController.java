package com.example.server.controller;


import com.example.server.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("/hello")
    public User hello(@RequestParam String name,@RequestParam int age){
        User user=new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public User post(@RequestBody User user){

        return user;
    }
    public UserResponse exchange(){
        URI uri=UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand("100","steve")
                .toUri();

        System.out.println(uri);

        UserRequest req=new UserRequest();
        req.setName("steve");
        req.setAge(10);

        RequestEntity<UserRequest>requestEntity=RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","abcd")
                .header("custom-header","fff")
                .body(req);

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<UserResponse>response=restTemplate.exchange(requestEntity, UserResponse.class);

        return response.getBody();

    }

    public UserResponse genericExchange(){
        URI uri=UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand("100","steve")
                .toUri();
        System.out.println(uri);
        UserRequest userRequest=new UserRequest();
        userRequest.setName("steve");
        userRequest.setAge(10);

        Req<UserRequest> req=new Req<UserRequest>();
        req.setHeader(new Req.Header());
        req.setBody(userRequest);

        RequestEntity<Req<UserRequest>>requestEntity=RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","abcd")
                .header("custom-header","fff")
                .body(req);

        RestTemplate restTemplate=new RestTemplate();


        ResponseEntity<Req<UserResponse>> response = restTemplate.exchange(
                requestEntity, new ParameterizedTypeReference<Req<UserResponse>>() {});

        return response.getBody().getBody();
    }
}
