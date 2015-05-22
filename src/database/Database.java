package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

/**
 * Created by Sean Burright on 5/20/15.
 */
public class Database
{
  protected String DB_NAME;
  protected static final String TABLE_MULTI = "multiple_choice";
  protected static final String TABLE_TF = "true_false";
  protected static final String TABLE_SHORT = "short_answer";
  protected static final String KEY_ID = "id";
  protected static final String KEY_QUES = "question";
  protected static final String KEY_ANS = "answer";
  protected static final String KEY_OPTA = "opta";
  protected static final String KEY_OPTB = "optb";
  protected static final String KEY_OPTC = "optc";

  protected Connection _connection = null;
  protected int[] _randomQuestionArray;
  protected int _questionIndex = 0;

  public Database(String name)
  {
    DB_NAME = name;
    init();
  }

  private void init()
  {
    try
    {
      Class.forName("org.sqlite.JDBC");
      _connection = DriverManager.getConnection("jdbc:sqlite:questions.db");
      _connection.setAutoCommit(false);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    int size = getSize();
    _randomQuestionArray = new int[size];
    for (int i = 0; i < size; i++)
      _randomQuestionArray[i] = i;
    shuffle();
  }

  public void closeConnection()
  {
    try
    {
      _connection.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  // Fisher–Yates shuffle
  private void shuffle()
  {
    Random random = new Random();
    for (int i = _randomQuestionArray.length - 1; i > 0; i-- )
    {
      int index = random.nextInt(i + 1);
      int num = _randomQuestionArray[index];
      _randomQuestionArray[index] = _randomQuestionArray[i];
      _randomQuestionArray[i] = num;
    }
  }

  public int getSize()
  {
    // find the number of questions by looking at the last question's id
    try (Statement statement = _connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT id FROM "+DB_NAME+" ORDER BY id DESC;"))
    {


      return resultSet.getInt(KEY_ID);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return -1;
  }

  public String[] getQuestions()
  {
    String[] questions = null;
    int i = 0;

    try (Statement statement = _connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT question FROM "+DB_NAME+";"))
    {
      questions = new String[getSize()];

      while (resultSet.next())
      {
        questions[i++] = resultSet.getString(KEY_ANS);
      }

      statement.close();
      resultSet.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return questions;
  }

  public String getQuestion(int id)
  {
    String question = "";
    try(Statement statement = _connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT question FROM " + DB_NAME + " WHERE id = " + id + ";"))
    {
      question = resultSet.getString(KEY_QUES);

      statement.close();
      resultSet.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return question;
  }

  public boolean checkAnswer(String answer, int id)
  {
    String question = getQuestion(id);
    return answer.equalsIgnoreCase(question);
  }

  public Question getRandomQuestion()
  {
    Question question = null;

    if (_questionIndex > _randomQuestionArray.length)
      _questionIndex = 0;

    try (Statement statement = _connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_NAME
      + " WHERE id = " + _randomQuestionArray[_questionIndex] + ";"))
    {
      if (DB_NAME.equals("multiple_choice"))
      {
        question = new Question(_randomQuestionArray[_questionIndex], resultSet.getString(KEY_QUES),
          resultSet.getString(KEY_ANS), resultSet.getString(KEY_OPTA), resultSet.getString(KEY_OPTB),
          resultSet.getString(KEY_OPTC));
      }
      else
      {
        question = new Question(_randomQuestionArray[_questionIndex], resultSet.getString(KEY_QUES),resultSet.getString(KEY_ANS));
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    _questionIndex++;
    return question;
  }

  public String[] getAll()
  {
    String[] questions = null;
    int i = 0;
    try (Statement statement = _connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM "+DB_NAME+";"))
    {
      questions = new String[getSize()];

      if (DB_NAME.equals("multiple_choice"))
      {
        while (resultSet.next())
        {
          String question = resultSet.getString(KEY_QUES);
          String answer = resultSet.getString(KEY_ANS);
          String opta = resultSet.getString(KEY_OPTA);
          String optb = resultSet.getString(KEY_OPTB);
          String optc = resultSet.getString(KEY_OPTC);
          questions[i++] = question + ", " + answer + ", " + opta + ", " + optb + ", " + optc;
        }
      }

      else
      {
        while (resultSet.next())
        {
          String question = resultSet.getString(KEY_QUES);
          String answer = resultSet.getString(KEY_ANS);
          questions[i++] = question+", "+answer;
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return questions;
  }

  // For use only with table multiple_choice
  public void addQuestion(String question, String answer, String[] options)
  {
    if (!DB_NAME.equals("multiple_choice"))
      addQuestion(question,answer);

    else
    {
      try (Statement statement = _connection.createStatement())
      {
        String sql = "INSERT INTO multiple_choice(question, answer, opta, optb, optc) " +
          "VALUES ('" + question + "','" + answer.toLowerCase() + "','" + options[0] + "','" + options[1] + "','" + options[2] + "');";
        statement.execute(sql);
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }

  public void addQuestion(String question, String answer)
  {
    if (DB_NAME.equals("multiple_choice"))
      throw new RuntimeException("incorrect input for table 'multiple_choice'");

    try ( Statement statement = _connection.createStatement())
    {
      String sql = "INSERT INTO "+DB_NAME+"(question,answer) " +
        "VALUES ('"+question+"','"+answer.toLowerCase()+"')";
      statement.execute(sql);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
