public class Maze {

	private Room[][] maze;
	private int x,y; //dimentions of maze
	
	public Maze()
	{
		this.maze = null;
	}
	
	public Maze(Room[][] maze,int x,int y)
	{
		this.maze = maze;
		this.x = x;
		this.y = y;
	}
	
	public Room getRoom(int x,int y)
	{
		return maze[x][y];
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}
