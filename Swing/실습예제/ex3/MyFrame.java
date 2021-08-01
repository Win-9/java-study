package Swing.ex3;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	public MyFrame() {
		setTitle("Grid");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new GridLayout(1,10));
		
		for(int i=0;i<10;i++) {
			c.add(new JButton(Integer.toString(i)));
		}
		
		setVisible(true);
	}
	public static void main(String[]args) {
		MyFrame f=new MyFrame();
	}

}
