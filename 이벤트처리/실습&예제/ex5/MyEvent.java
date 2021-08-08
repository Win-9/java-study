package Event.ex5;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyEvent extends JFrame{
	private JLabel j;
	
	public MyEvent() {
		j=new JLabel("Love Java");
		j.setFont(new Font("Arial",Font.PLAIN,10));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		c.addKeyListener(new MyKey());
		c.add(j);
		
		setSize(300,300);
		setVisible(true);
		
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	class MyKey extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			if(e.getKeyChar() == '+') {
				j.setFont(new Font("Arial",Font.PLAIN,j.getFont().getSize()+5));
			}
			else if(e.getKeyChar() == '-'){
				j.setFont(new Font("Arial",Font.PLAIN,j.getFont().getSize()-5));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
