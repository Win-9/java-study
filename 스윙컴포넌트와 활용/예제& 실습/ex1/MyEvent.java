package Component.ex1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MyEvent extends JFrame{
	
	private JButton button=new JButton("test Button");
	
	public MyEvent() {
		// TODO Auto-generated constructor stub
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		JCheckBox checkBox1=new JCheckBox("버튼 비활성화");
		JCheckBox checkBox2=new JCheckBox("버튼 감추기");
		checkBox1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED) {
					button.setEnabled(false);
				}
				else {
					button.setEnabled(true);

				}
			}
		});
		
		checkBox2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED) {
					button.setVisible(false);
				}
				else {
					button.setVisible(true);
				}
			}
		});
		
		c.add(checkBox1);
		c.add(checkBox2);
		
		c.add(button);
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[]args) {
		new MyEvent();
	}

}
