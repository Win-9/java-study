package thread.refac;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;

public class Monster extends Thread {
	private Container container;
	private JLabel monster;
	private JLabel avatar;
	private JLabel end;

	public Monster(JLabel monster, JLabel avatar, Container container) {
		this.monster = monster;
		this.avatar = avatar;
		this.container = container;
	}

	public void run() {
		while (true) {
			try {
				sleep(200);
			} catch (InterruptedException e) {
				return;
			}
			setNewLocation();

			if (isSameLocation()) {
				container.removeAll();
				end = new JLabel("CATCHED!");
				end.setLocation(50, 50);
				end.setFont(new Font("Arial", Font.ITALIC, 50));
				end.setForeground(Color.GREEN);
				end.setSize(400, 400);

				container.repaint();

				container.add(end);
				return;
			}
		}
	}

	public void setNewLocation() {
		int avartarX = avatar.getX();
		int avartarY = avatar.getY();

		int monX = monster.getX();
		int monY = monster.getY();

		if (avartarX == monX) {
			if (avartarY < monY) {
				monster.setLocation(monX, monY - 5);
			} else if (avartarY == monY) {
				monster.setLocation(monX, monY);
			} else {
				monster.setLocation(monX, monY + 5);
			}
			return;
		}
		if (avartarX < monX) {
			if (avartarY < monY) {
				monster.setLocation(monX - 5, monY - 5);
			} else if (avartarY == monY) {
				monster.setLocation(monX - 5, monY);
			} else {
				monster.setLocation(monX - 5, monY + 5);
			}
		} else {
			if (avartarY < monY) {
				monster.setLocation(monX + 5, monY - 5);
			} else if (avartarY == monY) {
				monster.setLocation(monX + 5, monY);
			} else {
				monster.setLocation(monX + 5, monY + 5);
			}
		}

	}

	public boolean isSameLocation() {
		Point avartarLocation = avatar.getLocation();
		Point monsterLocation = monster.getLocation();
		if (avartarLocation.getX() == monsterLocation.getX() &&
				avartarLocation.getY() == monsterLocation.getY()) {
			return true;
		}
		return false;
	}

}
