### BorderLayout

BorderLayout는 컨테이너공간을 동,서,남,북,중앙의 5개의 영역으로 분할한다.

![image](https://user-images.githubusercontent.com/80390524/127732754-fd1c20e5-95a1-4045-8713-e6e70f71c135.png)

다른 배치관리자와 다르게 BorderLayout배치관리자를 가진 컴테이너에 컴포넌트를 삽입하기 위해서는,
add()메소드에 컴포넌트의 위치를 명확히 정해주어야 한다.

* BorderLayout.EAST
* BorderLayout.WEST
* BorderLayout.SOUTH
* BorderLayout.NORTH
* BorderLayout.CENTER

```java
setTitle("타이틀!");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container=getContentPane();
		
		container.setBackground(Color.CYAN);
		container.setLayout(new BorderLayout());
		
		container.add(new JButton("add"),BorderLayout.WEST);
		container.add(new JButton("minus"),BorderLayout.CENTER);
```
컨테이너의 크기가 변하면 BorderLayout배치관리자 역시 새로운 크기에 맞도록 컴포넌트의 크기를 재조정한다.
BorderLayout 배치관리자를 사용하는 컨테이너에는 일차적으로 5개의 컴포는트밖에 붙일수가없다.
BorderLayout컨테이너에 5개 이상의 컴포넌트를 부착하고자하면 한영역에 JPanel등 다른 컨테이너를 부착하고
이곳에 컴포넌트들을 부착하면 된다.

또한 BorderLayout의 생성자로 간격을 조절할 수 있다.
* hGap
* vGap

```java
setTitle("타이틀!");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container=getContentPane();
		
		container.setBackground(Color.CYAN);
		container.setLayout(new BorderLayout(30,20));
		
		container.add(new JButton("add"),BorderLayout.WEST);
		container.add(new JButton("minus"),BorderLayout.SOUTH);
		container.add(new JButton("mul"),BorderLayout.EAST);
		container.add(new JButton("div"),BorderLayout.NORTH);
		container.add(new JButton("Calc"),BorderLayout.CENTER);

		setSize(300,300);
		setVisible(true);
```

* CENTER에 컴포넌트가 부착될때 다른 컴포넌트가 없으면 컨테이너 전체 크리고 배치된다!!!



### GridLayout

GridLayout은 컨테이너 공간을 그리드 모양으로 분한하여 각 셀에 하나씩 컴포넌트를 배치하는 방법이다.
GridLayout은 부착되는 순서대로 컴포넌트를 셀에 배치한다.

```java
container.setLayout(new GridLayout(4,3));
		
		container.add(new JButton("1"));
		container.add(new JButton("2"));
```

GridLayout에 의해 4x3그리드로 분할된 프레임에 11개의 부착된것이다.
12번째 새로운 컴포넌트가 추가되면 맨밑에 추가된다.

![image](https://user-images.githubusercontent.com/80390524/127733156-bf4ab012-e1ea-4d7b-a002-65373a63bfae.png)


다음과같은 속성을 추가할 수 있다.

* rows
  > 그리드의 행의수
* cols
  > 그리드의 열수
* hGap
* vGap

```java
public MyFrame() {
		setTitle("타이틀!");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout grid=new GridLayout(4,2);
		grid.setVgap(5);
		
		Container c=getContentPane();
		c.setBackground(Color.gray);
		c.setLayout(grid);
		c.add(new JLabel("Name"));
		c.add(new JTextField(""));
		c.add(new JLabel("Std-Number"));
		c.add(new JTextField(""));
		c.add(new JLabel("Major"));
		c.add(new JTextField(""));
		c.add(new JLabel("Subject"));
		c.add(new JTextField(""));

		

		setSize(300,300);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f=new MyFrame();
		
	}
```


![image](https://user-images.githubusercontent.com/80390524/127733518-7f3adb25-6a54-4ec6-ae6e-149f9e090051.png)



