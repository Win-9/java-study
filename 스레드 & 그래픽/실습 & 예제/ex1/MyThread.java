package thread.ex1;

import java.util.Scanner;

public class MyThread {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("아무키나 입력");
		String str=sc.next();
		Count c=new Count();
		
		Thread th=new Thread(c);
		th.start();

	}

}

class Count implements Runnable{
	public void run() {
		System.out.println("스레드 실행 시작");
		for(int i=0;i<10;i++) {
			System.out.print(i+" ");
		}
		System.out.println("스레드 종료");
	}
}
