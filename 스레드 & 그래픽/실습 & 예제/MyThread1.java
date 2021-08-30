package thread.example;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyThread extends JFrame{
	
	public MyThread() {
		setTitle("Ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timer=new JLabel();
		timer.setFont(new Font("Gothic",Font.ITALIC,80));
		c.add(timer);
		
		Timer t=new Timer(timer);
		
		setSize(300,300);
		setVisible(true);
		
		t.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyThread();
	}

}

class Timer extends Thread{
	private JLabel timer;
	
	public Timer(JLabel timer) {
		this.timer=timer;
	}
	
	public void run() {
		int n=0;
		while(true) {
			timer.setText(Integer.toString(n));
			n++;
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
