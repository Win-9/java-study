package graphics.ex1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyEvent extends JFrame{
	private ImageIcon image=new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진\\han1.jfif");
	private Image img=image.getImage();
	private MyPanel panel=new MyPanel();
	private boolean show=true;
	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton button=new JButton("Hide/Show");
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				show=(!show);
				if(show==false) {
					img=null;
				}
				else {
					img=image.getImage();
				}
				repaint();
			}
		});
		c.add(button);
		
		setSize(400,400);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img,0,0,getWidth(),getHeight(),this);
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
