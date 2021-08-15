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


### JTextArea 컴포넌트 생성
JTextArea 이용하여 텍스트영역을 생성한 것으로 스크롤바가 없으며, 오른쪽은 라인수를 넘어가거나 한줄에 많은 문자를 입력하는 경우
스크롤바가 나타나도록 다음과 같이 JScrollPane에 삽입한 예이다.














