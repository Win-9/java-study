package thread.example;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class MyLabel extends JLabel{
	private int barSize=0;
	private int maxBarsize;
	public MyLabel(int maxBarSize) {
		// TODO Auto-generated constructor stub
		this.maxBarsize=maxBarSize;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		int width=(int)(((double)(this.getWidth()))/maxBarsize*barSize);
		
		if(width==0) {
			return;
		}
		
		g.fillRect(0,0,width,this.getHeight());
	}
	
	synchronized public void fill() {
		if(barSize==maxBarsize) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
		}
		barSize++;
		repaint();
		notify();
	}
	
	synchronized public void consume() {
		if(barSize==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		barSize--;
		repaint();
		notify();
	}

}
