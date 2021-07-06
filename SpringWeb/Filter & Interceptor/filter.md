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

따라서 각

이후에 Client는 아무 응답을 받지 못하는데 마찬가지로 body의 커서가 맨 뒤에 있기때문이다.
따라서 httpServletResponse.CopyBodyToResponse()로 내용을 복사해서 내용을 채워넣는다.




* Lombok
  > 자바에서 주로 사용하는 라이브러리.

  > 기존에는 Getter/Setter를 만들었지만 LomBok을 사용하면 필요 없다.

  1. @Data: Getter/Setter/equal/toString 모두 자동으로 생성한다.
  2. @Slf4j: log를 사용해서 정보를 찍을 수 있다. (log.info())
  3. NoArgsConstructor: 기본생성자 생성
  4. AllArgsConstructor: 모든 필드에 대한 생성자 생성
