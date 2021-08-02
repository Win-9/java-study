package Swing.ex8;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class South extends JPanel{

	public South() {
		setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		setBackground(Color.YELLOW);
		add(new JButton("Word Input"));
		add(new JTextField(20));
		
	}
	
}
