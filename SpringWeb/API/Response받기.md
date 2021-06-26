# Respons 받기

1. 가장 간단하게 Text받기
  > text는 기본 UTF-8

  ![Screenshot_20210626-152044_Noteshelf](https://user-images.githubusercontent.com/80390524/123504080-16249e80-d692-11eb-86aa-5a047bafc154.jpg)
  
  주로 JSON형태로 내려오기 때문에 잘 쓰이지는 않는다.
  

2, JSON

  ![Screenshot_20210626-152153_Chrome](https://user-images.githubusercontent.com/80390524/123504103-3eac9880-d692-11eb-8bdf-8ef407130fa5.jpg)
  
  User class를 만들고 @RequestBody를 붙힌다.
  
  > Request가 오면 OBjectMapper를 통해서 object로 바뀐다. 이후 method를 타게되고, Response를 타고나가면 Object를 던지고, Object Mapper를 통해 Json형태로 변환된다.

*문제없이 Response가 되면 200, 리소스가 생성이 된상태면 201을 표시하게된다.

3. 201의 응답받기

  ![Screenshot_20210626-152414_Noteshelf](https://user-images.githubusercontent.com/80390524/123504164-921ee680-d692-11eb-94de-6a59ad5fea43.jpg)

  Put을 이용한다.

  status 통해서 받을 상태코드번호를 넣어준다.
  > CREATED는 201을 나타낸다.

  여러가지 값에대해서 응답의 커스터마이징이 필요하면사용할 수 있다.
  

4, Page return

![Screenshot_20210626-152628_Chrome](https://user-images.githubusercontent.com/80390524/123504222-e2964400-d692-11eb-9c8d-a58a96909879.jpg)

@Controller는 HTML파일의 리소스를 찾게된다.
이후 RequestMapping을통해 HTML파일로 이루어진 Page 자체를 return 하게 된다.


# Object Mapping

+ Object에서 text로
  이때 objectMapper는 get method를 활용하여 변환을 시켜준다.
  
  > 작성한 클래스가 Object Mapper에서 활용이 된다고 하면, 특정 메소드에 "get"을 붙여버리면 오류가 발생한다.

  > 따라서 getDefault()형식이 아니라 get,set,메소드가 아니면 Default() 형식을 사용하도록 하자.

+ text에서 object로

  이때는 default생성자가 있어야한다.
  > default생성자는 컴파일시 default생성자가 없어도 명시적으로 생성이되지만, 이경우에는 직접 생성시켜주어야한다.
  
  
