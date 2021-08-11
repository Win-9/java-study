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



### JLabel

JLabel은 문자열이나 이미지를 스크린에 출력하는 레이블 컴포넌트를 만드는 클래스이다.
이미지를 생성하기 위해서 ImageIcon클래스를 이용하여 이미지 파일로부터 이미지 객체를 생성하고, JLabel로 이미지 레이블을 생성한다.
```java
ImageIcon image=new ImageIcon("이미지~~.jpg");
JLabel imageLabel=new JLabel(image);
```


### JButton
JButton은 버튼 컴포넌트를 만드는데 이용된다. 레이블 컴포넌트가 문자열이나 이미지를 활면에 출력하는 용도로 사용되는 것이라면,
버튼은 사용자로부터 명령을 받기 위해 사요된다. 버튼을 마우스로 클릭하거나 선택하면 Action이벤트가 발생한다.

* 생성자
> JButton()

> JButton(Icon Image)

> JButton(String text)

> JButton(String, text, Icon image)


JButton은 사용자의 버튼 조작에 대한 시가적 효과를 극대화 하기위해서 마우스 접근에 따라서 모양이 다른
3개의 버튼 이미지를 출력 할 수 있다.
* normallIcon
> 버튼이 보통상태에 있을때 출력되는 디폴트 이미지.

* rolloverIcon
> 버튼위에 마우스가 올라갈대 출력되는 이미지.

* pressedIcon
> 버튼이 눌려져 있는 동안 출력되는 이미지.

```java
ImageIcon normalIcon=new ImageIcon("이미지");
ImageIcon rolloverIcon=new ImageIcon("이미지");
ImageIcon pressedIcon=new ImageIcon("이미지");

Jbutton j=new JButton("버튼",normalIcon);
j.setRolloverIcon(rolloverIcon);
j.setPressedIcon(pressedIcon);
```

### 버튼과 레이블정렬

버튼 컴포넌트와 레이블 컴포넌트는 정렬 기능을 이용하면 컴포넌트 내에 문자열과 이미지의 위치를 조정할 수 있다.

* 수평정렬
> void setHorizontalAlignment(int align)

> SwingConstants.LEFT,SwingConstants.CENTER,SwingConstants.RIGHT

* 수직정렬
> void setVerticalAlignment(int align)

> SwingConstants.TOP,SwingConstants.CENTER,SwingConstants.BOTTOM



### JCheckBox, 체크박스 컴포넌트

JCheckBox를 이용하면 선택과 해제의 두 상태만 가지는 체크박스 컴포넌트를 만들 수 있다.
JButton과 마찬가지로 문자열, 이미지를 넣을수 있는 생성자들이 있다.

```java
JCheckBox pear=new JCheckBox("배",true)
```
true의 유뮤의 따라서 체크된상태와 안된상태를 구분지어 생성할 수 있다.

이미지 체크바스는 setSelectedIcon()으로 이미지를 넣어 체크박스를 생성할 수 있다.



### CheckBox와 이벤트처리

Item 이벤트는 체크박스나 라디오버튼의 선택 상태가 바뀔때 발생하는 이벤트이다. 
이미 선택상태인 라디오 버튼을 누르는 경우 선택 상태에 대한 변화가 없기 때문에 Item 이벤트는 발생하지 않는다.


item이벤트 리스너는 ItemListener인터페이스를 상속받아 만들며, 다음 하나의 메소드로 구성된다.
```java
void itemStateChanged(ItemEvent e)
```
이 메소드가 호출된 시점에는 이미 체크박스는 화면에서 상태가 바뀌어있음을 기억해야한다.

Item이벤트가 발생되면 ItemEvent 객체가 생성되어 itemStateChanged()의 인자로 전달된다.
개발자는 ItemEvent 객체의 getStateChange()와 getItem()를 호출하여 체크상태의 변화와 이벤트 소스컴포넌트를 알아낼 수 있다.









