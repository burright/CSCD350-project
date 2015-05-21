package view;


import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class make_GUI {
	   private static JFrame area = new JFrame("trivia");
	   private static JPanel window = new JPanel();
	   private JButton a = new JButton("");
	   private JButton b = new JButton("");
	   private JButton c = new JButton(""); 
	   private JButton d = new JButton("");
	   private JButton e = new JButton("");
	   private JButton f = new JButton("");
	   private JButton g = new JButton("");
	   private JButton h = new JButton("");
	   private JButton i = new JButton("");
	   private JPanel messages = new JPanel();
	   private JPanel chatIn = new JPanel();
	   private static JTextArea chattext = new JTextArea(3,40);
	   
	   private static JLabel messageArea = new JLabel("");
	 
	   private static String mark; 
		
	   public String player = "";
	   
	   public make_GUI(){
		   area.setSize(800,400);
		      area.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      
		     
		      messages.setLayout(new GridLayout(3,1));
		      window.setLayout(new GridLayout(3,3,2,3));
		      area.setLayout(new GridLayout(1,1));
		      messageArea.setBorder(LineBorder.createBlackLineBorder());
		      messages.add(chattext);
		      messages.add(chatIn);
		   	  messages.add(messageArea);
		   	  messageArea.setHorizontalAlignment(JLabel.CENTER);
		      window.add(a);
		      window.add(b);
		      window.add(c);
		      window.add(d);
		      window.add(e);
		      window.add(f);
		      window.add(g);
		      window.add(h);
		      window.add(i);
		      window.add(messages);
		      //window.add(messageArea, "Center");
		   	
		   	
		   	  
		      area.setVisible(true);
		   	
		   	  //window.add(a.addActionListnener(new ActionListesner(){public void actionPerformed(ActionEvent e){JOptionPane.set()}}))

		      area.add(window);
	   }
}
