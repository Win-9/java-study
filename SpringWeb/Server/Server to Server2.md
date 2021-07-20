# Header 요청

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


### Jason의 값이 항상 일정한것은 아니다!

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





