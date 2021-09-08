package thread.ex7;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	private ImageIcon image=new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕"
			+ "\\아무사진\\제갈병춘.jpg");
	private Image img=image.getImage();
	private String direction;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_UP:
					direction="UP";
					break;
				case KeyEvent.VK_DOWN:
					direction="DOWN";
					break;
				case KeyEvent.VK_LEFT:
					direction="LEFT";
					break;
				case KeyEvent.VK_RIGHT:
					direction="RIGHT";
					break;
				}
			}
		});
	}
	
	public String getDirection() {
		return direction;
	}

}
