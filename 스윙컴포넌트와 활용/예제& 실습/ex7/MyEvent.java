package Component.ex7;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class MyEvent extends JFrame{
	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		JSlider slider=new JSlider(1,100);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setMinimum(1);
		slider.setMaximum(100);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		
		JLabel j=new JLabel("I Love Java");
		
		c.add(slider,BorderLayout.NORTH);
		
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				JSlider js=(JSlider)e.getSource();
				j.setFont(new Font("Arial",Font.PLAIN,js.getValue()));
			}
		});
		
		c.add(j,BorderLayout.CENTER);
		
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyEvent();
	}

}
