import model.maze.MazeDriver;

import java.io.*;

public class Tester {

	public static void main(String[] args)
	{
		MazeDriver Mdriver = new MazeDriver();
		
		Mdriver.createMaze(new File("MazeInput.txt"));
		
		Mdriver.printMaze();
	}
}
