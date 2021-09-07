package thread.ex5;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyThread extends JFrame{
	private ImageIcon image=new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕"
			+ "\\아무사진\\han1.jfif");
	private Image img=image.getImage();
	
	void domain() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container=getContentPane();
		container.setLayout(null);
		
		JLabel player=new JLabel();
		player.setSize(50,50);
		player.setBackground(Color.BLACK);
		player.setLocation(container.getX()/2, 0);
		player.setOpaque(true);
		container.add(player);
		
		JLabel missile=new JLabel();
		missile.setSize(10,10);
		Missile missileLaunch=new Missile(missile, player);
		
		container.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					Thread missileThread=new Thread(missileLaunch);
					missileThread.start();
				}
				
			}
		});

		JLabel targetLable=new JLabel();
		Target target=new Target(targetLable,container);
		image=new ImageIcon(img);
		targetLable.setIcon(image);
		targetLable.setLocation(40, 0);
		container.add(targetLable);
		target.start();
		
		setSize(500,500);
		setVisible(true);
		
		container.setFocusable(true);
		container.requestFocus();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread my=new MyThread();
		my.domain();
	}

}
