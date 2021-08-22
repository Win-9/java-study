package Component.ex9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
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

import Swing.ex7.South;

public class MyEvent extends JFrame{
	private ImageIcon[]image=new ImageIcon[3];
	private JButton[]ImageButton=new JButton[3];
	private JLabel com=new JLabel("com");
	private JPanel center=new JPanel();
	private JLabel player=new JLabel("me");
	private JLabel result=new JLabel();
	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		
		File f=new File("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진\\가위바위보");
		File[]name=f.listFiles();
		JPanel north=new JPanel();
		for(int i=0;i<3;i++) {
			image[i]=new ImageIcon(name[i].toString());
			Image img=image[i].getImage();
			Image change=img.getScaledInstance(255, 255, Image.SCALE_SMOOTH);
			image[i]=new ImageIcon(change);
			
			ImageButton[i]=new JButton(image[i]);
			ImageButton[i].setHorizontalAlignment(SwingConstants.CENTER);
			ImageButton[i].addMouseListener(new MyListener());
			north.add(ImageButton[i]);
		}
		north.setBackground(Color.black);
		
		
		center.setLayout(new FlowLayout());
		center.setBackground(Color.YELLOW);
		
		result.setOpaque(true);
		result.setForeground(Color.RED);
		
		center.add(player);
		center.add(com);
		center.add(result);
		
		c.add(north,BorderLayout.NORTH);
		c.add(center,BorderLayout.CENTER);
		
		setSize(1200,1200);
		setVisible(true);
		
	}
	
	class MyListener extends MouseAdapter{
			
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int num=(int)(Math.random()*3);
			if(e.getSource()==ImageButton[0]) {
				player.setIcon(image[0]);
				if(num==0) {
					com.setIcon(image[num]);
					result.setText("Same!!");
				}
				else if(num==1) {
					com.setIcon(image[num]);
					result.setText("Computer!!");
				}
				else {
					com.setIcon(image[num]);
					result.setText("Me!!");
					
				}
			}
			else if(e.getSource()==ImageButton[1]) {
				player.setIcon(image[1]);
				com.setIcon(image[0]);
				if(num==0) {
					com.setIcon(image[num]);
					result.setText("Me!!");
				}
				else if(num==1) {
					com.setIcon(image[num]);
					result.setText("Same!!");
				}
				else {
					com.setIcon(image[num]);
					result.setText("Computer!!");
				}
			}
			else {
				player.setIcon(image[2]);
				com.setIcon(image[0]);
				if(num==0) {
					com.setIcon(image[num]);
					result.setText("Computer!!");
				}
				else if(num==1) {
					com.setIcon(image[num]);
					result.setText("Me!!");
				}
				else {
					com.setIcon(image[num]);
					result.setText("Same!!");
				}
			}				
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
