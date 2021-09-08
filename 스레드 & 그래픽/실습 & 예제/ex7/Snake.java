package thread.ex7;

import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Snake extends JPanel implements Runnable {
	private MyPanel panel;
	private Vector<JLabel> imageVector = new Vector<>();

	public Snake(MyPanel panel) {
		// TODO Auto-generated constructor stub
		this.panel = panel;
	}

	public void run() {
		while (true) {
			if (panel.getDirection() == "UP") {
				System.out.println("up");
				stateUp();
			} else if (panel.getDirection() == "DOWN") {
				System.out.println("down");
				stateDown();
			} else if (panel.getDirection() == "LEFT") {
				System.out.println("left");
				stateLeft();
			} else {
				System.out.println("right");
				stateRight();
			}
		}
	}

	public void stateUp() {
		for (JLabel jlabel : imageVector) {
			jlabel.setLocation(jlabel.getX(), jlabel.getY() - 5);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void stateDown() {
		for (JLabel jlabel : imageVector) {
			jlabel.setLocation(jlabel.getX(), jlabel.getY() + 5);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void stateLeft() {
		for (JLabel jlabel : imageVector) {
			jlabel.setLocation(jlabel.getX() - 5, jlabel.getY());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void stateRight() {
		for (JLabel jlabel : imageVector) {
			jlabel.setLocation(jlabel.getX() + 5, jlabel.getY() - 5);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
