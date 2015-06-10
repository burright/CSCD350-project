package main;

import database.Database;
import model.maze.MazeDriver;

import java.io.File;

/**
 * Created by Sean Burright on 6/10/15.
 */
public class Main
{
  public static void main(String[] args)
  {
    Database database = new Database();
    MazeDriver mazeDriver = new MazeDriver();
    mazeDriver.createMaze(new File("MazeInput.txt"));

  }
}
