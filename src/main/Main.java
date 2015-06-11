package main;

import model.maze.MazeDriver;
import view.question.AddQuestionWindow;
import view.WelcomeScreen;

import java.io.File;

/**
 * Created by Sean Burright on 6/10/15.
 */
public class Main
{
  public static void main(String[] args)
  {
    WelcomeScreen welcomeScreen = new WelcomeScreen();
    switch (welcomeScreen.getChoice())
    {
      case 0:
        MazeDriver mazeDriver = new MazeDriver();
        mazeDriver.createMaze(new File("MazeInput.txt"));
        if (mazeDriver.traverseMaze())
        {
          System.out.println("Congratulations you reached the end of the maze!");
        }
        else
        {
          System.out.println("You've lost trivia maze!");
        }
        break;
      case 1:
        AddQuestionWindow addQuestionWindow = new AddQuestionWindow();
        addQuestionWindow.questionWindow();
        break;
      default:
        System.exit(0);
    }
  }
}
