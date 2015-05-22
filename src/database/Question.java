package database;

/**
 * Created by Sean Burright on 5/22/15.
 */
public class Question
{
  private int _id;
  private String _question;
  private String _answer;
  private String _opta;
  private String _optb;
  private String _optc;
  private boolean _isMultipleChoice;

  public Question(int id, String question, String answer, String opta, String optb, String optc)
  {
    _id = id;
    _question = question;
    _answer = answer;
    _opta = opta;
    _optb = optb;
    _optc = optc;
    _isMultipleChoice = true;
  }

  public Question(int id, String question, String answer)
  {
    _id = id;
    _question = question;
    _answer = answer;
    _opta = "";
    _optb = "";
    _optc = "";
    _isMultipleChoice = false;
  }

  public int getID()
  {
    return _id;
  }

  public String getQuestion()
  {
    return _question;
  }

  public String getAnswer()
  {
    return _answer;
  }

  public String getOptA()
  {
    return _opta;
  }

  public String getOptB()
  {
    return _optb;
  }

  public String getOptC()
  {
    return _optc;
  }

  public boolean isMultipleChoice()
  {
    return _isMultipleChoice;
  }
}
