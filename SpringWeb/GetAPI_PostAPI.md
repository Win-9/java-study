# get:url 주소를 얻어온다.

* @ RequestMapping("/api/get"):url주소를 만들어주는 어노테이션
* get뿐만 아니라 앞에 나올 post, put, delete 모든 동작에매핑이 가능하다.

1. @GetMapping()
  * 모든 url경로를 지정하여 만들어 줄 수 있음.
```java
@GetMapping(path="/hello")
    public String getHello(){
        return "get Hello";
    }
```
> 모든 경로에 대한 url을 지정
> 

2. path veriable
  * 변화하는 url에 대한 방식을 지정한다
  * @ GetMapping("/path/{name}")
  * 이와같이 변화하는 url 을 {}으로 감사싸준후 GetMapping어노테이션에 넣어준다.
  ```java
   @GetMapping("/path-variable{name}")
    public String pathVariable(@PathVariable(name="name") String pathname){
        System.out.println("PathVal:"+pathname);

        return pathname;
    }
```
    
    
3. query-param
  * url주소는 key-value 구조로 이루어져있다.
  > ?key=value&key2=value&...
  > 
  * 처음 key앞에는 ?로 시작하고, 그 이후에는 &를 붙이면서 key,value가 이어진다.

## Query-Param을 받기

1. GetMapping을 통해 일반적으로 받기.

```java

@GetMapping(path="query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam){
        StringBuilder sb=new StringBuilder();
        queryParam.entrySet().forEach(entry->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("/n");

            sb.append(entry.getKey()+"="+entry.getValue()+"/n");
        });
        return sb.toString();
    }
```
위 방법 주소부 입력시 번거롭기때문에 잘 사용하지 않는다.

2. Path
```java
 @GetMapping(path="query-param02")
    public String queryParam02(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam int age
    ){
        return name+" "+email+" "+age;
    }
 ```
 * 변화하는 path에대한 모든 변수를 지정하여 넣어줌.
 * 하지만 각 자료형에 맞지 않는 변수를 지정시 오류가 발생하고, 변수가 늘어날때마다 번거롭다는 단점이 있다.

3. class 생성

* user에 대한 정보를 담은 userRequest를 생성해 준뒤 인자로 넣어준다.
* 제일 많이 사용하는 방법
```java
@GetMapping(path="query-param03")
    public String queryParam03(UserRequest user){
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getAge());
        return user.toString();
    }
 ```
 
 ---
# Post API
기본적으로 get과 비슷하지만, key-value구조를 이루고 있다.
===> key-value구조이기 때문에 get의 qeury-param구조와 유사한방법을 사용
1. @PostMApping("/post")
```java
@PostMapping("/post")
    public String post(@RequestBody Map<String,String>data){
        StringBuilder sb=new StringBuilder();
        data.entrySet().forEach(entry->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("/n");

            sb.append(entry.getKey()+"="+entry.getValue()+"/n");
        });
        return sb.toString();
    }
```
2. Request 정도를 담은 postrequest class 생성
```java
@PostMapping("/post")
    public void post(@RequestBody PostRequestDto requestData){
        System.out.println(requestData);
    }
```
```java
 public class PostRequestDto {
    private String account;
    private String email;
    private String address;
    private String password;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("OPT")
    private String OTP;
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PostRequestDto{" +
                "account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
```
작성은 Camelcase지만 요청은 Snakecase인경우 해당 변수에 @JasonProperty("변수이름")의 형식의 어노테이션을 붙어줘야한다.
또한 Camelcase와 Snakecase형식이 둘다아닌 다른 형식에서도 활용이 가능하다.
