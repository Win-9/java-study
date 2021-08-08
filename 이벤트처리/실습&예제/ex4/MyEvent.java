package Event.ex4;

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
		
		setTitle("Ex4");
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
				sb.append(sb.substring(0,1));
				sb.delete(0,1);
				j.setText(sb.toString());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
