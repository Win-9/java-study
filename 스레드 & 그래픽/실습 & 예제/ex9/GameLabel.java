package thread.ex9;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

public class GameLabel extends JPanel {
	private JLabel[] gameLabel;
	private GamblingThread gt;

	public GameLabel(JLabel[] gameLabel, GamblingThread gt) {
		// TODO Auto-generated constructor stub
		this.gameLabel = gameLabel;
		this.gt = gt;
		for (int i = 0; i < 3; i++) {
			JPanel panel = new JPanel();
			gameLabel[i].setFont(new Font("Arial", Font.ITALIC, 50));
			gameLabel[i].setForeground(Color.YELLOW);
			panel.add(gameLabel[i]);
			panel.setSize(100, 50);
			panel.setLocation(100 * (i + 30), 50);
			panel.setBackground(Color.MAGENTA);
			add(panel);
			panel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					System.out.println("시이발");
					gt.startGambling();
				}
			});
		}

	}

}
