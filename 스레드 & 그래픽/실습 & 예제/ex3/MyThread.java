package thread.ex3;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyThread extends JFrame{
	
	public MyThread() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel label=new JLabel();
		label.setFont(new Font("Gothic",Font.ITALIC,80));
		
		c.add(label);
		
		setSize(500,500);
		setVisible(true);
		
		Start st=new Start(label);
		st.start();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyThread();
	}

}


class Start extends Thread{
	private JLabel jlabel;
	public Start(JLabel jlabel) {
		this.jlabel=jlabel;
	}
	
	public void run() {
		while(true) {
			Calendar c=Calendar.getInstance();

			int hour=c.get(Calendar.HOUR_OF_DAY);
			int min=c.get(Calendar.MINUTE);
			int second=c.get(Calendar.SECOND);
			
			String clockText=Integer.toString(hour);
			clockText=clockText.concat(":");
			clockText=clockText.concat(Integer.toString(min));
			clockText=clockText.concat(":");
			clockText=clockText.concat(Integer.toString(second));
			jlabel.setText(clockText);
		}
		
	}
}
