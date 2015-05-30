package view;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class trueFalseGUI extends makeGUI{
	public trueFalseGUI(){
		
			frame = new JFrame();
			frame.setTitle("Trivia");
			frame.setBounds(100, 100, 740, 422);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JButton btnTrue = new JButton("True");
			//btnNewButton.setIcon(new ImageIcon(new URL("http://simpleicon.com/wp-content/uploads/lock-2.png"));
			btnTrue.setBounds(120, 222, 160, 93);
			frame.getContentPane().add(btnTrue);
			
			JButton btnFalse = new JButton("False");
			btnFalse.setBounds(400, 222, 160, 93);
			frame.getContentPane().add(btnFalse);
			
			JTextPane txtpnAtQuoInsolens = new JTextPane();
			txtpnAtQuoInsolens.setBackground(SystemColor.menu);
			txtpnAtQuoInsolens.setText("At quo insolens intellegat. Veritus evertitur scripserit ex eos. In magna dolor regione nam. Eirmod oblique repudiandae ea est, in quo postea percipitur. Sea labores temporibus dissentiet et, ex has unum primis prodesset.");
			txtpnAtQuoInsolens.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 11));
			txtpnAtQuoInsolens.setBounds(120, 83, 440, 80);
			frame.getContentPane().add(txtpnAtQuoInsolens);
		
	}
}
