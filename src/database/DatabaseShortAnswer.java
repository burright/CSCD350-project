package database;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Sean Burright on 5/21/15.
 */
public class DatabaseShortAnswer extends A_Database
{
  public DatabaseShortAnswer()
  {
    super("multiple_choice");
  }

  @Override
  public String[] getAll()
  {
    String[] questions = null;
    int i = 0;

    try
    {
      Statement statement = _connection.createStatement();

      questions = new String[getSize()];

      ResultSet resultSet = statement.executeQuery("SELECT * FROM short_answer;");

      while (resultSet.next())
      {
        String question = resultSet.getString(KEY_QUES);
        String answer = resultSet.getString(KEY_ANS);
        questions[i++] = question+", "+answer;
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return questions;
  }

  @Override
  public void addQuestion(String question, String answer)
  {
    try
    {
      Statement statement = _connection.createStatement();

      String sql = "INSERT INTO short_answer(question,answer) " +
        "VALUES ('"+question+"','"+answer.toLowerCase()+"')";
      statement.execute(sql);
      statement.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public void addQuestion(String question, String answer, String[] options)
  {
    addQuestion(question,answer);
  }
}
