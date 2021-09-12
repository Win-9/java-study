package thread.ex9;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyThread extends JFrame {
	private JLabel[] gameLabel = new JLabel[3];

	void run() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < 3; i++) {
			gameLabel[i] = new JLabel("0");
		}
		GamblingThread gt = new GamblingThread(gameLabel);

		setContentPane(new GameLabel(gameLabel, gt));


		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread myThread = new MyThread();
		myThread.run();
	}

}
