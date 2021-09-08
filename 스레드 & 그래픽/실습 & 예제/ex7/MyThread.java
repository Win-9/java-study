package thread.ex7;

import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyThread extends JFrame {
	private MyPanel myPanel = new MyPanel();
	private Vector<JLabel> imageVector = new Vector<>();
	private JLabel head = new JLabel();
	private JLabel[] body = new JLabel[9];

	private ImageIcon headImg = new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕" + "\\아무사진\\han1.jfif");
	private ImageIcon bodyImg = new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕" + "\\아무사진\\han2.jfif");

	void domain() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(myPanel);

		Image img = headImg.getImage();
		Image fixImage = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		headImg = new ImageIcon(fixImage);
		head.setIcon(headImg);
		add(head);
		imageVector.add(head);

		img = bodyImg.getImage();
		fixImage = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		bodyImg = new ImageIcon(fixImage);

		for (int i = 0; i < 9; i++) {
			body[i] = new JLabel();
			body[i].setIcon(bodyImg);
			add(body[i]);
			imageVector.add(body[i]);
		}

		Thread thread = new Thread(new Snake(myPanel));
		thread.start();

		setSize(1200, 1200);
		setVisible(true);

		setFocusable(true);
		requestFocus();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread myThread = new MyThread();
		myThread.domain();
	}

}
