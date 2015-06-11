package model.maze;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import view.*;
import database.*;

import javax.swing.*;

public class MazeDriver
{

  private Database database = new Database();
  private Maze maze;
  private int curX, curY;

  public MazeDriver()
  {
    maze = new Maze();
  }

  public void createMaze(File inputfile)
  {
    int North, South, East, West, x, y;
    Room[][] temp_Maze = null;

    try
    {
      Scanner fin = new Scanner(inputfile);

      x = fin.nextInt(); //get x dimention
      y = fin.nextInt(); //get y dimention
      fin.nextLine();    //clear buffer

      temp_Maze = new Room[x][y];

      for (int i = 0; i < x; i++)
      {
        for (int j = 0; j < y; j++)
        {
          String cur = fin.nextLine();
          North = Character.getNumericValue(cur.charAt(0));
          South = Character.getNumericValue(cur.charAt(1));
          East = Character.getNumericValue(cur.charAt(2));
          West = Character.getNumericValue(cur.charAt(3));

          Room temp = new Room(North, South, East, West);

          temp_Maze[i][j] = temp;
        }
      }

      this.maze = new Maze(temp_Maze, x, y, 3, 0);
      fin.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found.");
      System.err.println(inputfile.getAbsolutePath());
    }
  }

  public void printMaze()
  {
    System.out.println("maze is of dimention: " + maze.getX() + " " + maze.getY());

    for (int i = 0; i < maze.getX(); i++)
    {
      for (int j = 0; j < maze.getY(); j++)
      {
        System.out.println("model.maze.Room index: " + i + " " + j);
        maze.getRoom(i, j).printRoom();
        System.out.println();
      }
    }
  }

  public boolean traverseMaze() {

    Scanner fin = new Scanner(System.in);
    String userIn = null;
    int correct;
    String curDirection;
    curX = 1;//start x coordinate
    curY = 3;//start y coordinate


    while (curX != 3 || curY != 0) {

      do {

        correct = 1;

        Room curroom = maze.getRoom(curX, curY);
        doorGUI doorWindow = new doorGUI(curroom);

        EventQueue.invokeLater(new Runnable() {
          public void run() {
            try {

              doorWindow.show();

            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        });

        while (doorWindow.getDoor() == null) {
          System.out.print("");
        }

        curDirection = doorWindow.getDoor();
        System.out.println(curDirection);

        Question curQuestion = database.getRandomQuestion();
        System.out.println(curQuestion.getQuestion());
        System.out.println(curQuestion.getAnswer());

        if(curroom.getDoor(curDirection).getLocked() && !curroom.getDoor(curDirection).isPermLocked())//door is not already unlocked and is not permLocked
        {

          if (curQuestion.getType().equals("short_answer")) {
            shortAnswerGUI saWindow = new shortAnswerGUI(curQuestion);
            EventQueue.invokeLater(new Runnable() {
              public void run() {
                try {

                  saWindow.show();

                } catch (Exception e) {
                  e.printStackTrace();
                }
              }
            });

            while (saWindow.getAnswer() == 0) {
              System.out.print("");
            }
            correct = saWindow.getAnswer();
          } else if (curQuestion.getType().equals("true_false")) {
            trueFalseGUI tfWindow = new trueFalseGUI(curQuestion);
            EventQueue.invokeLater(new Runnable() {
              public void run() {
                try {

                  tfWindow.show();

                } catch (Exception e) {
                  e.printStackTrace();
                }
              }
            });

            while (tfWindow.getAnswer() == 0) {
              System.out.print("");
            }
            correct = tfWindow.getAnswer();
          } else if (curQuestion.getType().equals("multiple_choice")) {
            multiChoiceGUI mcWindow = new multiChoiceGUI(curQuestion);
            EventQueue.invokeLater(new Runnable() {
              public void run() {
                try {

                  mcWindow.show();

                } catch (Exception e) {
                  e.printStackTrace();
                }
              }
            });

            while (mcWindow.getAnswer() == 0) {
              System.out.print("");
            }
            correct = mcWindow.getAnswer();
          }

          boolean navigatable = true;
          if (correct == 2) {
            navigatable = maze.lockDoor(curX, curY, curDirection);
          }
          if (navigatable == false)
            return false;

        }

        if(curroom.getDoor(curDirection).isPermLocked())
        {
            correct = -1;//loop again
            System.out.println("This door has been permanently locked!");
        }

      } while (correct != 1);

      switch (curDirection) {
        case "North":
          maze.getRoom(curX,curY).getDoor("North").setLocked(false);
          curX--;
          maze.getRoom(curX,curY).getDoor("South").setLocked(false);
          break;
        case "South":
          maze.getRoom(curX,curY).getDoor("South").setLocked(false);
          curX++;
          maze.getRoom(curX,curY).getDoor("North").setLocked(false);
          break;
        case "East":
          maze.getRoom(curX,curY).getDoor("East").setLocked(false);
          curY++;
          maze.getRoom(curX,curY).getDoor("West").setLocked(false);
          break;
        case "West":
          maze.getRoom(curX,curY).getDoor("West").setLocked(false);
          curY--;
          maze.getRoom(curX,curY).getDoor("East").setLocked(false);
          break;
      }
    }
    return true;
  }
}