package model.maze;

public class Maze {

	private Room[][] maze;
	private int x,y; //dimentions of maze
	private int endX,endY;
	
	public Maze()
	{
		this.maze = null;
	}
	
	public Maze(Room[][] maze,int x,int y,int endX, int endY)
	{
		this.maze = maze;
		this.x = x;
		this.y = y;
		this.endX = endX;
		this.endY = endY;
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

	public boolean lockDoor(int x, int y, String door)
	{
		getRoom(x,y).lockDoor(door);
		boolean[][] checked = new boolean[this.x][this.y];
		for(int i = 0; i<this.x; i++)
			for(int j = 0; j<this.y; j++)
			{
				checked[i][j] = false;
			}
		return mazeIsSolvable(x,y,checked);
	}

	private boolean mazeIsSolvable(int x, int y, boolean[][] checked)
	{
		if(x == endX && y == endY)
		{
			return true;
		}
		if(checked[x][y] == true)
			return false;
		checked[x][y] = true;
		if(x != 0 && getRoom(x,y).doorIsNull("North") && !getRoom(x,y).N_door.isPermLocked())
		{
			if(mazeIsSolvable(x-1,y,checked)) {
				return true;
			}
		}
		if(x != this.x -1 && getRoom(x,y).doorIsNull("South") && !getRoom(x,y).S_door.isPermLocked())
		{
			if(mazeIsSolvable(x+1,y,checked)) {
				return true;
			}
		}
		if(y != 0 && getRoom(x,y).doorIsNull("West") && !getRoom(x,y).W_door.isPermLocked())
		{
			if(mazeIsSolvable(x,y-1,checked)) {
				return true;
			}
		}
		if(y != this.y -1 && getRoom(x,y).doorIsNull("East") && !getRoom(x,y).E_door.isPermLocked())
		{
			if(mazeIsSolvable(x,y+1,checked)) {
				return true;
			}
		}
		return false;
	}
}
