package Event;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyEvent extends JFrame{
	
	private JLabel j=new JLabel("HELLO");
	private int x=50;
	private int y=50;

	
	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		j.setLocation(x,y);
		
		MyMouse m=new MyMouse();
		c.addMouseListener(m);
		c.addMouseMotionListener(m);
		
		
		c.add(j);
		
		setSize(600,600);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
	}
	
	class MyMouse implements MouseListener, MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			j.setText("mouseDragged,  x:"+e.getX()+" y:"+e.getY());
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			j.setText("mouseMovedl, x:"+e.getX()+" y:"+e.getY());

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
			Component c=(Component)e.getSource();
			c.setBackground(Color.YELLOW);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			j.setText("mousePressed, x:"+e.getX()+" y:"+e.getY());

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			j.setText("mouseReleased, x:"+e.getX()+" y:"+e.getY());

		}
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new MyEvent();
	}

}

