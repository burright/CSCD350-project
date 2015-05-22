import database.DatabaseMultipleChoice;
import database.DatabaseShortAnswer;
import database.DatabaseTrueFalse;

import java.util.Scanner;

/**
 * Created by Sean on 5/21/2015.
 */
public class DatabaseTester
{
  public static Scanner scan;
  public static DatabaseMultipleChoice multipleChoice;
  public static DatabaseShortAnswer shortAnswer;
  public static DatabaseTrueFalse trueFalse;

  public static void main(String[] args)
  {
    scan = new Scanner(System.in);
    multipleChoice = new DatabaseMultipleChoice();
    shortAnswer = new DatabaseShortAnswer();
    trueFalse = new DatabaseTrueFalse();
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
          break;
        case 4:
          break;
        case 5:
          quit = true;
          break;
      }

    }while (!quit);
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
        multipleChoice.addQuestion(question,answer,options);
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
        trueFalse.addQuestion(question,answer);
        break;
      case 3:
        System.out.print("Enter the question: ");
        question = scan.nextLine();
        System.out.print("Enter the answer");
        answer = scan.nextLine();

        shortAnswer.addQuestion(question,answer);
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
        all = multipleChoice.getAll();
        for (String string: all)
          System.out.println(string);
        break;
      case 2:
        all = trueFalse.getAll();
        for (String string: all)
          System.out.println(string);
        break;
      case 3:
        all = shortAnswer.getAll();
        for (String string: all)
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
    System.out.println("4. Retrieve question using ID");
    System.out.println("5. Quit");
  }

  public static void listDatabases()
  {
    System.out.println("Choose a Database");
    System.out.println("1. Multiple Choice");
    System.out.println("2. True False");
    System.out.println("3. Short Answer");
  }

}
