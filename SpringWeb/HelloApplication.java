package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path="/hello")
    public String getHello(){
        return "get Hello";
    }

    @GetMapping("/path-variable{name}")
    public String pathVariable(@PathVariable(name="name") String pathname){
        System.out.println("PathVal:"+pathname);

        return pathname;
    }
    @GetMapping(path="query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam){
        StringBuilder sb=new StringBuilder();
        queryParam.entrySet().forEach(entry->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("/n");

            sb.append(entry.getKey()+"="+entry.getValue()+"/n");
        });
        return sb.toString();
    }

    @GetMapping(path="query-param02")
    public String queryParam02(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam int age
    ){
        return name+" "+email+" "+age;
    }

}
