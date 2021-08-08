package Component;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class MyEvent extends JFrame{
	
	public MyEvent() {
		super("JComponent");
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton b1=new JButton("Button1");
		JButton b2=new JButton("Button2");
		JButton b3=new JButton("Button3");
		
		b1.setBackground(Color.YELLOW);
		b1.setForeground(Color.MAGENTA);
		b1.setFont(new Font("Arial",Font.ITALIC,20));
		
		b2.setEnabled(false);
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b=(JButton)e.getSource();
				MyEvent frame=(MyEvent)b.getTopLevelAncestor();
				frame.setTitle(b.getX()+","+b.getY());
			}
		});
		
		c.add(b1);
		c.add(b2);
		c.add(b3);
		
		setSize(260,200);
		setVisible(true);
		
		
		
	}
	
	public static void main(String[]args) {
		new MyEvent();
	}

}
