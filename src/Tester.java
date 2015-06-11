import model.maze.MazeDriver;

import java.io.File;

public class Tester
{

  public static void main(String[] args)
  {
    MazeDriver Mdriver = new MazeDriver();
    Mdriver.createMaze(new File("MazeInput.txt"));
    boolean completed = Mdriver.traverseMaze();
    if (completed == true)
    {
      System.out.println("Congratulations you reached the end of the maze!");
    }
    else
    {
      System.out.println("You've lost trivia maze!");
    }

  }
}
