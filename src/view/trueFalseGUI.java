package view;

import javax.swing.*;
import java.awt.*;
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
    //btnNewButton.setIcon(new ImageIcon(new URL("http://simpleicon.com/wp-content/uploads/lock-2.png"));
    btnTrue.setBounds(120, 222, 160, 93);
    frame.getContentPane().add(btnTrue);

    JButton btnFalse = new JButton("False");
    btnFalse.setBounds(400, 222, 160, 93);
    frame.getContentPane().add(btnFalse);

    JTextPane txtpnAtQuoInsolens = new JTextPane();
    txtpnAtQuoInsolens.setBackground(SystemColor.menu);
    txtpnAtQuoInsolens.setText(question.getQuestion());
    txtpnAtQuoInsolens.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 11));
    txtpnAtQuoInsolens.setBounds(120, 83, 440, 80);
    frame.getContentPane().add(txtpnAtQuoInsolens);

  }

  public void show() {
    frame.setVisible(true);

  }
  public void hide() {
    frame.setVisible(false);
  }
}
