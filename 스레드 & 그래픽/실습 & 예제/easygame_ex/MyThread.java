package thread.refac;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyThread extends JFrame {
	private JLabel end;
	private JLabel avatar;
	private JLabel monster;

	void createAvatar(String shape) {
		avatar = new JLabel(shape);
		avatar.setForeground(Color.RED);
		avatar.setSize(10, 10);
		avatar.setLocation(20, 20);
	}

	void createMonster(String shape) {
		monster = new JLabel(shape);
		monster.setSize(10, 10);
		monster.setLocation(100, 100);
	}

	void mymain() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();

		container.setLayout(null);
		container.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == 'q') {
					container.removeAll();
					end = new JLabel("END!");
					end.setLocation(50, 50);
					end.setFont(new Font("Arial", Font.ITALIC, 100));
					end.setForeground(Color.GREEN);
					end.setSize(400, 400);

					container.repaint();

					container.add(end);
				}
			}
		});
		createAvatar("A");
		container.addKeyListener(new Avatar(container, avatar));
		container.add(avatar);

		createMonster("M");
		container.add(monster);

		Monster runMonster = new Monster(monster, avatar, container);
		runMonster.start();

		setSize(500, 500);
		setVisible(true);

		container.setFocusable(true);
		container.requestFocus();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread mythread = new MyThread();
		mythread.mymain();
	}

}
