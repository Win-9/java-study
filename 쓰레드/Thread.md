# 20. 자바에서 Thread 만들기

## Thread 란?

- process 
  실행 중인 프로그램
  프로그램이 실행되면 OS로 부터 메모리를 할당받아 프로세스 상태가 됨

- thread
  하나의 프로세스는 하나 이상의 thread를 가지게 되고, 실제 작업을 수행하는 단위는 thread임
  
![image](https://user-images.githubusercontent.com/80390524/122151618-d7753400-ce9a-11eb-91b9-ce55465bc013.png)


## multi-threading 

- 여러 thread가 동시에 수행되는 프로그래밍, 여러 작업이 동시에 실행되는 효과

- thread는 각각 자신만의 작업 공간을 가짐 ( context )

- 각 thread 사이에서 공유하는 자원이 있을 수 있음 (자바에서는 static instance)

- 여러 thread가 자원을 공유하여 작업이 수행되는 경우 서로 자원을 차지하려는 race condition이 발생할 수 있음

- 이렇게 여러 thread가 공유하는 자원중 경쟁이 발생하는 부분을 critical section 이라고 함

- critical section에 대한 동기화( 일종의 순차적 수행)를 구현하지 않으면 오류가 발생할 수 있음


![image](https://user-images.githubusercontent.com/80390524/122151637-dfcd6f00-ce9a-11eb-8ea9-80a52c7a01f6.png)


## 자바 Thread 만들기

### Thread 클래스 상속하여 만들기

```
class MyThread extends Thread{
	
	public void run() {
		
		int i;
		for(i = 0; i<200; i++) {
			System.out.print(i + "\t");
		}
	}
}

public class ThreadTest {

	public static void main(String[] args) {

		System.out.println(Thread.currentThread()+"start");
		MyThread th1 = new MyThread();
		th1.start();
		
		MyThread th2 = new MyThread();
		th2.start();
		System.out.println(Thread.currentThread()+"start");
	}

}
```

이떄 쓰레드가 실행되면서 run이라는 메서드를 실행한다.

* main쓰레드와 MyThread2개 총 3개의 Thread가 실행된다.
> main쓰레드는 쓰레드를 2개 생성하고 종료

> 나머지는 switch되면서 i를 플러스

### Runnable 인터페이스 구현하여 만들기

- 자바는 다중 상속이 허용되지 않으므로 이미 다른 클래스를 상속한 경우 thread를 만들기 위해 Runnable interface를 구현하도록 한다.

```
class MyThread2 implements Runnable{

	public void run(){
		
		int i;
		for(i=0; i<200; i++){
			
			System.out.print(i + "\t");
	
			
		}
	}
}


public class ThreadTest2 {

	public static void main(String[] args) {

		System.out.println("main start");
		
		MyThread2 mth = new MyThread2();
		Thread th1 = new Thread(mth);
		th1.start();
		
		Thread th2 = new Thread(new MyThread2());
		th2.start();
		
		System.out.println("main end");
	}

}
```

Runnable을 implements한 클래스를 따로 정의하거나, 쓰레드클래스를 extends한 클래스를 따로 만들 필요 없이 익명객체로 바로 run을 구현할 수 있다.
```
Runnable run=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
```



## Thread Status

![image](https://user-images.githubusercontent.com/80390524/122151664-e65be680-ce9a-11eb-9c21-d27f3c42f438.png)
