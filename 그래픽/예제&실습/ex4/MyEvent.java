package graphics.ex4;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyEvent extends JFrame{
	private MyPanel panel=new MyPanel();
	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(600,600);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		private int x=0;
		private int y=0;
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon image=new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진\\han1.jfif");
			Image img=image.getImage();
			int width=img.getWidth(this);
			int height=img.getWidth(this);
			g.drawImage(img,x,y,width,height,this);

			addMouseMotionListener(new MouseAdapter() {
				public void mouseDragged(MouseEvent e) {
					// TODO Auto-generated method stub
					x=e.getX();
					y=e.getY();
					repaint();
				}
			});
			
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
