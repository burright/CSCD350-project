package model.maze;

public class Room {

	private Door N_door,S_door,E_door,W_door;
	
	public Room(int N_door,int S_door,int E_door,int W_door)
	{
		this.N_door = new Door(N_door == 1);
		this.S_door = new Door(S_door == 1);
		this.E_door = new Door(E_door == 1);
		this.W_door = new Door(W_door == 1);
	}
	
	public void printRoom()
	{
		if(N_door.exists)
			System.out.println("North model.maze.Door");
		if(S_door.exists)
			System.out.println("South model.maze.Door");
		if(E_door.exists)
			System.out.println("East model.maze.Door");
		if(W_door.exists)
			System.out.println("West model.maze.Door");
	}
}