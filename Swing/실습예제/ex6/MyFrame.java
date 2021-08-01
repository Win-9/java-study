package Swing.ex6;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame{
	
	public MyFrame() {
		setTitle("Grid");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(null);
		
		for(int i=0;i<20;i++) {
			JLabel la=new JLabel(Integer.toString(i));
			la.setLayout(null);
			int x=(int)(Math.random()*200)+50;
			int y=(int)(Math.random()*200)+50;
			la.setLocation(x,y);
			la.setSize(10,10);
			la.setOpaque(true);
			la.setBackground(Color.BLUE);
			c.add(la);
		}
		
		setVisible(true);
		
	}
	public static void main(String[]args) {
		MyFrame f=new MyFrame();
	}

}
