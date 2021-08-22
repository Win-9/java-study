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
		System.out.println(name[2]);
		JPanel north=new JPanel();
		for(int i=0;i<3;i++) {
			image[i]=new ImageIcon(name[0].toString());
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
			ImageIcon computer=new ImageIcon(image[num].toString());
			if(e.getSource()==ImageButton[0]) {
				player.setIcon(image[0]);
				com.setIcon(computer);
				if(num==0) {
					result.setText("Same!!");
				}
				else if(num==1) {
					result.setText("Computer!!");
				}
				else {
					result.setText("Me!!");
					
				}
			}
			else if(e.getSource()==ImageButton[1]) {
				if(num==0) {
					result.setText("Me!!");
				}
				else if(num==1) {
					result.setText("Same!!");
					
				}
				else {
					result.setText("Computer!!");
				}
			}
			else {
				if(num==0) {
					result.setText("Computer!!");
				}
				else if(num==1) {
					result.setText("Me!!");
				}
				else {
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
