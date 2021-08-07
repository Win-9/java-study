package Event.ex3;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyEvent extends JFrame{
	private StringBuffer sb=new StringBuffer("Love Java");
	private JLabel j=new JLabel(sb.toString());

	public MyEvent() {
		
		setTitle("Ex3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		c.addMouseListener(new MyMouse());
		c.add(j);
		setSize(300,300);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
	}
	
	class MyMouse extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getButton()==MouseEvent.BUTTON1) {
				j.setText(sb.reverse().toString());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
