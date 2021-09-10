package thread.ex11;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WordThread extends JPanel implements Runnable{
	private JLabel center;
	private Container container;
	private int number;
	private String[]str= {"A","B","C","D","E","F","G","H","I","J","K"};
	public WordThread(JLabel center,Container container,int number) {
		// TODO Auto-generated constructor stub
		this.center=center;
		this.container=container;
		this.number=number;
	}
	
	public void run() {
		int x=(int)(Math.random()*255);
		int y=0;
		center.setText(str[number]);
		center.setFont(new Font("Arial", Font.ITALIC, 20));
		while(y>=container.getHeight()) {
			center.setLocation(x, y);
			y+=5;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	

}
