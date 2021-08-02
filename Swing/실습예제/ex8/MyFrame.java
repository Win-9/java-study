package Swing.ex8;

import java.awt.BorderLayout;
import java.awt.Container;import java.awt.GridLayout;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	public MyFrame() {
		setTitle("여러개의 작은 패널을 가진 프레임");
		
		Container c=getContentPane();
		
		c.setLayout(new BorderLayout());
		c.add(new South(),BorderLayout.SOUTH);
		c.add(new North(),BorderLayout.NORTH);
		c.add(new Center(),BorderLayout.CENTER);
		
		
		setSize(500,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new MyFrame();
	}

}
