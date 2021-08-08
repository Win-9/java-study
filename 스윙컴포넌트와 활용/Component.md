### 스윙컴포넌트

스윙 컴포넌트로 GUI화면을 구성하는 방법은 두가지이다.
첫번째는, 컴포넌트 기반의 GUI프로그래밍이다.
스윙패키지에 주어진 GUI컴포넌트를 이용하여 쉽게 GUI프로그램을 작성할 수 있는 장점이 있지만, 자바 패키지에서 제공하는 GUI컴포넌트의 한계를 벗어날 수 없다.

두번째는, 그래픽 기반 GUI프로그램이이다.
선,원등의 도형과 이미지를 이용하여 그래픽으로 적접 화면에 그린다. 이방버은 자바 패키지의 컴포넌트에는
없는 독특한 GUI를 구성할 수 있고 실행속도가 빨라 게임등에서 주로 이용한다.
하지만, 프로그래밍에 대한 개발자의 부담이 큰 단점이 있다.



![image](https://user-images.githubusercontent.com/80390524/128634920-903c002e-5d1a-4a24-879e-eb878cf9da9b.png)


기본적인 스윙 컴포넌트들과 그들 사이의 상속관계를 보여준다. 스윙 컴포넌트는 JComponent를 상속받으며 이름이 모두 J로 시작된다.
JComponent에는 모든 스윙 컴포넌트들이 상속받는 공통 메소드와 상수들이 작성되어 있기 때문에 GUI프로그램 작성을 위해 JComponent의 메소드들을 알아두어야 한다.

### 배경색,폰트
스윙 컴포넌트 c의 배경색, 전경색, 폰트를 다루는 예는
```java
c.setBackground(Color.YELLOW);
c.setForeground(Color.YELLOW);
c.setFont(new Font("Arial",Font.ITALIC,20));
```

### 위치와 크기
배치관리자가 없는 컨테이너에서만 작동한다.
```java
c.setLocation(100,200);
c.setSize(100,100);
```

또한 위치와 크기는 getX(),getY()와 getWidht(),getHeight()로 알 수 있다.

### 활성화 비활성화, 보이기와 숨기기
```java
c.setEnabled(false);
c.setVisible(false);
```
setEnabled()로 활성화/비활성화, setVisible()로 보이기/ 숨기기를 할 수 있다.

### 부모 컨테이너 찾기

```java
Container c=c.getParent();
MyFrame frame=(MyFrame)c.getTopLevelAncester();
```
getParent()를 이용하면 컴포넌트 c가 담긴 부모 컨테이너를, getTopLevelAncestor()를 호출하면 최상위 컨테이너를 알아낼 수 있다.

컨테이너 c에서 c.remove(child);를 사용하여 자식컴포넌트 child를 삭제할 수 있다.
하지만 child가 제거된다고 바로 화면에 사라지지는 않고
```java
c.revalidate();
c.repaint();
```
를 사용해야 한다.






