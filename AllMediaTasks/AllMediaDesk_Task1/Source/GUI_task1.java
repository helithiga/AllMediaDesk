import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI_task1 implements ActionListener{
	String user_input;
	JFrame frame;
	JPanel panel;
	JTextField user_arg;
	JLabel labelforArg,answerLabel;
	JTextArea textArea;
	
	public GUI_task1() {
		frame = new JFrame();
		labelforArg =new JLabel("Enter your argument ");
		user_arg = new JTextField();		
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
		new GUI_task1();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String user_input = user_arg.getText();
			
		Task1 t = new Task1();
		String answer = t.BracesCal(user_input);
		answerLabel.setText("The answer is "+ answer);
	}

}
