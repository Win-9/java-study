package thread.example;

import javax.swing.JFrame;



public class MyThread extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedBoard board=new SharedBoard();
		Thread th1=new StudentThread("Kim",board);
		Thread th2=new StudentThread("Park",board);
		
		th1.start();
		th2.start();
	}

}

class SharedBoard{
	private int sum=0;
	
	synchronized public void add() {
		int n=sum;
		Thread.yield();
		n+=10;
		sum=n;
		System.out.println(Thread.currentThread().getName()+":"+sum);
	}
	
	public int getSum() {
		return sum;
	}
	
}

class StudentThread extends Thread{
	private SharedBoard board;
	
	public StudentThread(String name,SharedBoard board) {
		super(name);
		this.board=board;
	}
	
	public void run() {
		for(int i=0;i<10;i++) {
			board.add();
		}
	}
}
