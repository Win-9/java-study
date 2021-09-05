package thread.refac;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

public class Avatar extends KeyAdapter {
	private Container container;
	private JLabel avatar;

	public Avatar(Container container, JLabel avatar) {
		// TODO Auto-generated constructor stub
		this.container = container;
		this.avatar = avatar;
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {

		case KeyEvent.VK_UP:
			avatar.setLocation(avatar.getX(), avatar.getY() - 10);
			break;
		case KeyEvent.VK_DOWN:
			avatar.setLocation(avatar.getX(), avatar.getY() + 10);
			break;
		case KeyEvent.VK_LEFT:
			avatar.setLocation(avatar.getX() - 10, avatar.getY());
			break;
		case KeyEvent.VK_RIGHT:
			avatar.setLocation(avatar.getX() + 10, avatar.getY());
			break;
		}

		container.repaint();
	}
}
