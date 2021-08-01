package Swing.ex7;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class North extends JPanel{
	
	public North() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new FlowLayout());
		add(new JLabel("수식입력"));
		add(new JTextField(20));
	}

}
