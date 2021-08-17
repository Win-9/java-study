package Component;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyEvent extends JFrame{
	private JLabel colorLabel;
	private JSlider[]sl=new JSlider[3];
	
	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		colorLabel=new JLabel("			Slider			");
		
		
		for(int i=0;i<sl.length;i++) {
			sl[i]=new JSlider(JSlider.HORIZONTAL,0,255,128);
			sl[i].setPaintLabels(true);
			sl[i].setPaintTicks(true);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			
			sl[i].addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					int r=sl[0].getValue();
					int g=sl[1].getValue();
					int b=sl[2].getValue();
					
					colorLabel.setBackground(new Color(r,g,b));
				}
			});
			c.add(sl[i]);
		}
		
		sl[0].setBackground(Color.RED);
		sl[1].setBackground(Color.GREEN);
		sl[2].setBackground(Color.BLUE);

		int r=sl[0].getValue();
		int g=sl[1].getValue();
		int b=sl[2].getValue();
		colorLabel.setOpaque(true);
		colorLabel.setBackground(new Color(r,g,b));
		
		c.add(colorLabel);
		setSize(500,500);
		setVisible(true);
		
		
	}
	
	public static void main(String[]args) {
		new MyEvent();
	}

}
