package Event;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyEvent extends JFrame{
	
	private JLabel la=new JLabel("moo yaho~~");
	
	
	public MyEvent() {
		
		setTitle("Mouse Event ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.addMouseListener(new MyMouseListener());
		
		c.setLayout(null);
		la.setSize(50,50);
		la.setLocation(30,30);
		c.add(la);
		
		
		setSize(400,400);
		setVisible(true);
		
	}
	
	class MyMouseListener implements MouseListener{
		
		public void mousePressed(MouseEvent e) {
			int x=e.getX();
			int y=e.getY();
			
			la.setLocation(x,y);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new MyEvent();
	}

}

