package thread.ex11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyThread extends JFrame{
	private JTextField underTextField=new JTextField(8);
	private String text;
	void run() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container=getContentPane();
		container.setLayout(new BorderLayout());
		
		JLabel center=new JLabel();
		center.setBackground(Color.LIGHT_GRAY);
		container.add(center,BorderLayout.CENTER);
		
		
		underTextField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					text=underTextField.getText();
					underTextField.setText("");
				}
			}
		});
		container.add(underTextField,BorderLayout.SOUTH);
		setSize(300, 300);
		setVisible(true);
		
		for(int i=0;i<11;i++) {
			WordThread wordThread=new WordThread(center, container, i);
			Thread th=new Thread(wordThread);
			th.start();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread myThread=new MyThread();
		myThread.run();
	}

}
