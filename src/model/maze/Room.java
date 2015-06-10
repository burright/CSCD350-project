package model.maze;

import view.Door;

public class Room
{

  public Door N_door, S_door, E_door, W_door;

  public Room(int N_door, int S_door, int E_door, int W_door)
  {
    this.N_door = new Door(N_door == 1);
    this.S_door = new Door(S_door == 1);
    this.E_door = new Door(E_door == 1);
    this.W_door = new Door(W_door == 1);
  }

  public void printRoom()
  {
    if (N_door.exists)
      System.out.println("North Door");
    if (S_door.exists)
      System.out.println("South Door");
    if (E_door.exists)
      System.out.println("East Door");
    if (W_door.exists)
      System.out.println("West Door");
  }

  public boolean doorIsNull(String door)
  {
    switch (door)
    {
      case "North":
        return N_door.exists;
      case "South":
        return S_door.exists;
      case "East":
        return E_door.exists;
      case "West":
        return W_door.exists;
      default:
        return false;
    }
  }

  public void lockDoor(String door)
  {
    switch (door)
    {
      case "North":
        N_door.lock();
        break;
      case "South":
        S_door.lock();
        break;
      case "East":
        E_door.lock();
        break;
      case "West":
        W_door.lock();
        break;
    }
  }

  public Door getDoor(String door)
  {
    switch (door)
    {
      case "North":
        return N_door;
      case "South":
        return S_door;
      case "East":
        return E_door;
      case "West":
        return W_door;
      default:
        return null;
    }
  }
}
