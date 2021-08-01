package Swing.ex7;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Center extends JPanel{
	public Center() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(4,4,4,4));
		String[]str= {"0","1","2","3","4","5","6","7","8","9","CE","계산"};
		for(int i=0;i<str.length;i++) {
			add(new JButton(str[i]));
		}
		JButton[] bList = new JButton[] { new JButton("+"), new JButton("-"), new JButton("x"), new JButton("/") };
		for(int i=0;i<bList.length;i++) {
			bList[i].setBackground(Color.CYAN);
			add(bList[i]);
		}
		
	}

}
