package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class make_GUI2 extends Frame implements ActionListener 
{
	   private static JFrame area = new JFrame("Trivia");
	   private static JPanel window = new JPanel();
	   private JButton a = new JButton("");
	   private JButton b = new JButton("");
	   private JButton c = new JButton(""); 
	   public Label mess = new Label("this is where a really long question a cra zy fod amdlkjd adslkjdfsslk;jad f;lkjasdflk ;will be that takes up a lot of space");

	   private JPanel messages = new JPanel();
	   private JPanel chatIn = new JPanel();
	   private static JTextArea chattext = new JTextArea(3,40);
	   
	   private static JLabel messageArea = new JLabel("");
	   
	   private static String mark; 
		
	   public String player = "";
	   
	   public make_GUI()
	   {
		     /*
		      area.setSize(800,400);
		      area.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      area.add(mess);
		      messages.setLayout(new GridLayout(3,1));
		      window.setLayout(new GridLayout(2,1));
		      area.setLayout(new GridLayout(2,1));
		      window.add(a);
		      window.add(b);
		      window.add(c);
		     
		      window.add(mess);
		      messages.setLayout(new GridLayout(3,1));
		      window.setLayout(new GridLayout(1,1));
		      area.setLayout(new GridLayout(1,1));
		      messageArea.setBorder(LineBorder.createBlackLineBorder());
		      messages.add(chattext);
		      messages.add(chatIn);
		   	  messages.add(messageArea);
		   	  messageArea.setHorizontalAlignment(JLabel.CENTER);
		      window.add(a);
		      window.add(b);
		      window.add(c);
		      
		      window.add(messages);
		      //window.add(messageArea, "Center");
		   	
		   	 */
		   	  
		      area.setVisible(true);
		   	
		   	  //window.add(a.addActionListnener(new ActionListesner(){public void actionPerformed(ActionEvent e){JOptionPane.set()}}))

		      area.add(window);
	   }
	   
	   
	   public void resetGUI()
	   {
		   area.remove(this.window);
		   area.remove(this.area);
	  
	   
	   }
	   
	   public void setGUI(){
		   area.setSize(800,400);
		   area.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   }
	   
	   
	   public void makeMulChoiceGUI(String question,String a, String b, String c)
	   {
		   
		      area.setSize(800,400);
		      area.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      area.add(mess);
		      //messages.setLayout(new GridLayout(3,1));
		      window.setLayout(new GridLayout(2,1));
		      area.setLayout(new GridLayout(2,1));
		      window.add(this.a);
		      window.add(this.b);
		      window.add(this.c);
		      
		      this.a.setText(a);
		      this.b.setText(b);
		      this.c.setText(c);
		      this.mess.setText(question);
		      area.setVisible(true);
		      area.add(window);
	   }
	   
	   public void makeShortAnswerGui(String question)
	   {
		   hidebutton();
		   
		   messageArea.setText(question);
		   chattext.show();
	   }
	   
	   public void makeTrueFalseGui(String question)
	   {
		   this.a.setText("True");
		   this.b.setText("False");
		   this.c.hide();
		   messageArea.setText(question);
	   }
	   
	   private void hidebutton() 
	   {
		this.a.hide();
		this.b.hide();
		this.c.hide();
	   }
	   
	   private void showButton(){
		   
		   this.a.show();
		   this.b.show();
		   this.c.show();
	   }



	
	   
	   public void displayDoors() throws IOException
	   {
		   String path = "door.jpg";
		   InputStream imgStream = make_GUI.class.getResourceAsStream(path);
		   BufferedImage myImg = ImageIO.read(imgStream);
		   this.a.setIcon((Icon) myImg);
		   
	   }



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}