package HighLevel.ex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class MySwing extends JFrame{
	
	private JLabel label=new JLabel("HI");
	public MySwing() {
		super("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container=getContentPane();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Ravie",Font.ITALIC,40));
		container.add(label,BorderLayout.CENTER);
		createMenu();
		
		setSize(500,500);
		setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar jm=new JMenuBar();
		JMenuItem colorMenuItem=new JMenuItem("Color");
		JMenu menu=new JMenu("Text");
		
		colorMenuItem.addActionListener(new MenuAction());
		
		menu.add(colorMenuItem);
		jm.add(colorMenuItem);
		this.setJMenuBar(jm);
	}
	
	class MenuAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String cmd=e.getActionCommand();
			
			if(cmd.equals("Color")) {
				Color selectedColor=JColorChooser.showDialog(null, "Color", Color.YELLOW);
			
				if(selectedColor!=null) {
					label.setForeground(selectedColor);
				}
			}
			
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MySwing();
	}

}
