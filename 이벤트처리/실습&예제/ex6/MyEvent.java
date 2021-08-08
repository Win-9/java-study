package Event.ex6;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyEvent extends JFrame{
	private JLabel label;
	
	public MyEvent() {
		setTitle("Ex6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		label=new JLabel("C");
		label.setLocation(100,100);
		label.setSize(100,50);
		label.addMouseListener(new MyKey());
		
		add(label);
		setSize(300,300);
		setVisible(true);
		
		requestFocus();

	}
	
	class MyKey extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			int x=(int)(Math.random()*256);
			int y=(int)(Math.random()*256);
			label.setLocation(x, y);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
