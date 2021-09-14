package thread.ex9;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

public class GameLabel extends JPanel {
	private JLabel[] gameLabel;
	private GamblingThread gt;
	private JLabel last;
	public GameLabel(JLabel[] gameLabel, GamblingThread gt,JLabel last) {
		// TODO Auto-generated constructor stub
		this.gameLabel = gameLabel;
		this.gt = gt;
		this.last=last;
		for (int i = 0; i < 3; i++) {
			JPanel panel = new JPanel();
			gameLabel[i].setFont(new Font("Arial", Font.ITALIC, 50));
			gameLabel[i].setForeground(Color.YELLOW);
			panel.add(gameLabel[i]);
			panel.setSize(100, 50);
			panel.setLocation(100 * (i + 30), 100);
			panel.setBackground(Color.MAGENTA);
			add(panel);
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					// TODO Auto-generated method stub
					gt.startGambling();
				}
			});
			
			panel.requestFocus();
		}
		last.setFont(new Font("Gothic",Font.BOLD,20));
		last.setBackground(Color.LIGHT_GRAY);
		last.setOpaque(true);
		last.setLocation(400, 400);
		add(last);

	}

}
