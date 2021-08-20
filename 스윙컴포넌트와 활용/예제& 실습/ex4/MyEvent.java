package Component.ex4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyEvent extends JFrame{
	private String []jlabel= {"오만원","만원","천원","500원","100원","50원","10원","1원"};
	private JTextField []jtext=new JTextField[8];
	
	private JTextField text=new JTextField(8);
	private JButton button=new JButton("계산");
	private int[]div= {50000,10000,1000,500,100,50,10,1};
	
	private JCheckBox[] check=new JCheckBox[7];
	
	public MyEvent() {
		// TODO Auto-generated constructor stub
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel North=new JPanel();
		JLabel label=new JLabel("금액");
		North.setLayout(new FlowLayout());
		North.setBackground(Color.PINK);
		North.add(label);
		North.add(text);
		North.add(button);
		
		JPanel Center=new JPanel();
		Center.setLayout(new GridLayout(8,3));
		Center.setBackground(Color.PINK);
		JLabel Centerlabel;
		for(int i=0;i<jlabel.length-1;i++) {
			Centerlabel=new JLabel(jlabel[i]);
			Center.add(Centerlabel);
			jtext[i]=new JTextField(5);
			Center.add(jtext[i]);
			check[i]=new JCheckBox();
			check[i].setBackground(Color.PINK);
			Center.add(check[i]);
		}
		jtext[7]=new JTextField(5);
		Center.add(new JLabel(jlabel[7]));
		Center.add(jtext[7]);
		

		
		button.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int value=Integer.parseInt(text.getText());
				for(int i=0;i<7;i++) {
					if(!check[i].isSelected()) {
						jtext[i].setText("");
						continue;
					}
					jtext[i].setText(Integer.toString(value/div[i]));
					value=value%div[i];
				}
				jtext[7].setText(Integer.toString(value/div[7]));
			}
	
		});
		
		
		c.add(North,BorderLayout.NORTH);
		c.add(Center,BorderLayout.CENTER);

		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[]args) {
		new MyEvent();
	}

}
