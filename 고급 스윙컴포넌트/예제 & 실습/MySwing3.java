package HighLevel.ex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class MySwing extends JFrame{

	private MyDialog dialog=new MyDialog(this, "ex");
	
	public MySwing() {
		super("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button=new JButton("Press");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dialog.setVisible(true);
				String text=dialog.getInput();
				if(text==null)
					return;
				button.setText(text);
				
			}
		});
		
		add(button);
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MySwing();
	}

}

class MyDialog extends JDialog{
	private JTextField tf=new JTextField(10);
	private JButton button=new JButton("OK");
	
	public MyDialog(JFrame frame,String title) {
		super(frame,title,true);
		setLayout(new FlowLayout());
		add(tf);
		add(button);
		setSize(200,100);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
	}
	
	public String getInput() {
		if(tf.getText()=="")
			return null;
		return tf.getText();
	}
}
