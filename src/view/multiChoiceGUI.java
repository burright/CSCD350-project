package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.*;

public class multiChoiceGUI extends makeGUI
{
	
	JFrame frame;
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

  public multiChoiceGUI(Question question)
  {
    this.question = question;
    
    //Database.checkAnswer("",question);
    
    frame = new JFrame();
    frame.setTitle("Trivia");
    frame.setBounds(100, 100, 797, 425);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    

    JTextPane questionTxt = new JTextPane();
    
    //Set question text
    questionTxt.setBackground(SystemColor.menu);
    questionTxt.setText(question.getQuestion());
    questionTxt.setBounds(104, 96, 565, 84);
    frame.getContentPane().add(questionTxt);
    
    //A answer
    JTextPane aTxt = new JTextPane();
    aTxt.setText(question.getOptA());
    aTxt.setBounds(101, 225, 146, 45);
    frame.getContentPane().add(aTxt);
    
    //A button
    JButton btnA = new JButton("A");
    btnA.setForeground(Color.BLACK);
    btnA.setBounds(101, 281, 146, 65);
    frame.getContentPane().add(btnA);
    
    btnA.addActionListener(getAction(question.getOptA()));

    
    //B answer
    JTextPane bTxt = new JTextPane();
    bTxt.setText(question.getOptB());
    bTxt.setBounds(319, 225, 146, 45);
    frame.getContentPane().add(bTxt);
    
    
    //B button
    JButton btnB = new JButton("B");
    btnB.setForeground(Color.BLACK);
    btnB.setBounds(319, 281, 146, 65);
    frame.getContentPane().add(btnB);
    
    btnB.addActionListener(getAction(question.getOptB()));

    //C answer
    JTextPane cTxt = new JTextPane();
    cTxt.setText(question.getOptC());
    cTxt.setBounds(523, 225, 146, 45);
    frame.getContentPane().add(cTxt);
    
    //C button
    JButton btnC = new JButton("C");
    btnC.setForeground(Color.BLACK);
    btnC.setBounds(523, 281, 146, 65);
    frame.getContentPane().add(btnC);
    
    btnC.addActionListener(getAction(question.getOptC()));


  }

public void show() {
	frame.setVisible(true);
	
}
public void hide() {
	frame.setVisible(false);
	
}

//Action Listener Functions


public ActionListener getAction(String text){
	
	if(Database.checkAnswer(text,question)){
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

