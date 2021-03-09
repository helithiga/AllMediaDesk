
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI_Task2 implements ActionListener{
	String input;
	JFrame frame;
	JPanel panel;
	JTextField wordInput;
	JLabel label,answerLabel;
	public GUI_Task2() {
		frame = new JFrame();
		label =new JLabel("Enter the Number");
		wordInput = new JTextField(10);
		answerLabel = new JLabel("Answer is ");
		JButton submit = new JButton("Submit the Number");
		submit.addActionListener(this);
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(50,50,20,50));
		panel.setLayout(new GridLayout());
		panel.add(label);
		panel.add(wordInput);
		panel.add(submit);
		panel.add(answerLabel);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("My Task 2 GUI");
		frame.pack();
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI_Task2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		input = wordInput.getText();		
		int inputNum = Integer.parseInt(input);
		Task2 t = new Task2();
		int ans = t.getHelithi(inputNum, 0, 0, 0);
		answerLabel.setText("The answer is "+ans);
		
	}
}
