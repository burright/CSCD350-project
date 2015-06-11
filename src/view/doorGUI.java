package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.MalformedURLException;
import java.net.URL;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import model.maze.*;

public class doorGUI  //rename to roomGUI
{
	private Door n, s, e, w; //make private
	private JFrame frame;


	private DoorElement nDoor, sDoor, eDoor, wDoor;
	private DoorElement[] ndoors = new DoorElement[4];
	private Door[] mazeDoors = new Door[4];
	private int numDoors;
	private Room rm;
	public String openedDoor = null;

    public void setDoor(String door)
    {
        this.openedDoor = door;
    }
    public String getDoor()
    {
        return this.openedDoor;
    }


  public doorGUI(Room room)
  {
       frame = new JFrame();
       frame.setBounds(100, 100, 740, 422);	
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.getContentPane().setLayout(null);	
  
       try {
		frame.setContentPane(new JLabel(new ImageIcon(new URL("http://file3.guildlaunch.net/194825/grunge-brick-wall-background1.jpg"))));
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       int c = analyzeRoom(room);
       //set layout to hold number of doors

       if(c == 1)
           oneDoor(room);
       else if(c == 2)
       	  twoDoor(room);
       else if(c == 3)
       	  threeDoor(room);
       else if(c == 4)
       	  fourDoor(room);
  
       rm = room;

  }

 public void checkDoorLocks(Room room)
 {
   //analyzeRoom(room);
   if(n.exists && room.getDoor("North").isPermLocked())
   {
   //change to locked door
     this.nDoor.lockDoor();
     ndoors[nDoor.getIndex()].lockDoor();
   }
   if(s.exists && room.getDoor("South").isPermLocked())
   {
   //change to locked door
     sDoor.lockDoor();
     ndoors[sDoor.getIndex()].lockDoor();
   }
   if(e.exists && room.getDoor("East").isPermLocked())
   {
   //change to locked door
     eDoor.lockDoor();
     ndoors[eDoor.getIndex()].lockDoor();
   }
   if(w.exists && room.getDoor("West").isPermLocked())
   {
   //change to locked door
     wDoor.lockDoor();
     ndoors[wDoor.getIndex()].lockDoor();
   }
		
   rm = room;	
 }
 
 public Door getDoorObject(String dir){
	 if(dir.equals("North")){
		 return n;
	 }
	 else if(dir.equals("East")){
		 return e;
	 }
	 else if(dir.equals("West")){
		 return w;
	 }
	 else if(dir.equals("South")){
		 return s;
	 }
	 System.out.println("oops");
	 return null;
 }

 private int analyzeRoom(Room room) //Count and assign doors
 {
   int count = 0;
   if(room.doorIsNull("North"))
   {
	 n = room.getDoor("North");
     nDoor= makeDoor(n,count);
     nDoor.setDirection("North");
     mazeDoors[count] = room.getDoor("North");
     ndoors[count] = nDoor;		
     nDoor.setIndex(count);
     ndoors[count].setIndex(count);
     count++;
   }
   if(room.doorIsNull("South"))
   {
	 s = room.getDoor("South");
     sDoor = makeDoor(s,count);
     sDoor.setDirection("South");
     mazeDoors[count] = room.getDoor("South");
     ndoors[count] = sDoor;		
     sDoor.setIndex(count);
     ndoors[count].setIndex(count);		
     count++;
   }
   if(room.doorIsNull("East"))
   {
	 e = room.getDoor("East");
     eDoor = makeDoor(e,count);
     eDoor.setDirection("East");
     mazeDoors[count] = room.getDoor("East");
     ndoors[count] = eDoor;
     eDoor.setIndex(count);
     ndoors[count].setIndex(count);		
     count++;
   }
   if(room.doorIsNull("West"))
   {	
	 w = room.getDoor("West");  
     wDoor = makeDoor(w,count);
     wDoor.setDirection("West");
     mazeDoors[count] = room.getDoor("West");
     ndoors[count] = wDoor;
     wDoor.setIndex(count);
     ndoors[count].setIndex(count);		
     count++;
   }
     numDoors = count;	
     return count;
	}

  public DoorElement makeDoor(Door door,int index)
  {
   if(door.exists) //door exists
   {
     JButton btn = null;
     JLabel door1 = null;
     
     if(door.getLocked())
     { //door unlocked
       btn = new JButton("Try to open");
					
       try 
       {
	    door1 = new JLabel(new ImageIcon(new URL("http://i.imgur.com/9Iyt73S.jpg")));
       } 
       catch (MalformedURLException e) 
       {
    	System.out.println("Something went wrong");
	    e.printStackTrace();
       }
				
	 }
     else //door locked
     {
	   btn = new JButton("Open door");
				
	   try 
	   {
	    door1 = new JLabel(new ImageIcon(new URL("http://i.imgur.com/o7UWme9.jpg")));
	   } 
	   catch (MalformedURLException e) 
	   {
	    System.out.println("Something went wrong");
	    e.printStackTrace();
	   }
     }
      
     return new DoorElement(btn,door1,index);
   }
   else
   {
    return null;
   }
		
 }
	public void oneDoor(Room room)
    {
        ndoors[0].getBtn().setBounds(287, 326, 149, 23);
        frame.getContentPane().add(ndoors[0].getBtn());

        ndoors[0].getBtn().addActionListener(makeAction(0));

        ndoors[0].getLbl().setBounds(287, 11, 149, 338);
        frame.getContentPane().add(ndoors[0].getLbl());
    }
  
	public void twoDoor(Room room)
	{
	
		
		ndoors[0].getBtn().setBounds(96, 326, 149, 23);
		frame.getContentPane().add(ndoors[0].getBtn());

        ndoors[0].getBtn().addActionListener(makeAction(0));

        ndoors[0].getLbl().setBounds(96, 11, 149, 338);
		frame.getContentPane().add(ndoors[0].getLbl());
		
		
		
		ndoors[1].getBtn().setBounds(465, 326, 149, 23);
		frame.getContentPane().add(ndoors[1].getBtn());

        ndoors[1].getBtn().addActionListener(makeAction(1));

        ndoors[1].getLbl().setBounds(465, 11, 149, 338);
		frame.getContentPane().add(ndoors[1].getLbl());
		
		
	}
	
	public void threeDoor(Room room)
	{
		
		ndoors[0].getBtn().setBounds(69, 326, 149, 23);
		frame.getContentPane().add(ndoors[0].getBtn());

        ndoors[0].getBtn().addActionListener(makeAction(0));

        ndoors[0].getLbl().setBounds(69, 11, 149, 338);
		frame.getContentPane().add(ndoors[0].getLbl());
		
		
		
		
		ndoors[1].getBtn().setBounds(287, 326, 149, 23);
		frame.getContentPane().add(ndoors[1].getBtn());

        ndoors[1].getBtn().addActionListener(makeAction(1));

        ndoors[1].getLbl().setBounds(287, 11, 149, 338);
		frame.getContentPane().add(ndoors[1].getLbl());
		
	
		
		
		ndoors[2].getBtn().setBounds(505, 326, 149, 23);
		frame.getContentPane().add(ndoors[2].getBtn());

        ndoors[2].getBtn().addActionListener(makeAction(2));

        ndoors[2].getLbl().setBounds(505, 11, 149, 338);
		frame.getContentPane().add(ndoors[2].getLbl());

	
	}
	
	public void fourDoor(Room room)
	{

		ndoors[0].getBtn().setBounds(30, 326, 149, 23);
		frame.getContentPane().add(ndoors[0].getBtn());

        ndoors[0].getBtn().addActionListener(makeAction(0));

        ndoors[0].getLbl().setBounds(30, 11, 149, 338);
		frame.getContentPane().add(ndoors[0].getLbl());
		
		

		
		ndoors[1].getBtn().setBounds(209, 326, 149, 23);
		frame.getContentPane().add(ndoors[1].getBtn());

        ndoors[1].getBtn().addActionListener(makeAction(1));

        ndoors[1].getLbl().setBounds(209, 11, 149, 338);
		frame.getContentPane().add(ndoors[1].getLbl());
		
	
	
		ndoors[2].getBtn().setBounds(391, 326, 149, 23);
		frame.getContentPane().add(ndoors[2].getBtn());

        ndoors[2].getBtn().addActionListener(makeAction(2));

        ndoors[2].getLbl().setBounds(391, 11, 149, 338);
		frame.getContentPane().add(ndoors[2].getLbl());
		

		
		ndoors[3].getBtn().setBounds(565, 326, 149, 23);
		frame.getContentPane().add(ndoors[3].getBtn());
		
		
		ndoors[3].getBtn().addActionListener(makeAction(3));
		//ndoors[3].getBtn().addActionListener(makeQuestionAction(3));
		
		ndoors[3].getLbl().setBounds(565, 11, 149, 338);
		frame.getContentPane().add(ndoors[3].getLbl());
		
	}
	
	public ActionListener makeAction(final int i)
	{
		return new ActionListener(){
			
		public void actionPerformed(ActionEvent arg0) 
		{
			//Open trivia
			if(getDoorObject(ndoors[i].getDirection()).isPermLocked())
			{
				
			}
			else
			{
            System.out.println("Button was pushed");
			//ndoors[i].lockDoor();
            frame.removeAll();
            frame.setVisible(false);
            setDoor(ndoors[i].getDirection());
			}
		}
	};
	}

	
	public ActionListener makeQuestionAction(final int i)
	{
		return new ActionListener() 
		{
			
		public void actionPerformed(ActionEvent arg0) 
		{
			//Open trivia
			//Question n = new Question();
			
			System.out.println("Button was pushed");
			System.out.println(super.getClass().toString());
			//get random question and display GUI for that question.
			
			//if question wrong lock door
			ndoors[i].lockDoor();
			
		}
	};
	}


  public void show()
  {
    this.frame.setVisible(true);
  }

  public void hide()
  {
    this.frame.setVisible(false);
  }

}
