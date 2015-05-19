package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class make_GUI {
	   private static JFrame area = new JFrame("Trivia");
	   private static JPanel window = new JPanel();
	   private JButton a = new JButton("");
	   private JPanel messages = new JPanel();
	   private static JLabel messageArea = new JLabel("");
	   
	   public make_GUI(){
		      area.setSize(800,400);
		      area.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      
		      messages.setLayout(new GridLayout(1,1));
		      window.setLayout(new GridLayout(3,3,3,3));
		      area.setLayout(new GridLayout(1,1));
		      
		      messageArea.setBorder(LineBorder.createGrayLineBorder());
		   	  messages.add(messageArea);
		   	  //messageArea.setBackground(Color.BLUE);
		   	  messageArea.setHorizontalAlignment(JLabel.CENTER);
		      window.add(a);
		      
		      area.setVisible(true);
	   }
}
