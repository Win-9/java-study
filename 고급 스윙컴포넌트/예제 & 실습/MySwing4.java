package HighLevel.ex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import thread.ex7.MyPanel;

public class MySwing extends JFrame{
	
	public MySwing() {
		super("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container=getContentPane();
		
		setSize(500,300);
		container.add(new MyPanel(),BorderLayout.NORTH);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MySwing();
	}

}

class MyPanel extends Panel{
	private JTextField tf=new JTextField(10);
	private JButton messageButton=new JButton("Message");
	private JButton inputButton=new JButton("OK");
	private JButton confirmButton=new JButton("Confirm");
	
	public MyPanel() {
		setBackground(Color.LIGHT_GRAY);
		add(inputButton);
		add(confirmButton);
		add(messageButton);
		add(tf);
		
		inputButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=JOptionPane.showInputDialog("이름?");
				if(name!=null) {
					tf.setText(name);
				}
			}
		});
		
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result=JOptionPane.showConfirmDialog(null, "계속?",
						"confirm",JOptionPane.YES_NO_OPTION);
				
				if(result==JOptionPane.CLOSED_OPTION) {
					tf.setText("justClose");
				}
				else if(result==JOptionPane.YES_OPTION) {
					tf.setText("yes");
				}
				else {
					tf.setText("No");
				}
			}
		});
		
		messageButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "조심",
						"Message",JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}
