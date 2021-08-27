package graphics.practice;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyEvent extends JFrame {
	
	private MyPanel panel=new MyPanel();
	
	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		
		
		setSize(500,500);
		setVisible(true);
	}
			
	
	class MyPanel extends JPanel{
		private ImageIcon icon=new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진\\국뽕1.jfif");
		private Image img=icon.getImage();
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img,20,20,250,100,100,50,200,200,this);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
