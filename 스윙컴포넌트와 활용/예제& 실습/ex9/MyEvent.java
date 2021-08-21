package Component.ex9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyEvent extends JFrame{
	private ImageIcon[]image;
	private JButton[]ImageButton=new JButton[3];
	private JLabel jlabel=new JLabel();

	
	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		
		File f=new File("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진");
		File[]name=f.listFiles();
		
		JPanel north=new JPanel();
		for(int i=0;i<3;i++) {
			image[i]=new ImageIcon(name[i].toString());
			ImageButton[i]=new JButton(image[i]);
			ImageButton[i].setHorizontalAlignment(SwingConstants.CENTER);
			ImageButton[i].addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					jlabel=new JLabel("me",SwingConstants.CENTER);
					
				}
			});
			north.add(ImageButton[i]);
		}
		north.setBackground(Color.black);
		
		
		JPanel center=new JPanel();
		center.setBackground(Color.YELLOW);
		center.add(jlabel);
		
		
		
		c.add(north,BorderLayout.NORTH);
		c.add(center,BorderLayout.CENTER);
		
		setSize(300,300);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
