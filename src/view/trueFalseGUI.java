package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.*;

public class trueFalseGUI extends makeGUI
{

  private int answer = 0;//0 means not answered, 1 means correct, 2 means incorrect
  private Question question;

  public int getAnswer()
  {
    return this.answer;
  }
  public void setAnswer(int answer)
  {
    this.answer = answer;
  }

  public trueFalseGUI(Question question)
  {
    this.question = question;

    frame = new JFrame();
    frame.setTitle("Trivia");
    frame.setBounds(100, 100, 740, 422);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JButton btnTrue = new JButton("True");
    btnTrue.setBounds(120, 222, 160, 93);
    frame.getContentPane().add(btnTrue);
    
    btnTrue.addActionListener(getAction("true"));


    JButton btnFalse = new JButton("False");
    btnFalse.setBounds(400, 222, 160, 93);
    frame.getContentPane().add(btnFalse);
    
    btnFalse.addActionListener(getAction("false"));

    JTextPane txtpnl = new JTextPane();
    txtpnl.setBackground(SystemColor.menu);
    txtpnl.setText(question.getQuestion());
    txtpnl.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 11));
    txtpnl.setBounds(120, 83, 440, 80);
    frame.getContentPane().add(txtpnl);
    


  }

  public void show() {
    frame.setVisible(true);

  }
  public void hide() {
    frame.setVisible(false);
  }
  
  
  
  //Action listener
  public ActionListener getAction(String text){
		
		if(question.getAnswer().equals(text)){
			return correctAnswer();
		}
		else
			return wrongAnswer();
		
	}



	public ActionListener correctAnswer()
	{
		return new ActionListener(){
			
		public void actionPerformed(ActionEvent arg0) 
		{
			//Display dialog saying correct
			JOptionPane.showMessageDialog(frame,
				    "Correct answer!",
				    "Congrats!",
				    JOptionPane.PLAIN_MESSAGE);
			setAnswer(1);
			
			frame.removeAll();
			frame.dispose();
		}
	};
	}
	
	public ActionListener wrongAnswer()
	{
		return new ActionListener(){
			
		public void actionPerformed(ActionEvent arg0) 
		{
			//Display dialog saying answer was wrong
			JOptionPane.showMessageDialog(frame,
				    "You got the answer wrong!",
				    "Sorry!",
				    JOptionPane.PLAIN_MESSAGE);
			setAnswer(2);
			
			frame.removeAll();
			frame.dispose();
		}
	};
	}
  
  
  
}
