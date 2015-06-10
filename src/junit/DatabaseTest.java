package junit;

import database.Database;
import database.Question;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sean on 5/26/15.
 */
public class DatabaseTest
{
  public Database database;

  @Before
  public void setUp() throws Exception
  {
    database = new Database();
  }

  @After
  public void tearDown() throws Exception
  {
    database.closeConnection();
  }

  @Test
  public void testGetSize()
  {
    System.out.println(database.getSize("true_false"));
    System.out.println(database.getSize("short_answer"));
    System.out.println(database.getSize("multiple_choice"));
  }

  @Test
  public void testGetAllSize() throws Exception
  {
    System.out.println(database.getAllSize());
  }

  @Test
  public void testGetQuestions() throws Exception
  {
    String[] trueFalse = database.getQuestions("true_false");
    String[] multipleChoice = database.getQuestions("multiple_choice");
    String[] shortAnswer = database.getQuestions("short_answer");

    for (String string : trueFalse)
      System.out.println(string);
    for (String string : multipleChoice)
      System.out.println(string);
    for (String string : shortAnswer)
      System.out.println(string);
  }

  @Test
  public void testCheckAnswer() throws Exception
  {
    database.checkAnswer("cisco", database.getQuestionMultipleChoice(1));
  }

  @Test
  public void testGetRandomQuestion() throws Exception
  {
    Question question1 = database.getRandomQuestion();
    Question question2 = database.getRandomQuestion();
    Question question3 = database.getRandomQuestion();
    Question question4 = database.getRandomQuestion();

    System.out.println(question1 + "\n" + question2 + "\n" + question3 + "\n" + question4);
  }

  @Test
  public void testGetAll() throws Exception
  {
    String[] all = database.getAll();
    for (String string : all)
      System.out.println(string);
  }

  @Test
  public void testGetAll1() throws Exception
  {

  }

  @Test
  public void testAddQuestion() throws Exception
  {

  }
}