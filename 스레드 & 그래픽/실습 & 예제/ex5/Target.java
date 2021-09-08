package thread.ex5;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Target extends Thread {
	private Container container;
	private JLabel targetLable;
	private int targetLocationX;
	private boolean reverseFlag = false;
	private boolean endFlag = false;

	public Target(JLabel targetLable, Container container) {
		this.targetLable = targetLable;
		this.container = container;
		int targetLocationX = targetLable.getX();
	}

	public void run() {
		while (true) {
			if (reverseFlag) {
				targetLocationX -= 5;
				targetLable.setLocation(targetLocationX, 0);
			} else {
				targetLocationX += 5;
				targetLable.setLocation(targetLocationX, 0);
			}

			setReverseFlag();

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (endFlag) {
				targetLable.setLocation(40, 0);
			}

		}
	}

	public void setReverseFlag() {
		if (targetLocationX + 50 >= container.getWidth()) {
			reverseFlag = true;
		} else if (targetLocationX == 0) {
			reverseFlag = false;
		}
	}

}
