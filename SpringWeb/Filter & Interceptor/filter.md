# Filter

Filter란 Web Application에서 관리되는 영역으로써 SpringBoot FrameWork에서 Client로부터 오는 요청/응답에 대해서
최초/최종 단계의 위치에서 존재하며, 이를 통해서 요청/응답의 정보를 변경하거나
Spring에 의해서 데이터가 변환되기전의 순수한 Client의 요청/응답값을 확인할 수 있다.

> 유일하게 ServletRequest, ServletReponse의 객체를 반환 할 수 있다.







* Lombok
  > 자바에서 주로 사용하는 라이브러리.

  > 기존에는 Getter/Setter를 만들었지만 LomBok을 사용하면 필요 없다.

  1. @Data: Getter/Setter/equal/toString 모두 자동으로 생성한다.
  2. @Slf4j: log를 사용해서 정보를 찍을 수 있다. (log.info())
  3. NoArgsConstructor: 기본생성자 생성
  4. AllArgsConstructor: 모든 필드에 대한 생성자 생성
