import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
		ArrayList<Integer> data = new ArrayList<Integer>();
		String user_input = user_arg.getText();			
		Task1 t = new Task1();
		for (int i=0;i<10;i++) {
			//char num = (char)i;
			String num = Integer.toString(i).trim();
			
			String newstr = user_input.replaceAll("x", num);
			Integer y = Integer.parseInt(t.BracesCal(user_input));
			data.add(y);			
		}
		graph mygraph = new graph();
		
		mygraph.paintComponent(null,data);
		
		
}

}
