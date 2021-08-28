package graphics.ex1;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;import java.awt.event.MouseListener;

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

		
		setSize(400,400);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		private Point p;
		public MyPanel() {			
			addMouseMotionListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					p=e.getPoint();
					repaint();
				}
				public void mouseDragged(MouseEvent e) {
					p=e.getPoint();
					repaint();
				}
			});
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img,0,0,getWidth(),getHeight(),this);
			
			g.setColor(Color.GREEN);
			if(p!=null) {
				g.fillOval((int)p.getX(), (int)p.getY(), 20, 20);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
