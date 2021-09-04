package thread.another;

import java.awt.Container;

import javax.swing.JLabel;

public class Monster extends Thread{
	private Container container;
	private JLabel monster;
	private JLabel avatar;
	public Monster(JLabel monster,JLabel avatar,Container container) {
		this.monster=monster;
		this.avatar=avatar;
		this.container=container;
	}
	
	public void run() {
		while(true) {
			try {
				sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setNewLocation();
			
		}
	}
	
	public void setNewLocation() {
		int avar_x=avatar.getX();
		int avar_y=avatar.getY();
		
		int mon_x=monster.getX();
		int mon_y=monster.getY();
		
		if(avar_x<mon_x) {
			if(avar_y<mon_y) {
				monster.setLocation(mon_x-5, mon_y-5);
			}
			else if(avar_y==mon_y){
				monster.setLocation(mon_x-5, mon_y);
			}
			else {
				monster.setLocation(mon_x-5, mon_y+5);
			}
		}
		else if(avar_x==mon_x){
			if(avar_y<mon_y) {
				monster.setLocation(mon_x, mon_y-5);
			}
			else if(avar_y==mon_y){
				monster.setLocation(mon_x, mon_y);
			}
			else {
				monster.setLocation(mon_x, mon_y+5);
			}
		}
		else {
			if(avar_y<mon_y) {
				monster.setLocation(mon_x+5, mon_y-5);
			}
			else if(avar_y==mon_y){
				monster.setLocation(mon_x+5, mon_y);
			}
			else {
				monster.setLocation(mon_x+5, mon_y+5);
			}
		}
		
	}

}
