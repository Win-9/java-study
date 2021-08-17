### JTextField

JTextField를 이용하면 한줄의 문자열을 입력받는 창을 만들 수 있다.
입력가능한 문자개수와 창의 크기는 응용프로그램에서 변경할수 있다.
텍스트필드에 문자열 입력도중 Enter가 입력되면 Action이벤트가 발생한다.
> setEditable(false)
텍스트필드 창에 입력하거나 수정불가

> setText("hello")
hello를 텍스트필드 창에 출력

> setFont(new Font("고딕",Font.ITALIC,20))

JTextArea를 이용하여 여러줄의 문자열을 입력받을 문자열을 입력받을수 있는 창을 만들 수 있다.
창의 크기보다 많은 줄과 문자를 입력할 수 있지만 스크롤바를 지원하지 않는다.
JTextArea컴포넌트를 JScrollPane에 삽입하여야 스크롤바 지원을 받을 수 있다.


### JList
JList는 여러 개의 아이템을 리스트 형식으로 보여주고 아이템을 선택하도록 하는 리스트 컴포넌트르 구현한다.
E는 리스트에 삽입되는 아이템의 타입으로, 리스트를 생성할때 E대신 아이템타입을 대입하여 구체화 해야한다.
JList는 자체적으로 스크롤을 지원하지 않기 때문에 JScrollPane에 삽입되어야 스크롤이 가능하다.

> 제네릭 타입E를 생략하고 이전처럼 JList만을 사용하는 경우, 자바 컴파일러는 경고를 발생시키는데, 자바
> 컴파일러에게 경고하지 말도록 @SuppressWarnings를 붙히면 된다.


JList가 생성자르 이용하여 리스트가 일단 생성되고나면, list의 벡터나 배열을 수정한다고해도이미 생성된리스트를 변경할 수 없다.
생성된 리스트를 수정하는 가장 간단한 방법은 JList를 setListDate()메소드를 호출하여 리스트에 수저오딘 벡터나 배열을 새로 달아주느것이다.
즉 list.add()로 원소를 추가한후, setListDate(list)로 리스트를 연결시킨다.


```java
JTextField t=(JTextField)e.getSource();
				
list.add(t.getText());
text.setText("");
jlist.setListData(list);
```



### JComboBox

JComboBox는 텍스트필드, 버튼, 드롭다운리스트로 구성되는 콤보박스 컴포넌트를 구현한다.
JComboBox에 제네릭을 도입하여 JComboBox로 사용한다. E는 콤보박스에 삽입되는 아이템의 타입으로, 콤보박스를 생성할때 E대신 아이템의 타입을 대입하여 구체화 해야한다.
8개의 아이템을 가진 콤보박스 컴포넌트를 보여준자. 초기에는 텍스트필드 창과 버튼만 보이지만 버튼을 클릭하면 드롭다운 리스트가 아래로 출력되고,
아이템을 선택하면 텍스트필드창에 나타난다.


![image](https://user-images.githubusercontent.com/80390524/129688099-eacc5f77-5ed4-4587-a32a-86558775bcaf.png)


JList와 같이, JComboBox나 생성자를 이용하여 벡터나 배열로부터 아이템을 공급받아 만들어진
콤보박스는, 한번 생성된후 listData를 수정해도 콤보박스를 변경할 수 없거나 예측할 수 없는 일이 발생하므로 주의하기 바란다.

```java
JComboBox<String>combo=new JComboBox<>(arr);
```

콤보박스는 리스트와 달리 동적으로 아이템의 추가/삭제가 가능하다.
addItem()메소드를 호출하여 아이템을 추가할 수 있다.

removeItem(Object obj),removeItemAt(int index),removeAllItems()등을 호출하여
콤보박스의 아이템을 삭제할 수 있다. index는 0부터 시작한다.



```java
JComboBox<String>jcomboxname=new JComboBox<>(str);

		
		for(int i=0;i<name.length;i++) {
			jcomboxname.addItem(name[i]);
		}
		
		c.add(jcomboxname);
```


아이템선택을 일종으로 명령으로 처리하고자 하면 Action이벤트를, 아이템을 선택하거나 해제하는 것이 목적이면 Item이벤트를 처리하면 된다.

> 하나의 아이템 선택시 Action이벤트는 무조건 한개 발생하지만, 지금 선택한 아이템이 바로 직전에 선택도니 아이템이라면 Item이벤트는 발생하지 않는다.
> 새로운 아이템이 선택되었다면 2개의 Item이벤트가 발생하는데 새로 아이템이 선택되었음을 알리기 위한 Item이벤트와 이전에 선택된 아이템이 해제됨을 알리는 Item이다.












