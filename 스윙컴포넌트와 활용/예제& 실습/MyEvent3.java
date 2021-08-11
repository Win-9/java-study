package Component;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyEvent extends JFrame{
	
	private JCheckBox[]fruits=new JCheckBox[3];
	private String[]names= {"1","2","3"};
	
	private JLabel sumLabel;
	
	public MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("1000 2000 3000"));
		 
		MyItemListener listener=new MyItemListener();
		for(int i=0;i<fruits.length;i++) {
			fruits[i]=new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			c.add(fruits[i]);
			fruits[i].addItemListener(listener);
		}
		
		sumLabel=new JLabel("sum:0");
		c.add(sumLabel);
		setSize(250,200);
		setVisible(true);
		
	}
	
	class MyItemListener implements ItemListener{
		private int sum=0;

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getStateChange()==ItemEvent.SELECTED) {
				if(e.getItem()==fruits[0])
					sum+=1000;
				else if(e.getItem()==fruits[1])
					sum+=2000;
				else
					sum+=3000;
			}
			else {
				if(e.getItem()==fruits[0])
					sum-=1000;
				else if(e.getItem()==fruits[1])
					sum-=2000;
				else
					sum-=3000;
			}
			
			sumLabel.setText("sum:"+sum);
		}
		
	}
	
	public static void main(String[]args) {
		new MyEvent();
	}

}
