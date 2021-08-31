package thread.example;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javafx.beans.binding.SetBinding;

class Glow  extends JLabel implements Runnable{
	private long delay;
	
	public Glow(String text,long delay) {
		super(text);
		this.delay=delay;
		setOpaque(true);
		
		Thread th=new Thread(this);
		th.start();
	}
	
	
	public void run() {
		boolean check=true;

		while(true) {
			if(check==true)
				setBackground(Color.YELLOW);
			else
				setBackground(Color.GREEN);
			
			check=!check;
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
		}
	}
}


public class MyThread extends JFrame{
	
	public MyThread() {
		setTitle("Ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		Glow g1=new Glow("깜빡",500);
		
		JLabel label=new JLabel("안깜빡");
		
		Glow g2=new Glow("여기도 깜빡", 200);
		
		c.add(g1);
		c.add(label);
		c.add(g2);
		
		
		setSize(300, 300);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyThread();
	}

}
