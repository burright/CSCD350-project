package view;

import javax.swing.*;
import java.awt.*;

public class multiChoiceGUI //extends makeGUI
{

  JFrame frame;

  public multiChoiceGUI(String question, String a, String b, String c)
  {

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
    questionTxt.setText("This is where a long question would go that comes in as a string from data base. It also should continue to the next line. Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah");
    questionTxt.setBounds(104, 96, 565, 84);
    frame.getContentPane().add(questionTxt);

    JTextPane aTxt = new JTextPane();
    aTxt.setText("Answer A will go here");
    aTxt.setBounds(101, 225, 146, 45);
    frame.getContentPane().add(aTxt);

    JTextPane bTxt = new JTextPane();
    bTxt.setText("Answer B will go here");
    bTxt.setBounds(319, 225, 146, 45);
    frame.getContentPane().add(bTxt);

    JButton btnB = new JButton("B");
    btnB.setForeground(Color.BLACK);
    btnB.setBounds(319, 281, 146, 65);
    frame.getContentPane().add(btnB);

    JTextPane cTxt = new JTextPane();
    cTxt.setText("Answer C will go here");
    cTxt.setBounds(523, 225, 146, 45);
    frame.getContentPane().add(cTxt);

    JButton btnC = new JButton("C");
    btnC.setForeground(Color.BLACK);
    btnC.setBounds(523, 281, 146, 65);
    frame.getContentPane().add(btnC);


  }

  public void show()
  {
    frame.setVisible(true);

  }

  public void hide()
  {
    frame.setVisible(false);

  }
}

