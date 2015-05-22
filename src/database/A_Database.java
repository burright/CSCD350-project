package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Sean Burright on 5/20/15.
 */
public abstract class A_Database
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

  public A_Database(String name)
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

  public String[] getQuestions()
  {
    String[] questions = null;
    int i = 0;

    try
    {
      Statement statement = _connection.createStatement();

      // find the number of questions by looking at the last question's id
      ResultSet resultSet = statement.executeQuery("SELECT id FROM "+DB_NAME+" ORDER BY id DESC;");
      int size = resultSet.getInt(KEY_ID);
      questions = new String[size];

      resultSet = statement.executeQuery("SELECT question FROM "+DB_NAME+";");

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
    try
    {
      Statement statement = _connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT question FROM "+DB_NAME+" WHERE id = "+id+";");
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

  public abstract String[] getAll();
  public abstract void addQuestion(String question, String answer, String[] options);
  public abstract void addQuestion(String question, String answer);

}
