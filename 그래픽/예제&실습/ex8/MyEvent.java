package graphics.ex8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JPanel;


class Circle{
	int x,y,width,height;
	public Circle(int x,int y, int width,int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
}

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
		private Vector<Circle>circle=new Vector<Circle>();
		private int press_x,press_y;
		public MyPanel() {
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					int last_x=e.getX();
					int last_y=e.getY();
					int width=Math.abs((last_x-press_x)*2);
					circle.add(new Circle(press_x,press_y,width,width));
					repaint();
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					press_x=e.getX();
					press_y=e.getY();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
			for(Circle c:circle) {
				g.drawOval(c.x, c.y, c.width, c.height);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
