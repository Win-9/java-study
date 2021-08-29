package graphics.ex5;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
		private ImageIcon image=new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진\\han1.jfif");
		private Image img=image.getImage();
		private int x=img.getHeight(this),y=img.getWidth(this);
		
		public MyPanel() {
			addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					if(e.getKeyChar()=='+') {
						x*=1.1;
						y*=1.1;
					}
					else if(e.getKeyChar()=='-') {
						x*=0.9;
						y*=0.9;
					}
					repaint();
				}
			});
			
			setFocusable(true);
			requestFocus();
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img,0, 0,x,y,this);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
