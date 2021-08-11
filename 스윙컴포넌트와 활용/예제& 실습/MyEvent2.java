package Component;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyEvent extends JFrame{
	
	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon normalIcon=new ImageIcon("이미지");
		ImageIcon rolloverIcon=new ImageIcon("이미지");
		ImageIcon pressedIcon=new ImageIcon("이미지");
		
		JButton j=new JButton("mooya~",normalIcon);
		j.setPressedIcon(rolloverIcon);
		j.setRolloverIcon(pressedIcon);
		c.add(j);
		
		setSize(400,400);
		setVisible(true);
		
		
	}
	
	public static void main(String[]args) {
		new MyEvent();
	}

}
