package Event.ex1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyEvent extends JFrame{
	private JLabel j;
	public MyEvent() {
		setTitle("ex1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		j=new JLabel("마우스");
		setLayout(new FlowLayout());
		j.setSize(300, 200);
		j.addMouseListener(new MyMouse());
		add(j);
		
		setSize(300,300);
		setVisible(true);
		setFocusable(true);
		requestFocus();
		
	}
	
	class MyMouse extends MouseAdapter{
		public void mouseEntered(MouseEvent e) {			
			j.setText("Love Java");
		}
		
		public void mouseExited(MouseEvent e) {			
			j.setText("사랑해");

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
