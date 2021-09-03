package thread.ex4;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyThread extends JFrame {
	
	public MyThread() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel label=new JLabel("진동레이블");
		label.setFont(new Font("Gothic",Font.ITALIC,50));
		label.setLocation(100, 100);
		
		c.add(label);
		
		Start st=new Start(label);
		setSize(500,500);
		setVisible(true);
		
		st.start();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyThread();
	}

}

class Start extends Thread{
	private JLabel label;
	public Start(JLabel label) {
		this.label=label;
	}
	
	public void run() {
		while(true) {
			label.setLocation(110, 110);
			label.setLocation(90, 90);
		}
	}
}
