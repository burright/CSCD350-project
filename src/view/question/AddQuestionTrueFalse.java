package view.question;

import database.Database;
import database.Question;

import javax.swing.*;

/**
 * Created by Sean on 6/10/2015.
 */
public class AddQuestionTrueFalse
{
  private JFrame _frame = new JFrame("True False");
  private JTextField _question = new JTextField();
  private JRadioButton _true = new JRadioButton();
  private JRadioButton _false = new JRadioButton();
  private ButtonGroup _buttons = new ButtonGroup();
  private Object[] _message = new Object[]{
    "Question:", _question,
    "True", _true,
    "False", _false
  };

  public AddQuestionTrueFalse()
  {
    Database database = new Database();
    _buttons.add(_true);
    _buttons.add(_false);
    int option = JOptionPane.showConfirmDialog(_frame, _message, "Enter Question Information", JOptionPane.OK_CANCEL_OPTION);
    if (option == JOptionPane.OK_OPTION)
    {
      try
      {
        database.addQuestion(new Question(_question.getText(), (_true.isSelected() ? "true" : "false")));
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
