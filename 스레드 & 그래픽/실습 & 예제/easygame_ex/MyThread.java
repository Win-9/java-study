package thread.another;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyThread extends JFrame {
	private JLabel end;
	
	public MyThread() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		
		c.setLayout(null);
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()=='q') {
					c.removeAll();
					end=new JLabel("END!");
					end.setLocation(50, 50);
					end.setFont(new Font("Arial",Font.ITALIC,100));
					end.setForeground(Color.GREEN);
					end.setSize(400, 400);
					
					c.repaint();
					
					c.add(end);
				}
			}
		});
		
		JLabel avatar=new JLabel("A");
		avatar.setForeground(Color.RED);
		avatar.setSize(10,10);
		avatar.setLocation(20, 20);
		System.out.println("아아ㅏ");

		c.addKeyListener(new Avatar(c,avatar));
		
		c.add(avatar);
		JLabel monster=new JLabel("M");
		
		monster.setSize(10,10);
		monster.setLocation(100, 100);
		
		c.add(monster);
		
		Monster monster_clazz=new Monster(monster, avatar, c);
		
		monster_clazz.start();
		
		
		setSize(500,500);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyThread();
	}

}

