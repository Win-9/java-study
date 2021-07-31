### GUI패키지의 구조

GUI응요프로그램을 사용하기위해 필요한 주요 클래스들의 상속 관계가 있다.
모든 GUI컴포넌트들은 Component클래스를 반드시 상속받으며, 스잉컴포넌트의 클래스명은 모두 J로 시작한다.
AWT컴포넌트는 Buttom,Label등과 같이 Component를 직접 상속받는 것들과 Panel,Frame등과 같이 Container를 상속받는 것들이 있다.
그리고 JApplet,JFrame,JDialog를 제외한 모든 스윙컴포넌트들은 JComponent를 상속받는다.


### 컨테이너와 컴포넌트

바자믜 GUI응요프료그램은 GUI컴포넌트들로 구성되며 , GUI컴포넌트들은 다른 컴포넌트를 포함할 수 있는지여부에 따라
순수 컴포넌트와 컨테이너로 분류된다. 빈판위에 레고블록을 쌓아가듯 GUI컴포넌트들을 쌓아 GUI응용프로그램을 구성한다.

* 컨테이너
  다른 GUI컴포넌트를 포함할 수 있는 컴포넌트이다. 그러므로 컨테이너는 컴포너트이명서 동시에 컨테이너이다.
  > Container클래스는 java.awt.Component를 상속받는다.


* 컴포넌트
  컴포넌트란 컨테이너와달리 다른 컴포넌트를 포함할 수 없어며, 컨테이너에 포함되어야 비로소 화면에 출력될 수 있는 GUI객체이다.
  > java.awt.Component를 상속받기때문에, Component클래스에는 모든 컴포넌트들의 공통적인 속성과 기능이 작성되어있다.


* 최상위 컨테이너
  컨테이너중에서 다른 컨테이너에 속하지 않고도 독립적으로 화면에 출력 될 수 있는 컨테이너를 최상위 컨테이너라고 한다.
  > JFrame,JDialog,JApplet의 3가지가 이에 속한다.
  
  > 이들을 제외한 나머지 컨테이너나 컴포넌트들은 다른 컨테이너에 부착되어어야한다.


![image](https://user-images.githubusercontent.com/80390524/127730487-c7571f29-e403-44bd-a4c4-4f4356f761be.png)


맨 바깥에 최상위 컨테이너임JFrame컨테이너가 있고, 그 안에 JPanel컨테이너가 하나 부착되어 있다.
그리고 이 컨테이너에 다시 두개의 JPanel컨테이너와
1개의 버튼 컴포넌트가 부착되어있다. 두 JPanel컨테이너에는 다시 여러개의 스윙 컴포넌트들이 부착되어있다.
자바스윙은 이렇게 JFrame과 같은 최상위 컨테이너위에 컨테이너와 컴포넌트들이 마치 레고 블록을 쌓는것처럼 계층구조로 구성되어,
컨테이너에 부착된 컴포넌트들을 자식컴포넌트라고 부른다.  



### 스윙프레임

스윙프레임은 모든 스윙컴포넌트를 담는 최상위 컨테이너이다.
스윙프레임이 출력될때, 스윙프레임 내에 부착된 모든 컴포넌트들이 화면에 출력된다. 컴포넌트들은 스윙프레임 없이 독립적으로 화면에 출력될 수 없다.

> 비유하자면 스윙프레임이 메인보드이고 컴포넌트들은 드외 다른 cpu,gpu,ram같은것들이라고 보면될 것같다. 

![image](https://user-images.githubusercontent.com/80390524/127730689-8a886d9d-a459-4900-be97-a2be149bf3c9.png)


스윙프레임의 역할을 하는것이 JFrame인데 객체가 생성되면 Frame,메뉴바, 컨텐트팬 3개의 공간으로 구성된다.
> 메뉴바는 메뉴들을 부착하는 공간이고 컨텐트팬은 메뉴를 제외한 모든 GUI컴포넌트들을 부착하는 공간이다.

> 스윙응용프로그램은 메누를 만들어 JFramed에 부착하고 화면에 출력하고자 하는 내용을 컨텐트팬에 부착하여야 한다.


```java
public class MyFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		A a=new A();

	}

}
class A extends JFrame{
	A(){
		setTitle("프레임만들기");
		setSize(300,300);
		setVisible(true);
	}
}
```
스윙 응용프로그램에서 main()의 기능은 최소화하는것이 좋다. main()에는 스윙 응용프로그램이 실행되는 시작점으로 프레임을 생성하는 코드정도만 만들고,
나머지기능은 프레임 클래스에 작성하는것이 좋다.
또한 frame을 작성한 새로운 클래스에 두거나 , 메소드만 드는 방법이있고, 위처럼 새로운 클래스를또다시 만드는것은 비추천하는 방식이다.


### 컨텐트팬과 컴포넌트

스윙에서 컨텐트팽에만 컴포넌트를 부착할 수 있다. JFrame개게가 생길때 컨텐트팬이 자동으로 생선된다. 그러므로 현재 프레임에 붙어있는 컨텐트 팬을 알아내기 위해서
JFrame클래스의 getContentPane()을 호출한다.
이후 컨텐트펜에 컴포넌트를 붙인다.

```java
public MyFrame() {
		setTitle("타이틀!");
		JButton button=new JButton("Click");
		
		Container container=getContentPane();
		container.add(button);
		
	}
```

또한 setContentPane()메소들을 이용하면 프레임에 부착된 컨텐트팬을 제거하고 새로운 컨텐트팬을 붙힐수있다.

```java
public MyFrame() {
		setTitle("타이틀!");		
		Container container=getContentPane();
		container.setBackground(Color.CYAN);
		container.setLayout(new FlowLayout());
		
		container.add(new JButton("OK"));
		container.add(new JButton("Cancle"));
		container.add(new JButton("Ig"));

		setSize(600,600);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f=new MyFrame();
		
	}
```

![image](https://user-images.githubusercontent.com/80390524/127731765-dba01001-eae3-4ad4-9d0b-31fe1d390e91.png)

프렘임윈도우의 오른쪽상단을 보면 프레임종료버튼("x")가 있는데 윈도우를 단순히 닫아주는 버튼이다.
따라서 프레임윈도우가 닫힐때 프로그램이 함께 종료되도록 해야하는 코드를 삽입해야한다.
```java
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```

---
### 컨테이너배치

컨테이너에 부착되는 컴포넌트들의 위치와 크기는 컨테이너 내부의 배치관리자에의해 결저오딘다.
* 컨테이너마다 배치관리자가 하나씩있다.
* 배치관리자는 컴테이너에 컴포넌트가 부착되는 시점에 컴포넌트의 위차와 크기를 결정한다.
* 컨테이너의 크기가 변경되면 배치관리자는 컨테이너 내부의 모든 컴포넌트드르이 위치와 크기를 재조정한다.

* 4가지의 배치관리자
  1. FlowLayOut
    > 컨테이너가 부착되는 순서대로 왼쪽에서 오른쪽으로 컴포넌트배치
    
    > 오른쪽에 배치할 공간이 없으면 아래로 내려와 다시 왼쪽->오른쪽

    > 크기는 화면에 출력될수있는 적당한크기로 설정

  2. BorderLayOut
    > 공간을 도으서나므부그중앙의 5개로 나누고 응용프로그램에서 지정한 영역에 컴포넌트를 배치한다.
    
    > 영역을 지정하지 않으면 중아에 배치

  3. GridLayOut
    > 컨테이너공강을 2차원격자로 나누고, 커모넌트가 삽입되는 순서대로 좌->으로 다시 위->아래로 배치

  4. CardLayout
    > 컨테이너의 공간에 카드를 쌓아놓듯이 컴포넌트를 쪼개어배치

배치관리자는 setLayOut()메소드로 호출한다.


컨테이너가 생서오딜때 자동으로 디폴트 배치관리자가 생성된다.

![image](https://user-images.githubusercontent.com/80390524/127732406-ce81ca6b-0664-4862-a3b8-84ab86947ea7.png)




### FlowLayout
```java
	setTitle("타이틀!");		
		Container container=getContentPane();
		container.setBackground(Color.CYAN);
		container.setLayout(new FlowLayout());
		
		container.add(new JButton("add"));
		container.add(new JButton("minus"));
		container.add(new JButton("mul"));
		container.add(new JButton("div"));
		container.add(new JButton("Calc"));

		setSize(300,300);
		setVisible(true);
```
화면에따라서 자동으로 왼쪽->오른쪽 배치가 된다.

Flowlayout은 배치관리자의 3가지 속성이 있다.
* align
  > 컴포넌트의 정렬방법
* hGap
  >좌우 컴포넌트 사이의 수평간격
* vGap
  > 상하 컴포넌트 사이의 수직간격

```java
setTitle("타이틀!");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container=getContentPane();
		
		container.setBackground(Color.CYAN);
		container.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
		
		container.add(new JButton("add"));
		container.add(new JButton("minus"));
		container.add(new JButton("mul"));
		container.add(new JButton("div"));
		container.add(new JButton("Calc"));

		setSize(300,300);
		setVisible(true);
```






