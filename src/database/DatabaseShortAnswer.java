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

      // find the number of questions by looking at the last question's id
      ResultSet resultSet = statement.executeQuery("SELECT id FROM short_answer ORDER BY id DESC;");
      int size = resultSet.getInt(KEY_ID);
      questions = new String[size];

      resultSet = statement.executeQuery("SELECT * FROM short_answer;");

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

  }

  @Override
  public void addQuestion(String question, String answer, String[] options)
  {
    addQuestion(question,answer);
  }
}
