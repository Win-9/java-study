# Validation
자바에서 null값에 대해서 접근하려 할때 nullpointer exception이 발생하므로
이러한 부분을 방지하기 위해서 미리 검증하는 과정.

### 기존 옛날방식

![SmartSelect_20210702-160511_Chrome](https://user-images.githubusercontent.com/80390524/124234670-4b783300-db4f-11eb-9145-bedb8a01605b.jpg)

* 검증해야 할 값이 많은 경우 코드의 길이가 길어진다.
* service logic과 분리가 필요하다.
* 흩어져 있는 경우 어디에서 검증 하는지 알기 어려우며, 재사용의 한계가 있다.

![Screenshot_20210702-161055_Noteshelf](https://user-images.githubusercontent.com/80390524/124235361-1a4c3280-db50-11eb-9f7c-30474a839935.jpg)

> if가 쓰인다는것을 알 수 있다.

> 우선 이 방법은 조건이 많아지거나, 복잡해 질수록 조건물을 계속 추가해 주어야 하므로 번거롭다.

따라서 최근방법은 간단한 어노테이션을 이용하여 관리하는 것을 지햔한다.



스프링에서 annotation으로 일관성있게 관리하도록 한다.

![Screenshot_20210702-161242_Chrome](https://user-images.githubusercontent.com/80390524/124235559-5a131a00-db50-11eb-869a-08e3bce5f80d.jpg)

> 간단한 형식만 지정하려면, 정규식의 사용이 필요없이, 이메일의 형식에 맞지 않으면 에러가 난다.

> 좀더 정확하게 하려면 지정한 정규식을활용한다.

> 지정한 정규식과 일치하지 않으면 에러를 나게 할 수 있다.

> 이외에도 field에 공백이 불가능 하게 하는 @NotBlank, 어느값 이상이게하는 @min()과 max()으로 제약을 둘 수 있다.


---


![Screenshot_20210702-160622_Noteshelf](https://user-images.githubusercontent.com/80390524/124234787-7498c380-db4f-11eb-90be-ab947a70f20c.jpg)

* ResponseEntity
> 말 그대로 응답 독립 체. 
> Spring Framework 에서 제공하는 클래스인 HttpEntity 클래스를
> 상속받고 있으며, Rest Template 및 @Controller 메소드에 사용하고 있다.
> HTTP Entity 클래스 를 상속받아 구현한 클래스가 Request Entity Response Entity
> 클래스이다. 따라서 Response Entity 는 사용자의 Http Request 에 대한 응답데이터를 포함
> 하는 클래스이다.

따라서 완전히 구성된 http를 사용 할 수 있는 클래스이며 ResponseEntity객체는 http정보들을 담아서 반환해 줄 수 있다.



# Validation 예외

주로 날짜와 관련된 예외가 많이 일어난다.
문자이기 때문에 받을 형식이 없어서 @AssertTrue를 사용한다.
> 재사용 불가

후에 constrain validation을 적용하여 재사용이 가능한 CustomLogic을 적용 가능하다
> 재사용 가능

![Screenshot_20210702-161718_Noteshelf](https://user-images.githubusercontent.com/80390524/124236065-fdfcc580-db50-11eb-9dfb-4e57625c1252.jpg)

size로 들어온 문자의 길이의 제한을 걸어주고, 형식의 일치여부를 확인한다.

* AsserTrue
> return이 true이면 정상, 함수의 return이 boolean이면 is로 이름이 시작되어야 한다.

