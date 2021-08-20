package Component.ex8;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class MyEvent extends JFrame{
	int index=0;

	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		
		File f=new File("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진");
		File[]name=f.listFiles();
		Vector<ImageIcon>vector=new Vector<>();
		for(File e:name) {
			ImageIcon im=new ImageIcon(f.getPath());
			vector.add(im);
		}
		JPanel button=new JPanel();
		ButtonGroup group=new ButtonGroup();
		JRadioButton left=new JRadioButton("left");
		JRadioButton right=new JRadioButton("right");
		group.add(left);
		group.add(right);
		button.add(left);
		button.add(right);
		
		
		JLabel label=new JLabel();
		label.setIcon(new ImageIcon(name[0].toString()));

		
		left.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e) {
				if(left.isSelected()) {
					label.setIcon(new ImageIcon(name[index].toString()));
					if(index!=0) {
						index--;
					}
				}
			}
		});
		
		
		right.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e) {
				label.setIcon(new ImageIcon(name[index].toString()));
				if(index!=name.length-1) {
					index++;
				}
			}
		});
		
		c.add(label,BorderLayout.CENTER);
		c.add(button,BorderLayout.NORTH);
		
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
