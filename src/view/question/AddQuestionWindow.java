package view.question;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sean on 6/10/2015.
 */
public class AddQuestionWindow
{
  JFrame _frame = new JFrame("Choose Question Type");
  JButton _trueFalse = new JButton("True/False");
  JButton _multipleChoice = new JButton("Multiple Choice");
  JButton _shortAnswer = new JButton("Short Answer");

  public AddQuestionWindow()
  {
    _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    _trueFalse.addActionListener(e -> new AddQuestionTrueFalse());

    _multipleChoice.addActionListener(e -> new AddQuestionMultipleChoice());

    _shortAnswer.addActionListener(e -> new AddQuestionShortAnswer());

  }

  public void questionWindow()
  {
    SwingUtilities.invokeLater(() -> {
      _frame.getContentPane().setLayout(new GridLayout(1,3));
      _frame.add(_trueFalse);
      _frame.add(_multipleChoice);
      _frame.add(_shortAnswer);
      _frame.pack();
      _frame.setLocationRelativeTo(null);
      _frame.setVisible(true);
    });
  }

  public static void main(String[] args)
  {
    AddQuestionWindow addQuestionWindow = new AddQuestionWindow();
    addQuestionWindow.questionWindow();
  }
}
