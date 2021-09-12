package thread.ex9;

import javax.swing.JLabel;

public class GamblingThread extends JLabel implements Runnable {
	private JLabel[] gameLabel;
	private JLabel result = new JLabel("마우스를 클릭할때마다 시작.");

	public GamblingThread(JLabel[] gameLabel) {
		this.gameLabel = gameLabel;
		result.setLocation(30, 30);
		add(result);
		Thread th = new Thread(this);
		th.start();
	}

	public void run() {
		while (true) {
			waitForGambling();
			for (int i = 0; i < 3; i++) {
				gameLabel[i].setText(Integer.toString((int) (Math.random() * 5)));
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (isSame()) {
				result.setText("축하합니다.");
				continue;
			}
			result.setText("땡");
		}
	}

	public boolean isSame() {
		return gameLabel[0].getText() == gameLabel[1].getText() && 
				gameLabel[1].getText() == gameLabel[2].getText();
	}

	synchronized public void waitForGambling() {
		System.out.println("앙멈췄디");
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized public void startGambling() {
		notify();
	}

}
