### TDD
테스트 주도 개발에서 사용하지만, 코드의 유지보수및 운영 환경에서 에러를 미리 방지하기 위해서
단위별로 검증하는 테스트 프레임워크

* 단위테스트
> 작성한 코드가 기대하는대로 동작을 하는지 검증하는 절차

### Junit
Java 기반의 단위 테스트를 위한 프레임워크
Annotation 기반으로 테스트를 지원하여, Assert를 통하여 예상, 실제를 통해 검증

### 예시
 단순히 덧셈 뺄셈을 해주는 코드가 있다고 해보자.
 
 모든 클래스가 객체 주입을 사용하기 위해서 Bean으로 관리되게 @Component를 활용했다.
 
 ```java
 @Component
@RequiredArgsConstructor
public class Calculator {

    private final ICalculator iCalculator;

    public int sum(int x,int y){
        this.iCalculator.init();
        return this.iCalculator.sum(x,y);
    }

    public int minus(int x,int y){
        this.iCalculator.init();
        return this.iCalculator.minus(x,y);
    }
}
```
```java
@Component
public class MarketApi {

    public int connect(){
        return 1100;
    }
}
```
```java
@Component
@RequiredArgsConstructor
public class DollarCalculator  implements ICalculator{

    private int price=1;
    private final MarketApi marketApi;


    @Override
    public void init(){
        this.price=price;
    }

    @Override
    public int sum(int x, int y) {
        x*=price;
        y*=price;
        return x+y;
    }

    @Override
    public int minus(int x, int y) {
        x*=price;
        y*=price;
        return x-y;
    }
}

```
main에서 실행을 할때 오류가 발생하여, 이를 디버깅을 해본다고 하자.
순차적으로 확인하여 각가의 class들을 모두 뒤져봐야 하며 오류를 하나씩 찾아야 한다.

따라서 기존처럼 main에 모든것을 때려박는 것이 아니라, Test를 하기위한 Test class를 하나 더 만든다.
(Spring의 하단에보면 Test전용 package가 자동으로 만들어져 있다.)


@Test를 붙여서 테스트가 가능하다.

```java
Assertions.asserEquals(20,calculator.sum(10,10))
```
Expected한값(20), 실제로 확일할값(sum)을 기입하여 실행하여 Expected와 일치의 여부를 알려준다.
이과정을 단위테스트 과정이라고 한다.

추가로 Mockito를 어노테이션을 활용하여 실행전에 필수적으로 실행할 것(@BeforeEach)을 활용할 수 있다.

> Mock: 개발자가 직접 제어 할 수 있는 가짜(Mock)객체를 지원하는 테스트 프레임워크.



RestApi를 활용해서 Calculator를 웹에서 실행한다고 해보자.

```java
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalculatorApiController {

    private final Calculator calculator;

    @PostMapping("/sum")
    public int sum(@RequestParam int x,@RequestParam int y){
        return calculator.sum(x,y);
    }

    @PostMapping("/minus")
    public Res minus(@RequestBody Req req){
        int result=calculator.minus(req.getX(), req.getY());
        Res res=new Res();
        res.setResult(result);
        res.setResponse(new Res.Body());

        return res;
    }
}
```
이를 테스트해본다고 하면, URI 주소를 직접 쳐서 들어가서 x,y값을 보내고 일일히 확인하거나,
Talend Api를 이용하여 확인하여야 하지만 이를 Junit으로 테스트를 간단히 할 수 있다.

```java
@SpringBootTest
@Import({MarketApi.class,DollarCalculator.class})
public class DollarCalculatorTest {

    @MockBean//bean으로 관리
    private MarketApi marketApi;

    @Autowired
    private DollarCalculator dollarCalculator;

    @Test
    public void dollarCalculatorTest(){
        Mockito.when(marketApi.connect()).thenReturn(3000);
        dollarCalculator.init();

        int sum=dollarCalculator.sum(10,10);
        int minus=dollarCalculator.minus(10,10);

        Assertions.assertEquals(60000,sum);
        Assertions.assertEquals(0,minus);
    }

}
```
@AutoWire로 저장된 bean을 가져온다.
터미널로 바로 즉각적으로 디버깅이 가능하다.



