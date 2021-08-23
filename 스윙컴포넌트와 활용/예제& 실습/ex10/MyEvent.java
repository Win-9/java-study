package Component.ex10;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyEvent extends JFrame {
	private JLabel[]number=new JLabel[10];
	static private int count=0;
	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		
		c.setLayout(null);
		
		for(int i=0;i<number.length;i++) {
			int x=(int)(Math.random()*255)+1;
			int y=(int)(Math.random()*255)+1;
			
			number[i]=new JLabel(Integer.toString(i));
			number[i].setLocation(x, y);
			number[i].setSize(30,30);
			number[i].setOpaque(true);
			number[i].setForeground(Color.MAGENTA);
			number[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(e.getSource()==number[count]) {
						number[count].setVisible(false);
						int x=(int)(Math.random()*256)+1;
						int y=(int)(Math.random()*256)+1;
						number[count++].setLocation(x, y);
					}
					
					if(count==10) {
						for(int i=0;i<10;i++) {
							number[i].setVisible(true);
						}
						count=0;
					}
				}
			});
			add(number[i]);
		}
		
		setSize(400,400);
		setVisible(true);
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
