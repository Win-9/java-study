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
