# Filter

Filter란 Web Application에서 관리되는 영역으로써 SpringBoot FrameWork에서 Client로부터 오는 요청/응답에 대해서
최초/최종 단계의 위치에서 존재하며, 이를 통해서 요청/응답의 정보를 변경하거나
Spring에 의해서 데이터가 변환되기전의 순수한 Client의 요청/응답값을 확인할 수 있다.

> 유일하게 ServletRequest, ServletReponse의 객체를 반환 할 수 있다.



```java
@WebFilter(urlPatterns = "/api/*")
public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ContentCachingRequestWrapper wrappingRequest = new ContentCachingRequestWrapper((HttpServletRequest)request);
        ContentCachingResponseWrapper wrappingResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);

        chain.doFilter(wrappingRequest, wrappingResponse);

        System.out.println("---req ---");
        System.out.println(new String(wrappingRequest.getContentAsByteArray(),"UTF-8"));
        byte[] b = wrappingRequest.getContentAsByteArray();
        System.out.println("---req ---");

        System.out.println("---res ---");
        System.out.println(new String(wrappingResponse.getContentAsByteArray(),"UTF-8"));
        System.out.println("---res ---");
        wrappingResponse.copyBodyToResponse();
    }
}
```
chain 전에있는 부분을 전처리, chain후에 있는 부분을 후처리 라고할때, 동작순서는 전처리-> chain-> 후처리 순으로 실행이 된다.

요청을 하게되면 우선적으로 Filter를 거치게 된다. 이 Filter부분에서 read()를 해버리기 때문에 커서는 맨뒤로가있는 상태에서 controller로 가기때문에
컴파일러가 읽을수가 없게되어 오류가 발생한다.

따라서 각각 Request a Response 를 Content caching Request wrapper/Response wrapper 로 변환

+ 당장 들어 왔을 때 Read 를 하지 않는다. do Filter 를 통해 실제 내부 stream 안으로 들어가야 그 메소드가 시행이 되서
Request란 내용이 Content 에 담겨 읽을 수 있다.
∴ do Filter 이후 내용을 읽어야 한다.

이후에 Client는 아무 응답을 받지 못하는데 마찬가지로 body의 커서가 맨 뒤에 있기때문이다.
따라서 httpServletResponse.CopyBodyToResponse()로 내용을 복사해서 내용을 채워넣는다.




* Lombok
  > 자바에서 주로 사용하는 라이브러리.

  > 기존에는 Getter/Setter를 만들었지만 LomBok을 사용하면 필요 없다.

  1. @Data: Getter/Setter/equal/toString 모두 자동으로 생성한다.
  2. @Slf4j: log를 사용해서 정보를 찍을 수 있다. (log.info())
  3. NoArgsConstructor: 기본생성자 생성
  4. AllArgsConstructor: 모든 필드에 대한 생성자 생성


# InterCeptor

InterCeptor란 Filter와 매우 유사한 형태로 존재하지만, 차이점은 Spring Context에 등록된다. AOP와 유사한 기능을 제공 할 수있으며 주로
인증단계를 처리하거나, Logging을 하는데 사용한다.

![image](https://user-images.githubusercontent.com/80390524/124606831-3b8e8500-dea8-11eb-924d-3f9f697ad8cc.png)


```java
@RestController
@RequestMapping("/api/private")
@Auth
public class PrivateController {

    @GetMapping
    public String hello(){
        return "private hello";
    }
}
```

세션을 검사하여 @Auth가 있는 controller는 통과하고 , 없으면 통과하지 못하도록 한다.
PrivateController는 @Auth가 있기 때문에 true를 return 하고,
@Auth가 없는 publicController는 false를 return 하게된다. 

> False에 대한 Exception처리도 가능하다.


```java
@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url=request.getRequestURI();
        URI uri =UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build()
                .toUri();


        log.info("request url:{}",url);
        boolean hasAnnotaion=checkAnnotation(handler, Auth.class);
        log.info("has annotation:{}",hasAnnotaion);

        //all Public
        //Auth권한을 가진 요청에 대해서는 세션,쿠키

        if(hasAnnotaion){
            //권한체크
            String query=uri.getQuery();
            if(query.equals("name=steve")){
                return true;
            }
            return false;
        }

        return true;
    }

    public boolean checkAnnotation(Object handler,Class clazz){
        if(handler instanceof ResourceHttpRequestHandler){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod) handler;

        if(null!=handlerMethod.getMethodAnnotation(clazz)||null!=handlerMethod.getBeanType().getAnnotation(clazz)){
            return true;
        }
        return false;
    }
}
```
InterCeptor에서 리소스가 HTML파일이거나 그외 리소스에 대한 요청이면 통과, 어노테이션을 가지고 있으면 true를 return한다.
> return false이면 동작하지 않는다.

어노테이션의 유뮤를 가지고 처리를 할 수 있고 , 특정 URL에 대하여 제외하고 싶으면 addPattern 도는 ExcludePattern으로 패턴을 추가하거나 제외시킬 수 있다.

> @Auth가 메소드에도 붙힐 수 있다. 따라서 특정 Controller에서 특정 메소드만 검사를 하고 싶으면 사용해도 좋이지만 , 일관성이 떨어지고 유지보수하기도 힘들기 때문에
> Controller나 URL에서만 사용하는것이 좋다.


