package database;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Sean Burright on 5/21/15.
 */
public class DatabaseMultipleChoice extends A_Database
{
  public DatabaseMultipleChoice()
  {
    super("multiple_choice");
  }

  @Override
  public void addQuestion(String question, String answer, String[] options)
  {
    try
    {
      Statement statement = _connection.createStatement();

      String sql = "INSERT INTO multiple_choice(question, answer, opta, optb, optc) "+
        "VALUES ('"+question+"','"+answer.toLowerCase()+"','"+options[0]+"','"+options[1]+"','"+options[2]+"');";
      statement.execute(sql);
      statement.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
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
      ResultSet resultSet = statement.executeQuery("SELECT id FROM multiple_choice ORDER BY id DESC;");
      int size = resultSet.getInt(KEY_ID);
      questions = new String[size];

      resultSet = statement.executeQuery("SELECT * FROM multiple_choice;");

      while(resultSet.next())
      {
        String question = resultSet.getString(KEY_QUES);
        String answer = resultSet.getString(KEY_ANS);
        String opta = resultSet.getString(KEY_OPTA);
        String optb = resultSet.getString(KEY_OPTB);
        String optc = resultSet.getString(KEY_OPTC);
        questions[i++] = question+", "+answer+", "+opta+", "+optb+", "+optc;
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

  @Override
  public void addQuestion(String question, String answer)
  {
    System.err.println("use addQuestion(String,String,String[]");
  }
}
