package graphics.ex9;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyEvent extends JFrame{
	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		BlueLabel small=new BlueLabel("hello");
		small.setForeground(Color.YELLOW);
		small.setOpaque(true);
		
		BlueLabel big=new BlueLabel("Big Hello");
		big.setForeground(Color.MAGENTA);
		big.setFont(new Font("Arial",Font.ITALIC,50));
		big.setOpaque(true);
		
		c.add(small);
		c.add(big);
		
		
		setSize(600,600);
		setVisible(true);
	}
	
	class BlueLabel extends JLabel{
		public BlueLabel(String str) {
			super(str);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.BLUE);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
