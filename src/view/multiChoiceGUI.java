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

    frame = new JFrame();
    frame.setTitle("Trivia");
    frame.setBounds(100, 100, 797, 425);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JButton btnA = new JButton("A");
    btnA.setForeground(Color.BLACK);
    btnA.setBounds(101, 281, 146, 65);
    frame.getContentPane().add(btnA);

    JTextPane questionTxt = new JTextPane();
    questionTxt.setBackground(SystemColor.menu);
    questionTxt.setText(question.getQuestion());
    questionTxt.setBounds(104, 96, 565, 84);
    frame.getContentPane().add(questionTxt);

    JTextPane aTxt = new JTextPane();
    aTxt.setText(question.getOptA());
    aTxt.setBounds(101, 225, 146, 45);
    frame.getContentPane().add(aTxt);

    JTextPane bTxt = new JTextPane();
    bTxt.setText(question.getOptB());
    bTxt.setBounds(319, 225, 146, 45);
    frame.getContentPane().add(bTxt);

    JButton btnB = new JButton("B");
    btnB.setForeground(Color.BLACK);
    btnB.setBounds(319, 281, 146, 65);
    frame.getContentPane().add(btnB);

    JTextPane cTxt = new JTextPane();
    cTxt.setText(question.getOptC());
    cTxt.setBounds(523, 225, 146, 45);
    frame.getContentPane().add(cTxt);

    JButton btnC = new JButton("C");
    btnC.setForeground(Color.BLACK);
    btnC.setBounds(523, 281, 146, 65);
    frame.getContentPane().add(btnC);


  }

public void show() {
	frame.setVisible(true);
	
}
public void hide() {
	frame.setVisible(false);
	
}
}

