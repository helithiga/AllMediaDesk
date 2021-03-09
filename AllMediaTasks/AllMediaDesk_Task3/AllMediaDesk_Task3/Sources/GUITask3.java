import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUITask3 implements ActionListener{
	String user_input;
	JFrame frame;
	JPanel panel;
	JTextField user_arg;
	JLabel labelforArg,answerLabel;
	JTextArea textArea;
	
	public GUITask3() {
		frame = new JFrame();
		labelforArg =new JLabel("Enter your argument ");
		user_arg = new JTextField("x");		
		answerLabel = new JLabel("Answer is ");
		
		JLabel newline = new JLabel();
		JButton submit = new JButton("Solve");
		submit.addActionListener(this);
						
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(50,50,20,50));
		panel.setLayout(new GridLayout(4,1));
		panel.add(labelforArg);
		panel.add(user_arg);		
		panel.add(submit);
		panel.add(newline);
		panel.add(answerLabel);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculator");
		frame.setSize(400, 400);
		frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new GUITask3();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String[] data = new String[10];
		String user_input = user_arg.getText();			
		Task3Cal t = new Task3Cal();
		for (int i=0;i<10;i++) {
			String num = Integer.toString(i);
		
			String newstr = user_input.replaceAll("x", num);
			String y = t.BracesCal(newstr);
			
			data[i]= y;				
		}
		double idata[] = new double[10];
		for (int i=0;i<10;i++) {
			idata[i]=Double.parseDouble(data[i]);
			System.out.println(idata[i]);
		}
		
		Task3Graph mygraph = new Task3Graph(idata);
		Task3Graph.createAndShowGui(idata);
	

}

}
