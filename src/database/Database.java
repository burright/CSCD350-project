package database;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Random;

/**
 * Created by Sean Burright on 5/20/15.
 */
public class Database
{
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
  protected int[] _randomMultipleChoiceArray;
  protected int[] _randomTrueFalseArray;
  protected int[] _randomShortAnswerArray;
  protected int _multipleChoiceIndex = 0;
  protected int _trueFalseIndex = 0;
  protected int _shortAnswerIndex = 0;

  public Database()
  {
    init();
  }

  private void init()
  {
    try
    {
      Class.forName("org.sqlite.JDBC");
      _connection = DriverManager.getConnection("jdbc:sqlite:database/questions.db");
      _connection.setAutoCommit(false);
    }
    catch (ClassNotFoundException e)
    {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    catch (SQLException e)
    {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }

    int size = getSize(TABLE_MULTI);
    _randomMultipleChoiceArray = new int[size];
    for (int i = 0; i < size; i++)
      _randomMultipleChoiceArray[i] = i+1;
    shuffle(TABLE_MULTI);

    size = getSize(TABLE_TF);
    _randomTrueFalseArray = new int[size];
    for (int i = 0; i < size; i++)
      _randomTrueFalseArray[i] = i+1;
    shuffle(TABLE_TF);

    size = getSize(TABLE_SHORT);
    _randomShortAnswerArray = new int[size];
    for (int i = 0; i < size; i++)
      _randomShortAnswerArray[i] = i+1;
    shuffle(TABLE_SHORT);
  }

  public void closeConnection()
  {
    try
    {
      _connection.close();
    }
    catch (SQLException e)
    {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
  }

  // Fisher-Yates shuffle
  private void shuffle(String database)
  {
    Random random = new Random();
    switch (database)
    {
      case "multiple_choice":
      {
        for (int i = _randomMultipleChoiceArray.length - 1; i > 0; i--)
        {
          int index = random.nextInt(i + 1);
          int num = _randomMultipleChoiceArray[index];
          _randomMultipleChoiceArray[index] = _randomMultipleChoiceArray[i];
          _randomMultipleChoiceArray[i] = num;
        }
        _multipleChoiceIndex = 0;
        break;
      }
      case "true_false":
      {
        for (int i = _randomTrueFalseArray.length - 1; i > 0; i--)
        {
          int index = random.nextInt(i + 1);
          int num = _randomTrueFalseArray[index];
          _randomTrueFalseArray[index] = _randomTrueFalseArray[i];
          _randomTrueFalseArray[i] = num;
        }
        _trueFalseIndex = 0;
        break;
      }
      case "short_answer":
      {
        for (int i = _randomShortAnswerArray.length - 1; i > 0; i--)
        {
          int index = random.nextInt(i + 1);
          int num = _randomShortAnswerArray[index];
          _randomShortAnswerArray[index] = _randomShortAnswerArray[i];
          _randomShortAnswerArray[i] = num;
        }
        _shortAnswerIndex = 0;
        break;
      }
      default:
        throw new InputMismatchException(database + ": invalid database");
    }
  }

  // returns the total number of questions in the database
  public int getSize(String database)
  {
    // find the number of questions by looking at the last question's id
    try (Statement statement = _connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT id FROM " + database + " ORDER BY id DESC;"))
    {
      return resultSet.getInt(KEY_ID);
    }
    catch (SQLException e)
    {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    return -1;
  }

  public int getAllSize()
  {
    return getSize(TABLE_MULTI) + getSize(TABLE_TF) + getSize(TABLE_SHORT);
  }

  // returns all questions as a string from all tables
  public String[] getQuestions(String database)
  {
    String[] questions = null;
    int i = 0;

    try (Statement statement = _connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT question FROM " + database + ";"))
    {
      questions = new String[getSize(database)];

      while (resultSet.next())
      {
        questions[i++] = resultSet.getString(KEY_QUES);
      }

      statement.close();
      resultSet.close();
    }
    catch (SQLException e)
    {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    return questions;
  }

  // checks an answer with the question object
  public boolean checkAnswer(String answer, Question question)
  {
    return answer.equalsIgnoreCase(question.getQuestion());
  }

  // returns a specific question
  public Question getQuestionTrueFalse(int id)
  {
    Question question = null;
    try (Statement statement = _connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM true_false WHERE id = "
                 + id + ";"))
    {
      question = new Question(id,
              resultSet.getString(KEY_QUES), resultSet.getString(KEY_ANS));
    }
    catch (SQLException e)
    {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      e.printStackTrace();
      System.exit(0);
    }

    return question;
  }

  public Question getQuestionMultipleChoice(int id)
  {
    Question question = null;

    try (Statement statement = _connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM multiple_choice WHERE id = "
                 + id + ";"))
    {
      question = new Question(id, resultSet.getString(KEY_QUES),
              resultSet.getString(KEY_ANS), resultSet.getString(KEY_OPTA), resultSet.getString(KEY_OPTB),
              resultSet.getString(KEY_OPTC));
    }
    catch (SQLException e)
    {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      e.printStackTrace();
      System.exit(0);
    }

    return question;
  }

  public Question getQuestionShortAnswer(int id)
  {
    Question question = null;
    try (Statement statement = _connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM short_answer WHERE id = "
                 + id + ";"))
    {
      question = new Question(id,
              resultSet.getString(KEY_QUES), resultSet.getString(KEY_ANS));
    }
    catch (SQLException e)
    {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      e.printStackTrace();
      System.exit(0);
    }

    return question;
  }

  // returns a random question
  public Question getRandomQuestion()
  {
    Random random = new Random();
    int randomInt;
    String database;

    randomInt = random.nextInt(3);
    switch (randomInt)
    {
      case 0:
      {
        database = TABLE_MULTI;
        if (_multipleChoiceIndex >= _randomMultipleChoiceArray.length)
        {
          shuffle(database);
          _multipleChoiceIndex = 0;
        }
        return getQuestionMultipleChoice(_randomMultipleChoiceArray[_multipleChoiceIndex++]);
      }
      case 1:
      {
        database = TABLE_TF;
        if (_trueFalseIndex >= _randomTrueFalseArray.length)
        {
          shuffle(database);
          _trueFalseIndex = 0;
        }
        return getQuestionTrueFalse(_randomTrueFalseArray[_trueFalseIndex++]);
      }
      case 2:
      {
        database = TABLE_SHORT;
        if (_shortAnswerIndex >= _randomShortAnswerArray.length)
        {
          shuffle(database);
          _shortAnswerIndex = 0;
        }
        return getQuestionShortAnswer(_randomShortAnswerArray[_shortAnswerIndex++]);
      }
      default:
        throw new RuntimeException("Number " + randomInt + " was generated");
    }
  }

  // returns all data from all tables as a string

  public String[] getAll()
  {
    int j = 0;
    String[] questions = new String[getAllSize()];
    String[] trueFalse = getAll(TABLE_TF);
    String[] multipleChoice = getAll(TABLE_MULTI);
    String[] shortAnswer = getAll(TABLE_SHORT);

    for (int i = 0; i < trueFalse.length; i++)
    {
      questions[j++] = trueFalse[i];
    }

    for (int i = 0; i < multipleChoice.length; i++)
    {
      questions[j++] = multipleChoice[i];
    }

    for (int i = 0; i < shortAnswer.length; i++)
    {
      questions[j++] = shortAnswer[i];
    }

    return questions;
  }

  public String[] getAll(String database)
  {
    String[] questions = null;
    int i = 0;
    try (Statement statement = _connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM " + database + ";"))
    {
      questions = new String[getSize(database)];

      if (database.equals(TABLE_MULTI))
      {
        while (resultSet.next())
        {
          String question = resultSet.getString(KEY_QUES);
          String answer = resultSet.getString(KEY_ANS);
          String opta = resultSet.getString(KEY_OPTA);
          String optb = resultSet.getString(KEY_OPTB);
          String optc = resultSet.getString(KEY_OPTC);
          questions[i++] = question + ", " + answer + ", " + opta + ", " + optb + ", " + optc;
        }
      }
      else
      {
        while (resultSet.next())
        {
          String question = resultSet.getString(KEY_QUES);
          String answer = resultSet.getString(KEY_ANS);
          questions[i++] = question + ", " + answer;
        }
      }
    }
    catch (SQLException e)
    {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    return questions;
  }

  // inserts a question object into the database then shuffles the random question generator
  public void addQuestion(Question question) throws SQLException
  {
    String sql;

    Statement statement = _connection.createStatement();
    switch (question.getType())
    {
      case TABLE_MULTI:
      {
        sql = "INSERT INTO multiple_choice(question, answer, opta, optb, optc) " +
          "VALUES ('" + question + "','" + question.getAnswer().toLowerCase() + "','" + question.getOptA() + "','"
          + question.getOptB() + "','" + question.getOptC() + "');";
        break;
      }
      case TABLE_TF:
      {
        sql = "INSERT INTO true_false (question,answer) " +
          "VALUES ('" + question.getQuestion() + "','" + question.getAnswer().toLowerCase() + "')";
        break;
      }
      case TABLE_SHORT:
      {
        sql = "INSERT INTO short_answer (question,answer) " +
          "VALUES ('" + question.getQuestion() + "','" + question.getAnswer().toLowerCase() + "')";
        break;
      }
      default:
        throw new RuntimeException(question.getType() + ": invalid question type");
    }
    statement.executeUpdate(sql);
    _connection.commit();


    shuffle(question.getType());
  }
}
