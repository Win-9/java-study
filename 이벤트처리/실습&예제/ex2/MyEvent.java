package Event.ex1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class MyEvent extends JFrame{
	
	public MyEvent() {
		setTitle("ex1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.addMouseListener(new MyMouse());
		c.addMouseMotionListener(new MyMouse());
		
		c.setBackground(Color.GREEN);
		
		setSize(300,300);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
		
	}
	
	class MyMouse extends MouseAdapter{
		public void mouseDragged(MouseEvent e) {
			Component c=(Component)e.getSource();
			
			c.setBackground(Color.YELLOW);
		}
		
		public void mouseReleased(MouseEvent e) {
			Component c=(Component)e.getSource();
			
			c.setBackground(Color.GREEN);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
