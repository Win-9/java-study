package Component.ex5;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyEvent extends JFrame{
	private JSlider slider;
	private JLabel jlabel=new JLabel(); 

	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		slider=new JSlider(0,200,100);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setPaintTrack(true);
		slider.setPaintTicks(true);

		jlabel.setBackground(Color.GREEN);
		
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				jlabel.setText(Integer.toString(slider.getValue()));
			}
		});
		jlabel.setOpaque(true);
		c.add(slider);
		c.add(jlabel);
		
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
