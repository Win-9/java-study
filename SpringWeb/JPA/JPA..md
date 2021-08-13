### ORM
객체와 데이터 베이스 사이의 관계를 연결해 주는것.

![image](https://user-images.githubusercontent.com/80390524/128713491-45d061f9-cfeb-4a72-9166-d19b1dc0447a.png)




### JPA
현재 자바는 ORM 표준으로 채택되어 있는데, 데이터를 접근하기 위한 API규격을 정의한것.

### H2-DB

자바기반의 경량화된 관계형 데이터베이스
junit테스트용 DB로 많이 사용된다.

![image](https://user-images.githubusercontent.com/80390524/128713683-5f24ec21-cd82-4ea7-a18c-66b1a29b0745.png)


web에서 표시된 아이디를입력하게된면 데이터베이스를 관리 할 수 있게 된다.


```java
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
```

Db테이블과 자바객체를 연겨랳 주는것을 ORM이라고 하는데 여기서 자바객체 Entity라고 한다.
이 객체를 선언해 주는것이 @Entity이다.

entity에는 primary key가 필요한데 @ID로 선언해준다.

> 추가로 @GeneratedValue는 값을 순차적으로 증가하게 해준다.

id는 자동으로 증가하는 숫자값이고, user라는 테이블객체의pk값이 된다.

이것들을 Repository를 생성하여 조회할 수 있다.


```java
public interface UserRepository extends JpaRepository<User,Long> {

}
```
상속받은것만으로도 많은 JPA관련메소드를 지원해준다.
> Entity의 타입과 User의 PK값을 받는다.



H2 in memory DB는 데이터가 유지되니 않고, 테스트가 유지되는 시점에 데이터가 모두 사라지게 된다.
Data.sql의 파일을 resources하위에 두게되면 JPA가 로딩을 할때 자동으로 해당 쿼리를 한번 실행시켜준다.
> test파일의 resources가 아닌 main에 두게되면 main이 실행될대 마다 실행된다. 상황에 맞게 쓰면 된다.

```java
User user1=new User("Baek","Baek@naver.com");
User user2=new User("Choi","Choi@naver.com");

userRepository.saveAll(Lists.newArrayList(user1,user2));

List<User>users=userRepository,findAll();
users.forEach(System.our::println);
```

sql 에 inser할 필요없이 user에 대한 생성자를 작성후 saveAll()로 저장후 find All로 출력이 가능하다.



cf) save와 saveAll()

save의 구조를 살펴보면

l) Save 는 기본적으로 @transaction 을 달고 있어서 만약 @transition 이 존재하지 않으면 자체적으로 생성해서 감싼다.

z) entity null 체크 를 한다.

3) 본기 문을 통해서 insert 또는 update 한다.

Sale All 1) 의 내부를 보면 sure 가 사로 반복돼 있다.

i.se 에가 N번 만큼 발생

delete a delete All I) 도 마찬가지이다.
- Get one : Entity 에 대한 LAZY 패치를 다운 한다.

(find by Idi return 유는 객체가 Optional 로 빼빼이 되어 있다.

. 아 FM로 nun 반환 가능.

flush', 쿼리의 변화를 주는 것이 아니라 PR반영시점을 조절하는 것. 로2로 큰 변화를 확인하기는 어렵다.

Count: long으로 return 하며 data의 갯수를 알려준다. delete In Butch 를 사용하게 되면

user. exists By Id (소니 i 1번의 데이터의 유무를 boolean 으로 return fte 전 Settle 를 생략하고 delete 를 한다.

Delete My Id: Id 로 레코드를 삭제 한다.

t 값이 존재하는지 SE (ETE 를 시행하고 Delete.

delete ((i htt. hi i)) 에서 여러 값에 대해서 n 반만큼의 settle 극 실행하게 표시
