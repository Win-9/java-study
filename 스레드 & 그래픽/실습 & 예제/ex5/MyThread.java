package thread.ex5;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyThread extends JFrame {
	private ImageIcon image = new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕" + "\\아무사진\\han1.jfif");
	private Image img = image.getImage();
	private Missile missileLaunch = null;

	void domain() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(500, 500);
		setVisible(true);

		Container container = getContentPane();
		container.setLayout(null);

		JLabel player = new JLabel();
		player.setSize(50, 50);
		player.setBackground(Color.BLACK);
		player.setLocation(container.getWidth() / 2 - 10, container.getHeight() - 50);
		player.setOpaque(true);
		container.add(player);

		JLabel missile = new JLabel();
		missile.setSize(20, 20);
		missile.setBackground(Color.RED);
		container.add(missile);
		container.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					missileLaunch = new Missile(missile, player);
					missileLaunch.start();
				}

			}
		});

		Image changeImage = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);

		JLabel targetLable = new JLabel();
		Target target = new Target(targetLable, container);
		image = new ImageIcon(changeImage);
		targetLable.setIcon(image);
		targetLable.setLocation(20, 20);
		targetLable.setSize(60, 60);
		container.add(targetLable);
		target.start();

		if (missile.getY() == targetLable.getX()) {
			targetLable.setLocation(20, 20);
			missileLaunch.finish();
			System.out.println("shot");
		}

		container.setFocusable(true);
		container.requestFocus();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread my = new MyThread();
		my.domain();
	}

}
