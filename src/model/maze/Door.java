package model.maze;

public class Door
{

  public boolean exists;
  private boolean locked; //locked if hasn't been encountered before, unlocked if question was answered correctly
  private boolean permlocked; //permlocked == true if question was answered incorrectly

  public Door(boolean exists)
  {
    this.exists = exists;
    this.locked = true;
    this.permlocked = false;
  }

  public boolean isPermLocked()
  {
    return permlocked;
  }

  //Permanently lock the door because question was answered incorrectly
  public void lock()
  {
    this.permlocked = true;
  }

  public boolean getLocked()
  {
    return locked;
  }
  
  public void setLocked(boolean locked)
  {
    this.locked = locked;
  }

  public boolean getPermLocked()
  {
    return permlocked;
  }
}
