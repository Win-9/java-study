package Component;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MyEvent extends JFrame{
	
	private	Vector<String>list=new Vector<String>();
	private JList<String>jlist=new JList<String>(list);
	private JTextField text=new JTextField(20);
	
	MyEvent() {
		setTitle("ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("입력후 enter"));
		c.add(text);
		list.add("가나다라");
		list.add("나");
		jlist.setVisibleRowCount(5);
		jlist.setFixedCellWidth(100);
		c.add(new JScrollPane(jlist));
		
		setSize(300,300);
		setVisible(true);
		
		text.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField t=(JTextField)e.getSource();
				
				list.add(t.getText());
				text.setText("");
				jlist.setListData(list);
			}
		});
	}
	
	public static void main(String[]args) {
		new MyEvent();
	}

}
