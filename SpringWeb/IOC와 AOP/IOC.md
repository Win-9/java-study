# IOC

스프링에서는 일반적인 자바객체를 new로 생성하여 개발자가 관리하는 것이 아닌 spring container에 모두 맡긴다.
즉, 개발자에서 프레임 원크로 제어의 객체관리의 권한이 넘어간다. 이를 제어의 역전이라고 한다.

# DI
외무로부터 내가 사용할 객체를 주입을 받는다.
- 의존성으로부터 격리되어서 코드테스트용이=> 안전적인 테스트가 가능하다.
- 코드를 확장하거나 변경할때 영향을 최소화 한다.(추상화)

### 예제로 이해하기
```java
public class Encoder {

    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder){
        //this.iEncoder = new UrlEncoder();
        this.iEncoder = new Base64Encoder();
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
```
URL을 Encoder로 바꾸거나, 반대로 바꿀때 계속 생성자를 변환시켜 비효율 적이다.(base로 요청하면 주석처리후 생성자를 바꾸고, 다시 url로 하려면 주석처리후 다시바꾼다.)
혹여나 타입이 여러개인경우 복잡해지기때문에 생성자를 주입하는 DI식으로 바꾼다.

```java
public class Encoder {

    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
```
```java
public class Main {

    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        Encoder encoder = new Encoder(new Base64Encoder());
        String result = encoder.encode(url);
	    System.out.println(result);
    }
}
```
URL을 Encode를 할때 Encode자체를 바꿀 필요 없이 주입하는 객체만 바꾸어 주면된다. 코드의 관리나 재사용이 훨씬 간결해지며 , 후에 다른 Base32를 만들어야 할때 Encdoe나 Base 64를 건들
필요없이 IEncode 인터페이스를 implements하여 주입하는객체만 바꾸어주면 된다.

이를 IOC식으로 객체자체를 스프링에서 관리하도록 해보자.

```java
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext(){
        return context;
    }
}
```
@Component는 Bean으로 등록되면서,Spring이 관리하도록 한다.
> Spring이 실행될때 component가 붙은 클래스를 찾아서 싱글톤 형태로 만들어 관리한다.

```java
public class Encoder {

    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public void setIEncoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
```
Set을 통하여 Spring에서 Bean을주입 받을 수 있도록 한다.

- Bean이 한개만 존재할때는 상관이 없지만 Bean이 두개이상 존재할때는 Spring이 결정을 하지 못하기 때문에 @Qualifier 어노테이션으로 매칭할 Bean의 이름을 넣어준다.

```java
@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocApplication.class, args);
        ApplicationContext context = ApplicationContextProvider.getContext();

        //Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
        //UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

        Encoder encoder = context.getBean("urlEncode", Encoder.class);
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
        String result = encoder.encode(url);
        System.out.println(result);
    }

}

@Configuration
class AppConfig{

    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder){
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder){
        return new Encoder(urlEncoder);
    }
}
```

더이상 new를 이용하지 않고 Spring이 관리 할 수 있도록 권할을 넘긴다.(제어의 역전)
