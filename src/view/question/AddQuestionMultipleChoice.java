package view.question;

import database.Database;
import database.Question;

import javax.swing.*;

/**
 * Created by Sean on 6/10/2015.
 */
public class AddQuestionMultipleChoice
{
  private JFrame _frame = new JFrame("Multiple Choice");
  private JTextField _question = new JTextField();
  private JTextField _answer = new JTextField();
  private JTextField _opta = new JTextField();
  private JTextField _optb = new JTextField();
  private JTextField _optc = new JTextField();
  private Object[] message = {
    "Question:",_question,
    "Answer:",_answer,
    "Option A:",_opta,
    "Option B:", _optb,
    "Option C:",_optc
  };

  public AddQuestionMultipleChoice()
  {
    Database database = new Database();
    int option = JOptionPane.showConfirmDialog(_frame,message,"Enter question information",JOptionPane.OK_CANCEL_OPTION);
    if (option == JOptionPane.OK_OPTION)
    {
      database.addQuestion(
        new Question(_question.getText(),_answer.getText(),_opta.getText(),_optb.getText(),_optc.getText()));
      database.closeConnection();
    }
  }
}
