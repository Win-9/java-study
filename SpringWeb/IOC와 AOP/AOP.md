# AOP
관점지향 프로그래밍
스프링 어플리케이션은 대부분 특별한 경우를 제외하고는 MVC웹 어플리케이션에서는Web Layer, Business Layer
Data Layer로 정의한다.
특정구역의 반복되는 로직들을 한곳으로 몰아서 코딩 할 수 있게 해준다.

* 주요 annotaion

![image](https://user-images.githubusercontent.com/80390524/123655612-15466500-d86a-11eb-9f4c-10247fc68137.png)


### 예제로 이해하기

```java
package com.example.aop.controller;

import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name){
        System.out.println("get method");
        System.out.println("get method: "+id);
        System.out.println("get method: "+name);
        return id+" "+name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user){
        System.out.println("post method:"+user);
        return user;
    }
}
```
메소드마다 이러한 API가 실무서버에서는 수십개가 넘어간다. 따라서 잘 실행이 되는지 , 또는 에러를 찾기위해 로그를 찍기 위해서
모든 메소드마다 System..을 넣기는 무리이다. 따라서 따로 AOP를 모아놓은 클래스를 만들어서 깔끔하게 만든다.

```java
@Aspect
@Component
public class ParameterAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){

    }

    @Before("cut()")
    public void before(JoinPoint joinPoint){
        Object[]args=joinPoint.getArgs();
        for(Object obj:args){
            System.out.println("type: "+obj.getClass().getSimpleName());
            System.out.println("value:"+obj);
        }
    }

    @AfterReturning(value="cut()",returning="returnobj")
    public void afterReturn(JoinPoint joinPoint,Object returnobj){
        System.out.println("return obj");
        System.out.println(returnobj);
    }
}
```
Before는 cut()이 실행되기전에 실행하려는 메소드이고 After는 cut이후 실행하려는 메소드를 설정하는 것이다.
따라서 이를 실행시키면 type과 value가 나온후 Rest API Mapping을 거치게 되고 이후 After가 처리되게 된다.
그러므로, Controller작성시 System..을 일일히 넣어줄 필요없이 간단히 return 만 남기거나 작성하지 않는다.

* @Aspect
  > AOP로 동작하기 위해 필요하다.


추가로 실행하는 시간의 로그를 찍어보는 예이다.

```java
@Aspect
@Component
public class TimerAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){}

    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer(){}

    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();

        stopWatch.stop();
        System.out.println("total time : "+stopWatch.getTotalTimeSeconds());
    }
}
```
@Pointcut은 AOP로 설정하려는 경로를 넣는것이다.

```java
 @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {

        // db logic
        Thread.sleep(1000 * 2);

    
```
Delete를 하는데 걸리는 시간을 알아보는데 간단히 Timer 어노테이션을 이용하면 된다.
또한 TimerAOP를 만들어 로직을 간단히 만든다.
*  AOP를 이용하지 않는다면 모든 controller에다가 
  > StopWatch stopWatch = new StopWatch();
    
  > stopWatch.start();

을 붙여서 모두 넣어서 출력해야한다.



