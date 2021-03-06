package main;

import model.maze.MazeDriver;
import view.question.AddQuestionWindow;
import view.WelcomeScreen;

import javax.swing.*;
import java.io.File;

/**
 * 
 * Team Tardis presents:
 * 
 *
 *
 *
 *
___  ___                _____    _       _       
|  \/  |               |_   _|  (_)     (_)      
| .  . | __ _ _______    | |_ __ ___   ___  __ _ 
| |\/| |/ _` |_  / _ \   | | '__| \ \ / / |/ _` |
| |  | | (_| |/ /  __/   | | |  | |\ V /| | (_| |
\_|  |_/\__,_/___\___|   \_/_|  |_| \_/ |_|\__,_|
                                                
                                                 
 * Created by 
 * Sean Burright
 * Jacob Gwin
 * Brady Clapp
 * 
 *  on 6/10/15.
 */
public class Main
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Game Over");
    WelcomeScreen welcomeScreen = new WelcomeScreen();
    switch (welcomeScreen.getChoice())
    {
      case 0:
        MazeDriver mazeDriver = new MazeDriver();
        mazeDriver.createMaze(new File("MazeInput.txt"));
        if (mazeDriver.traverseMaze())
        {
          JOptionPane.showMessageDialog(frame,"Congratulations you reached the end of the maze!");
          System.exit(0);
          //System.out.println("Congratulations you reached the end of the maze!");
        }
        else
        {
          JOptionPane.showMessageDialog(frame,"You've lost trivia maze!");
          System.exit(0);
          //System.out.println("You've lost trivia maze!");
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
