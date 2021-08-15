package Component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import javafx.scene.layout.Border;

public class MyEvent extends JFrame{
	
	ImageIcon []image= {
			new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진\\국뽕1.jfif"),
			new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진\\국뽕2.jfif"),
			new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진\\국뽕3.jfif")
	};
	private String[]name= {"국뽕1","국뽕2","국뽕3"};
	private JRadioButton[]radio=new JRadioButton[3];
	
	private JLabel j=new JLabel();
	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonGroup group=new ButtonGroup();
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel jpanel=new JPanel();
		jpanel.setBackground(Color.CYAN);
		
		for(int i=0;i<3;i++) {
			radio[i]=new JRadioButton(name[i]);
			group.add(radio[i]);
			jpanel.add(radio[i]);
			radio[i].addItemListener(new MyListener());
		}
		
		c.add(jpanel,BorderLayout.NORTH);
		c.add(j,BorderLayout.CENTER);
		
		j.setHorizontalAlignment(SwingConstants.CENTER);
		
		setSize(300,300);
		setVisible(true);
	}
	
	class MyListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			if(e.getStateChange()==ItemEvent.DESELECTED) {
				return;
			}
			
			// TODO Auto-generated method stub
			if(radio[0].isSelected()) {
				j.setIcon(image[0]);
			}
			else if(radio[1].isSelected()) {
				j.setIcon(image[1]);
			}
			else {
				j.setIcon(image[2]);
			}
		}
		
	}
	
	public static void main(String[]args) {
		new MyEvent();
	}

}
