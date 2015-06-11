import database.Database;
import database.Question;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Sean on 5/21/2015.
 */
public class DatabaseTester
{
  public static Scanner scan;
  public static Database database;

  public static void main(String[] args)
  {
    scan = new Scanner(System.in);
    database = new Database();

    boolean quit = false;

    do
    {
      printMenu();
      switch (scan.nextInt())
      {
        case 1:
          printDatabase();
          break;
        case 2:
          addQuestion();
          break;
        case 3:
          askQuestion();
          break;
        case 4:
          System.out.println(database.getRandomQuestion());
          break;
        case 5:
          quit = true;
          break;
      }

    } while (!quit);

    database.closeConnection();
  }

  public static void askQuestion()
  {
    Random random = new Random();

    switch (random.nextInt(2))
    {
      case 1:
        break;
      case 2:
        break;
      case 3:
        break;
    }
  }

  public static void addQuestion()
  {
    String question, answer;
    String[] options = new String[3];
    listDatabases();

    switch (scan.nextInt())
    {
      case 1:
        System.out.print("Enter the question: ");
        question = scan.nextLine();
        System.out.print("Enter the answer: ");
        answer = scan.nextLine();
        System.out.println("Enter three options, each followed by enter: ");
        options[0] = scan.nextLine();
        options[1] = scan.nextLine();
        options[2] = scan.nextLine();
        try
        {
          database.addQuestion(new Question(question, answer, options[0], options[1], options[2]));
        }
        catch (SQLException e)
        {
          System.err.println(e.getClass().getName() + ": " + e.getMessage());
          System.exit(0);
        }
        break;
      case 2:
        System.out.print("Enter the question: ");
        question = scan.nextLine();
        while (true)
        {
          System.out.print("Enter the answer: ");
          answer = scan.nextLine();
          if (answer.equalsIgnoreCase("true") || answer.equalsIgnoreCase("t"))
          {
            answer = "true";
            break;
          }
          if (answer.equalsIgnoreCase("false") || answer.equalsIgnoreCase("f"))
          {
            answer = "false";
            break;
          }
          System.out.println("Enter true or false");
        }
        try
        {
          database.addQuestion(new Question(question, answer));
        }
        catch (SQLException e)
        {
          System.err.println(e.getClass().getName() + ": " + e.getMessage());
          System.exit(0);
        }
        break;
      case 3:
        System.out.print("Enter the question: ");
        question = scan.nextLine();
        System.out.print("Enter the answer");
        answer = scan.nextLine();
        try
        {
          database.addQuestion(new Question(question, answer));
        }
        catch (SQLException e)
        {
          System.err.println(e.getClass().getName() + ": " + e.getMessage());
          System.exit(0);
        }
        break;
    }
  }

  public static void printDatabase()
  {
    String[] all;
    listDatabases();

    switch (scan.nextInt())
    {
      case 1:
        all = database.getAll("multiple_choice");
        for (String string : all)
          System.out.println(string);
        break;
      case 2:
        all = database.getAll("true_false");
        for (String string : all)
          System.out.println(string);
        break;
      case 3:
        all = database.getAll("short_answer");
        for (String string : all)
          System.out.println(string);
        break;
      case 4:
        all = database.getAll();
        for (String string : all)
          System.out.println(string);
        break;
    }
  }

  public static void printMenu()
  {
    System.out.println("***Database Tester***");
    System.out.println("1. Print database");
    System.out.println("2. Add new question");
    System.out.println("3. Answer question");
    System.out.println("4. Get random question");
    System.out.println("5. Quit");
  }

  public static void listDatabases()
  {
    System.out.println("Choose a Database");
    System.out.println("1. Multiple Choice");
    System.out.println("2. True False");
    System.out.println("3. Short Answer");
    System.out.println("4. All Databases");
  }

}
