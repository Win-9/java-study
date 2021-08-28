package graphics.practice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyEvent extends JFrame {
	private MyPanel panel=new MyPanel();
	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		
		setSize(400,400);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		private Vector<Point> vStart=new Vector<>();
		private Vector<Point> vEnd=new Vector<>();
		public MyPanel() {
			// TODO Auto-generated constructor stub
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					Point startP=e.getPoint();
					vStart.add(startP);
				}
				
				public void mouseReleased(MouseEvent e) {
					Point endP=e.getPoint();
					vEnd.add(endP);
					
					repaint();
				}
			});
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			
			for(int i=0;i<vStart.size();i++) {
				Point s=vStart.elementAt(i);
				Point e=vEnd.elementAt(i);
				
				g.drawLine((int)s.getX(),(int)s.getY(),(int)e.getX(),(int)e.getY());
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
