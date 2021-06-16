# 자바에서 Thread 만들기

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


> notify()는 무작위의 쓰레드중 하나를 깨우고, notifyAll()은 모든 스레드를다 깨운다.

> join()은 다른 쓰레드가 끝날때가지 Not Runnable상태로 빠지다가 쓰레드 실행이 끝나면 RUnnable상태로 들어온다.




# 21. Thread 클래스의 여러 메서드들

## Thread 우선순위

- Thread.MIN_PRIORITY(=1) ~ Thread.MAX_PRIORITY(=10)

- 디폴트 우선순위 : Thread.NORMAL_PRIORITY(=5)

- 우선 순위가 높은 Thread가 CPU의 배분을 받을 확률이 높다

- setPriority()/getPriority()

- Thread 우선순위 예제

```
class PriorityThread extends Thread{
	
	public void run(){
	
		int sum = 0;
		
		Thread t = Thread.currentThread();
		System.out.println( t + "start");
		
		for(int i =0; i<=1000000; i++){
			
			sum += i;
		}
		
		System.out.println( t.getPriority() + "end");
	}
}


public class PriorityTest {

	public static void main(String[] args) {

		int i;
		for(i=Thread.MIN_PRIORITY; i<= Thread.MAX_PRIORITY; i++){
			
			PriorityThread pt = new PriorityThread();
			pt.setPriority(i);
			pt.start();
		
		}
	}

}

```

## join()

- 동시에 두 개 이상의 Thread가 실행 될 때 다른 Thread의 결과를 참조 하여 실행해야 하는 경우 join() 함수를 사용

- join() 함수를 호출한 Thread가 not-runnable 상태가 감

- 다른 Thread의 수행이 끝나면 runnable 상태로 돌아옴
- 

![image](https://user-images.githubusercontent.com/80390524/122155332-c0861000-cea1-11eb-9e86-2f2f3efdaaa8.png)


- 1부터 50, 51부터 100 까지의 합을 구하는 두 개의 Thread를 만들어 그 결과를 확인해보세요

```
public class JoinTest extends Thread{
	
	int start;
	int end;
	int total;
	
	public JoinTest(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	public void run(){
	
		int i;
		for(i = start; i <= end; i++){
			total += i;
		}
	}
	

	public static void main(String[] args) {

		JoinTest jt1 = new JoinTest(1, 50);
		JoinTest jt2 = new JoinTest(51, 100);
		
				
		jt1.start();
		jt2.start();
		
		try{
			jt1.join();
			jt2.join();
			
		}catch (InterruptedException e) {
			System.out.println(e);
		}
		
		
		int lastTotal = jt1.total + jt2.total;
		
		System.out.println("jt1.total = " + jt1.total);
		System.out.println("jt2.total = " + jt2.total);
		
		System.out.println("lastTotal = " + lastTotal);
		
				
	}

}
```

## interrupt()

- 다른 Thread에 예외를 발생시키는 interrupt를 보낸다.

- Thread가 join(), sleep(), wait() 함수에의해 not-runnable 상태일 때 interrupt() 메서드를 호출하면 다시 runnable 상태가 될 수 있음


## Thread 종료하기

- Thread를 종료할 때 사용함

