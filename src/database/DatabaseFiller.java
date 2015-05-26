package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by Sean on 5/22/2015.
 */
public class DatabaseFiller
{
  private static Connection connection;

  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);

    try
    {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection("jdbc:sqlite:database/questions.db");
      connection.setAutoCommit(false);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    System.out.println("Database will store multiple choice, short answer (one word), true/false");
    System.out.println("Input format (question,answer) or (question,answer,opta,optb,optc)/n");
    System.out.print("How many questions will you enter?: ");
    int size = scan.nextInt();
    scan.nextLine();
    for (int i = 0; i < size; i++)
    {
      parseInput(scan.nextLine());
    }
    try
    {
      connection.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public static void parseInput(String input)
  {
    input = input.replace("'","");
    String[] words = input.split(",");
    String sql;
    if (words.length == 2)
    {
      try (Statement statement = connection.createStatement())
      {
        if (words[1].equalsIgnoreCase("true") || words[1].equalsIgnoreCase("false")
          || words[1].equalsIgnoreCase("t") || words[1].equalsIgnoreCase("f"))
        {
          sql = "INSERT INTO true_false(question,answer) " +
            "VALUES ('" + words[0] + "','" + words[1].toLowerCase() + "')";
        }
        else
          sql = "INSERT INTO short_answer(question,answer) " +
            "VALUES ('" + words[0] + "','" + words[1].toLowerCase() + "')";

        statement.executeUpdate(sql);
        connection.commit();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else if (words.length == 5)
    {
      try (Statement statement = connection.createStatement())
      {
        sql = "INSERT INTO multiple_choice(question, answer, opta, optb, optc) " +
          "VALUES ('" + words[0] + "','" + words[1].toLowerCase() + "','" + words[2] +
          "','" + words[3] + "','" + words[4] + "');";
        statement.executeUpdate(sql);
        connection.commit();
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
      System.err.println("String: '" + input + "' has format errors and was not added.");
  }
}
