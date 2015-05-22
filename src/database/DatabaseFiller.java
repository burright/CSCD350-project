package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Sean on 5/22/2015.
 */
public class DatabaseFiller
{
  public static void main(String[] args)
  {
    Connection connection;

    try
    {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection("jdbc:sqlite:questions.db");
      connection.setAutoCommit(false);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    System.out.println("Database will store multiple choice, short answer (one word), true/false");
    System.out.println("Input format (question,answer) or (question,answer,opta,optb,optc");
  }
}
