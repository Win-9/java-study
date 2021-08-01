package Swing.ex7;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class South extends JPanel{

	public South() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		setBackground(Color.YELLOW);
		add(new JLabel("계산 결과"));
		add(new JTextField(20));
		
	}
}
