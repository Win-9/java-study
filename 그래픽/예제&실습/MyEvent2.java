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
			g.setColor(Color.red);
			g.drawLine(20, 20, 100, 100);
			
			g.drawOval(50,50,80,80);
			g.drawRect(60, 60, 70, 100);
			g.drawRoundRect(20, 20, 120, 80, 40, 60);
			
			
			g.drawArc(120, 100, 80, 80, 90, 270);
			int[]x= {80,40,80,120};
			int[]y= {40,120,200,120};
			g.drawPolygon(x,y,4);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
