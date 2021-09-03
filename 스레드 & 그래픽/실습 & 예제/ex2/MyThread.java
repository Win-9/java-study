package thread.ex2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Swing.ex3.MyFrame;

public class MyThread extends JFrame{
	
	private MyPanel panel=new MyPanel();
	public MyThread() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel);
		setContentPane(panel);
		Start st=new Start(panel);
		
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				Thread th=new Thread(st);
				th.start();
			}
		});
		
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyThread();
	}

}

class MyPanel extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		int x=(int)(Math.random()*255);
		int y=(int)(Math.random()*255);
		
		g.drawOval(x, y, 50, 50);
	}
}


class Start implements Runnable{
	private MyPanel panel;
	
	public Start(MyPanel panel) {
		// TODO Auto-generated constructor stub
		this.panel=panel;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			panel.repaint();
		}
	}
	
}
