package HighLevel.ex;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MySwing extends JFrame{
	
	private JLabel imageLabel=new JLabel();
	public MySwing() {
		super("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container=getContentPane();
		container.add(imageLabel);
		createMenu();
		
		
		setSize(500,500);
		setVisible(true);
	}
	
	public void createMenu() {
		JMenuBar mb=new JMenuBar();
		JMenu fileMenu=new JMenu("File");
		JMenuItem openItem =new JMenuItem("open");
		
		openItem.addActionListener(new OpenActionListener());
		
		fileMenu.add(openItem);
		mb.add(fileMenu);
		setJMenuBar(mb);
	}
	
	class OpenActionListener implements ActionListener{
		private JFileChooser chooser;
		
		public OpenActionListener() {
			// TODO Auto-generated constructor stub
			chooser=new JFileChooser();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			FileNameExtensionFilter filter=new FileNameExtensionFilter(
					"JPG & JFIF Images", "jpg","jfif");
			
			chooser.setFileFilter(filter);
			
			int ret=chooser.showOpenDialog(null);
			if(ret!=JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일선택x",
						"경고",JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			String filePath=chooser.getSelectedFile().getPath();
			imageLabel.setIcon(new ImageIcon(filePath));
			pack();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MySwing();
	}

}
