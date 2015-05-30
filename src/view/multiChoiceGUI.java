package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class multiChoiceGUI extends makeGUI {
	public multiChoiceGUI(){
		
			
			frame = new JFrame();
			frame.setTitle("Trivia");
			frame.setBounds(100, 100, 740, 422);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JButton btnA = new JButton("A");
			btnA.setForeground(Color.BLACK);
			btnA.setBounds(101, 281, 146, 65);
			frame.getContentPane().add(btnA);
			
			JTextPane txtpnThisIsWhere = new JTextPane();
			txtpnThisIsWhere.setText("This is where a long question would go that comes in as a string from data base. It also should continue "
					+ "to the next line. Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah "
					+ "Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah");
			txtpnThisIsWhere.setBounds(101, 46, 565, 118);
			frame.getContentPane().add(txtpnThisIsWhere);
			
			JTextPane txtpnAnswerAWill = new JTextPane();
			txtpnAnswerAWill.setText("Answer A will go here");
			txtpnAnswerAWill.setBounds(101, 225, 146, 45);
			frame.getContentPane().add(txtpnAnswerAWill);
			
			JTextPane txtpnAnswerBWill = new JTextPane();
			txtpnAnswerBWill.setText("Answer B will go here");
			txtpnAnswerBWill.setBounds(319, 225, 146, 45);
			frame.getContentPane().add(txtpnAnswerBWill);
			
			JButton btnB = new JButton("B");
			btnB.setForeground(Color.BLACK);
			btnB.setBounds(319, 281, 146, 65);
			frame.getContentPane().add(btnB);
			
			JTextPane txtpnAnswerBWill_1 = new JTextPane();
			txtpnAnswerBWill_1.setText("Answer B will go here");
			txtpnAnswerBWill_1.setBounds(523, 225, 146, 45);
			frame.getContentPane().add(txtpnAnswerBWill_1);
			
			JButton btnC = new JButton("C");
			btnC.setForeground(Color.BLACK);
			btnC.setBounds(523, 281, 146, 65);
			frame.getContentPane().add(btnC);
		
		
	}
}
