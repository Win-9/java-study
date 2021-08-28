package graphics.ex3;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyEvent extends JFrame{
	private ImageIcon image=new ImageIcon("C:\\Users\\LG\\Desktop\\쇼듕\\아무사진\\han1.jfif");
	private Image img=image.getImage();
	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel jlabel=new JLabel(image);
		jlabel.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				Point p=e.getPoint();
				jlabel.setLocation((int)p.getX(), (int)p.getY());
			}
		});
		jlabel.setSize(200, 200);
		add(jlabel);
		setSize(600,600);
		setVisible(true);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
