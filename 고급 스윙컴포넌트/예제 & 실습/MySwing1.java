package HighLevel.ex;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javafx.scene.layout.Border;

public class MySwing extends JFrame{
	private JLabel imgLabel=new JLabel();
	public MySwing() {
		setTitle("ex");
		createMenu();
		getContentPane().add(imgLabel,BorderLayout.CENTER);
		
		setSize(300,300);
		setVisible(true);
	}
	
	void createMenu() {
		JMenuBar mb=new JMenuBar();
		JMenuItem[] menuItem=new JMenuItem[4];
		String[]itemTitle= {"Load","Hide","Reshow","Exit"};
		JMenu screenMenu=new JMenu("Screen");
		
		MenuAction listener=new MenuAction();
		for(int i=0;i<menuItem.length;i++) {
			menuItem[i]=new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(listener);
			screenMenu.add(menuItem[i]);
		}
		mb.add(screenMenu);
		setJMenuBar(mb);
		
	}
	
	class MenuAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String cmd=e.getActionCommand();
			switch (cmd) {
			case "Load":
				if(imgLabel.getIcon()!=null)
					return;
				imgLabel.setIcon(new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진\\han1.jfif"));
				break;
			case "Hide":
				imgLabel.setVisible(false);
				break;
			case "Reshow":
				imgLabel.setVisible(true);

				break;
			case "Exit":
				System.exit(0);
				break;

			default:
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MySwing();
	}

}
