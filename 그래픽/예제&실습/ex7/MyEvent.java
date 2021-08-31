package graphics.ex7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.stream.Stream;

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
		private Vector<Point>point=new Vector<Point>();
		public MyPanel() {
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					point.add(e.getPoint());
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
			
			int[]x=new int[point.size()];
			int[]y=new int[point.size()];
			for(int i=0;i<point.size();i++) {
				x[i]=(int)point.get(i).getX();
				y[i]=(int)point.get(i).getY();
			}
			
			for(int i=0;i<x.length;i++) {
				System.out.println("x:"+x[i]);
				System.out.println("y:"+y[i]);
			}
			g.drawPolygon(x, y, point.size());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
