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
		
		ImageIcon normalIcon=new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진\\국뽕1.jfif");
		ImageIcon rolloverIcon=new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진\\국뽕2.jfif");
		ImageIcon pressedIcon=new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진\\국뽕3.jfif");
		
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
