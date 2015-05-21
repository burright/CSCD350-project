package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Sean Burright on 5/20/15.
 */
public abstract class A_Database
{
  private Connection _connection = null;

  public A_Database()
  {
    init();
  }

  private void init()
  {
    try
    {
      Class.forName("org.sqlite.JDBC");
      _connection = DriverManager.getConnection("jdbc:sqlite:database.db");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public abstract void addQuestion(String question, String answer);
  public abstract String getQuestion();
}
