# Get server연결



### Get

* client

```java
    private final RestTemplateService restTemplateService;

    public ApiController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }


    @GetMapping("/hello")
    public UserResponse getHello(){
        return restTemplateService.hello();
    }
```
```java
public UserResponse hello(){
        URI uri= UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
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
```

* UriComponentsBuilder

> 서버로 연결할 주소를 지정한다.

> path로 주소를 지정하는것 이외에도 query-param을 넣어 줄 수도 있다.

* getForObject
> 지정한 타입으로 return을 받을 수 있다.

* getForEntity
> Reponse Entity<T>로 타입을 지정해서 받을 수 있다.

> 이때 result에는 여러가지 값들이 들어가는데 result.statusCode()로 상태코드를 볼 수 있고, result.getBody()로 response body를 확인 가능하다.
  
  
  

* Server

```java
@GetMapping("/hello")
    public User hello(@RequestParam String name,@RequestParam int age){
        User user=new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }
```

localhost:8080/hello를 호출하게 되면 client의 hello()로 들어가게 되어서 UriComponentsBuilder로 만든 uri를 접속하게 된다. 이후 이 주소로 연결된
server를 요청하게 되어서 user가 return되는 에코이다.
  
  Json 형태로 값을 내릴때도 getForEntity<dto>로 값을 받은다음, 동일하게 처리해주면 된다.
  
  Get이라는 API를 통해 서버라 어떠한 데이터를 줄 지 규격이 정해지면 JSon 표준 규격을 보고 class를 완성한 다음,
  get이나 post형태로 값을 보낸다.
  
  > 단 get은 단순히 주소를 호출하면 되지만, post는 RequestBody로 값을 보내야 한다.
  
  
### Post
  
  getForEntity대신 postForEntity를 사용하고, 이후 동일하게 수행한다.
  
  ```java
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
```
  
path이후에 expand로 query-param을 지정할 수 있다.
Server에서는 기존과 동일하게 PostMapping으로 Uri를 할당한 다음 @RequestBody로 파라미터를 받고 필요한 처리를 해준다.
  




