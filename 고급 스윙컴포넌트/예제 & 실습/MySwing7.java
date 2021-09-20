package HighLevel.ex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import thread.ex7.MyPanel;

public class MySwing extends JFrame{
	
	private JLabel label=new JLabel("HI");
	public void run() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		JTabbedPane pane=createTabbedPane();
		c.add(pane,BorderLayout.CENTER);
		setVisible(true);
		setSize(400,400);
	}
	
	JTabbedPane createTabbedPane() {
		JTabbedPane pane=new JTabbedPane();
		pane.addTab("tab1",new JLabel(new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\"
				+ "아무사진\\제갈병춘.jpg")));
		pane.addTab("tab2",new JLabel(new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\"
				+ "아무사진\\han2.jfif")));
		pane.addTab("tab3",new JLabel(new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\"
				+ "아무사진\\han1.jfif")));
		pane.addTab("tab4",new MyPanel());
		return pane;
	}
	
	class MyPanel extends JPanel{
		public MyPanel() {
			this.setBackground(Color.YELLOW);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(10, 10, 50, 50);
			g.setColor(Color.BLUE);
			g.fillOval(10, 70, 50, 50);
			g.setColor(Color.BLACK);
			g.drawString("깔까띾라깎ㄹ", 30, 50);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MySwing().run();
	}

}
