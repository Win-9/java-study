package graphics.practice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

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
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawString("Welcome to the Factory",30,30);
			g.setColor(new Color(255,0,0));
			
			g.setFont(new Font("Arial",Font.ITALIC,30));
			g.setColor(new Color(0x00ff00ff));
			for(int i=0;i<=5;i++) {
				g.setFont(new Font("man",Font.ITALIC,i*10));
				g.drawString("This", 30, 60+i*60);
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
