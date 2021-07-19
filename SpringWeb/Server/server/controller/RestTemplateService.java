package com.example.client.server;


import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    public UserResponse hello(){
        URI uri= UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name","steve")
                .queryParam("age",10)
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<UserResponse> result=restTemplate.getForEntity(uri,UserResponse.class);

        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();
    }
    public UserRequest post(){
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

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<UserRequest> response=restTemplate.postForEntity(uri,userRequest,UserRequest.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

        return response.getBody();
    }
}
