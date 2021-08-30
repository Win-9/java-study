package graphics.ex6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyEvent_2 extends JFrame{
	private MyPanel panel=new MyPanel();
	public MyEvent_2() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(600,600);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int[]marum_x= {0,getWidth()/2,getWidth(),getWidth()/2};
			int[]marum_y= {getHeight()/2,getHeight(),getHeight()/2,0};

			for(int i=1;i<10;i++) {
				g.drawPolygon(marum_x,marum_y,4);
				marum_x[0]+=25;
				marum_x[2]-=25;
				marum_y[1]-=25;
				marum_y[3]+=25;
				
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent_2();
	}

}
