package Swing.ex7;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	
	public MyFrame() {
		setTitle("계산기 프레임");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(new North(),BorderLayout.NORTH);
		c.add(new Center(),BorderLayout.CENTER);
		c.add(new South(),BorderLayout.SOUTH);
		
		setVisible(true);
		
	}
	public static void main(String[]args) {
		new MyFrame();
	}

}
