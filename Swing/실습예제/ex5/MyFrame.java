package Swing.ex5;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame{

	public MyFrame() {
		setTitle("Color Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c=getContentPane();
		c.setLayout(new GridLayout(4,4));
		
		Color[]col= {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.CYAN,Color.BLUE,Color.MAGENTA,
				Color.GRAY,Color.PINK,Color.LIGHT_GRAY,Color.WHITE,Color.BLACK,Color.BLACK,Color.ORANGE,
				Color.BLUE,Color.MAGENTA};
		
		for(int i=0;i<col.length;i++) {
			JLabel j=new JLabel(Integer.toString(i));
			j.setOpaque(true);
			j.setBackground(col[i]);
			c.add(j);
		}
		
		
		setSize(600,600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}

}
