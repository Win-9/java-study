package Component.ex2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyEvent extends JFrame{
	
	private JTextField text=new JTextField(15);

	public MyEvent() {
		// TODO Auto-generated constructor stub
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		JComboBox<String>combo=new JComboBox<String>();
		
		text.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				combo.addItem(text.getText());
				text.setText("");
			}
		});
		
		
		c.add(text);
		c.add(combo);
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[]args) {
		new MyEvent();
	}

}
