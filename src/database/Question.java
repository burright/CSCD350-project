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
  private String _questionType;

  public Question(int id, String question, String answer, String opta, String optb, String optc)
  {
    _id = id;
    _question = parseInput(question);
    _answer = parseInput(answer);
    _opta = parseInput(opta);
    _optb = parseInput(optb);
    _optc = parseInput(optc);
    _questionType = "multiple_choice";
  }

  public Question(String question, String answer, String opta, String optb, String optc)
  {
    _id = -1;
    _question = parseInput(question);
    _answer = parseInput(answer);
    _opta = parseInput(opta);
    _optb = parseInput(optb);
    _optc = parseInput(optc);
    _questionType = "multiple_choice";
  }

  public Question(int id, String question, String answer)
  {
    _id = id;
    _question = parseInput(question);
    _answer = parseInput(answer);
    _opta = "";
    _optb = "";
    _optc = "";
   _questionType = checkType(answer);
  }

  public Question(String question, String answer)
  {
    _id = -1;
    _question = parseInput(question);
    _answer = parseInput(answer);
    _opta = "";
    _optb = "";
    _optc = "";
   _questionType = checkType(answer);
  }

  private String parseInput(String input)
  {
    return input.replaceAll("[^a-zA-Z0-9]+","");
  }

  private String checkType(String string)
  {
    if (string.equalsIgnoreCase("true") || string.equalsIgnoreCase("false") || string.equalsIgnoreCase("t") || string.equalsIgnoreCase("f"))
      return "true_false";
    else
      return "short_answer";
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

  public String getType()
  {
    return _questionType;
  }

  public String toString()
  {
    return _question;
  }
}
