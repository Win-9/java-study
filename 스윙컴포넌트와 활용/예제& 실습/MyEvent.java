package Component;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyEvent extends JFrame{
	
	private ImageIcon[]image= {
			new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진\\국뽕1.jfif"),
			new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진\\국뽕2.jfif"),
			new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진\\국뽕3.jfif")
	};
	
	private String[]name= {"국뽕1","국뽕2","국뽕3"};
	private JLabel jLabels=new JLabel(image[0]);
	
	
	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		JComboBox<String>jcombo=new JComboBox<>(name);
		
		c.add(jcombo);
		c.add(jLabels);
		
		jcombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox<String>jcombo=(JComboBox)e.getSource();
				
				int index=jcombo.getSelectedIndex();
				jLabels.setIcon(image[index]);
				
			}
		});
		
		
		setSize(300,300);
		setVisible(true);
		
		
	}
	
	public static void main(String[]args) {
		new MyEvent();
	}

}
