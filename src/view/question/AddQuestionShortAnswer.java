package view.question;

import database.Database;
import database.Question;

import javax.swing.*;

/**
 * Created by Sean on 6/10/2015.
 */
public class AddQuestionShortAnswer
{
  private JFrame _frame = new JFrame("Short Answer");
  private JTextField _question = new JTextField();
  private JTextField _answer = new JTextField();
  private Object[] _message = new Object[]{
    "Question:", _question,
    "Answer:", _answer
  };

  public AddQuestionShortAnswer()
  {
    Database database = new Database();
    int option = JOptionPane.showConfirmDialog(_frame, _message, "Enter Question Information", JOptionPane.OK_CANCEL_OPTION);
    if (option == JOptionPane.OK_OPTION)
    {
      try
      {
        database.addQuestion(new Question(_question.getText(), _answer.getText()));
      }
      catch (Exception e)
      {
        JFrame frame = new JFrame("Error");
        JOptionPane.showMessageDialog(frame, e.getClass().getName() + ": " + e.getMessage());
      }
      finally
      {
        database.closeConnection();
      }
    }
  }
}
