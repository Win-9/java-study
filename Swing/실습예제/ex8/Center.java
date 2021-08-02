package Swing.ex8;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Center extends JPanel{
	
	public Center() {
		setLayout(null);
		setBackground(Color.WHITE);
		for(int i=0;i<10;i++) {
			JLabel j=new JLabel("*");
			int x=(int)(Math.random()*200)+50;
			int y=(int)(Math.random()*200)+50;
			
			j.setLocation(x, y);
			j.setSize(10,10);
			j.setForeground(Color.RED);
			
			add(j);
		}
	}

}
