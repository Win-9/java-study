package Swing.ex4;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame{
	
	public MyFrame() {
		setTitle("Grid");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new GridLayout(1,10));
		Color[]col= {Color.red,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.CYAN,
				Color.BLUE,Color.MAGENTA,Color.BLACK,Color.PINK,Color.LIGHT_GRAY};

		for(int i=0;i<10;i++) {
			JLabel j=new JLabel(Integer.toString(i));
			j.setBackground(col[i]);
			add(j);
		}
		
		setVisible(true);
	}
	public static void main(String[]args) {
		MyFrame f=new MyFrame();
	}

}
