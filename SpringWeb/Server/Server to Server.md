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
  



    
### Header 요청

Server 쪽에서 따로 header를 요청할때가 있다. 이때 client가 header처리를 해서 server에게 보내면 된다.

* client

```java
RequestEntity<UserRequest>requestEntity=RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","abcd")
                .header("custom-header","fff")
                .body(req);

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<UserResponse>response=restTemplate.exchange(requestEntity, UserResponse.class);
```

서버에 값을 보낼때는 RequestEntity를 사용한다.
이후 exchange()를 호출하여 원하는 보낼 수 있다.


##### Jason의 값이 항상 일정한것은 아니다!

Jason이 항상 값이 내려오면 별다른 처리없이 이렇게만 설계한다면 문제가 없을것이지만, 현실은 눈물난다.
안타깝게도 값이 계속계속 변화되어 올 수도 있고 고정될수도 있다.

```jason
{
  "header":{},
  "body":{
  "name":"spring",
  "age":1024
    }
}

```

header, body는 고정이지만 그 안의 값은 계속 변할 수 있다. header안에 다른값이들어가고, body안에 다른값이 계속계속 들어갈 수 있다는 것이다.
따라서 이 처리하는 방법을 알아야한다.


* client

```java
public class Req<T> {

    private Header header;

    private T body;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Header{
        private String responseCode;
    }
}
```
```java
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
```

제네릭 클래스를 하나 더 만들어 header와 body를 받도록 한다.
body가 제네릭 타입이기 때문에 Ueser Request라고 하게되면 name,age를 받거나 혹은 다른 클래스를 만들어 또다른 타입으로 받게 할 수 있다.
header도 다른 값을 받도록 하고 싶다면 동일하게 하면 된다.


> 주의해야 할점은 Req<T>이기 때문에 ResponseEntity를 사용할때 한번더 감싸야한다.
  
> Req<UserResponse>.class가 불가능하다. 제네릭은 class사용이 불가능 하기 때문이다. 따라서 이를 대체하기 위해  new ParameterizedTypeReference<Req<UserResponse>>()를 사용해야 한다.







