package thread.ex5;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Missile extends KeyAdapter implements Runnable{
	private JLabel missileLaunch;
	private JLabel player;
	
	public Missile(JLabel missileLaunch,JLabel player) {
		// TODO Auto-generated constructor stub
		this.missileLaunch=this.missileLaunch;
		this.player=player;
	}
	
	
	public void run() {
		
		int missileY=player.getY();
		int missileX=player.getX();
		
		while(missileY!=0) {
			missileLaunch.setLocation(missileX, missileY);
			missileY-=10;
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

}
