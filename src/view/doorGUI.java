//package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.MalformedURLException;
import java.net.URL;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class doorGUI  //rename to roomGUI
{
	private static Door n, s, e, w; //make private
	private static JFrame frame;

	private static DoorElement nDoor, sDoor, eDoor, wDoor;
	private static DoorElement[] ndoors = new DoorElement[4];
	private static Door[] mazeDoors = new Door[4];
	private static int numDoors;
	private static Room rm;
	public static boolean waits = true;

  public doorGUI(Room room, int numOfDoors)
  {
       frame = new JFrame();
       frame.setBounds(100, 100, 740, 422);	
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.getContentPane().setLayout(null);	
       
       int c = analyzeRoom(room);
       System.out.println(c);
       //set layout to hold number of doors
			
       if(c == 2)
       	  twoDoor(room);
       else if(c == 3)
       	  threeDoor(room);
       else if(c == 4)
       	  fourDoor(room);
  
       rm = room;
	//frame.setVisible(true);

  }

 public static void checkDoorLocks(Room room)
 {
   //analyzeRoom(room);
   if(n.exists && room.getDoor("North").isPermLocked())
   {
   //change to locked door
     nDoor.lockDoor();
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

 private static int analyzeRoom(Room room) //Count and assign doors
 {
   int count = 0;
   if(room.doorIsNull("North"))
   {
     nDoor= makeDoor(room.getDoor("North"),count);
     mazeDoors[count] = room.getDoor("North");
     ndoors[count] = nDoor;		
     nDoor.setIndex(count);
     ndoors[count].setIndex(count);
     count++;
   }
   if(room.doorIsNull("South"))
   {
     sDoor = makeDoor(room.getDoor("South"),count);
     mazeDoors[count] = room.getDoor("South");
     ndoors[count] = sDoor;		
     sDoor.setIndex(count);
     ndoors[count].setIndex(count);		
     count++;
   }
   if(room.doorIsNull("East"))
   {
     eDoor = makeDoor(room.getDoor("East"),count);
     mazeDoors[count] = room.getDoor("East");
     ndoors[count] = eDoor;
     eDoor.setIndex(count);
     ndoors[count].setIndex(count);		
     count++;
   }
   if(room.doorIsNull("West"))
   {			
     wDoor = makeDoor(room.getDoor("West"),count);
     mazeDoors[count] = room.getDoor("West");
     ndoors[count] = wDoor;
     wDoor.setIndex(count);
     ndoors[count].setIndex(count);		
     count++;
   }
     numDoors = count;	
     return count;
	}

  public static DoorElement makeDoor(Door door,int index)
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
	
  
	public void twoDoor(Room room)
	{
	
		
		ndoors[0].getBtn().setBounds(96, 326, 149, 23);
		frame.getContentPane().add(ndoors[0].getBtn());
		
		ndoors[0].getLbl().setBounds(96, 11, 149, 338);
		frame.getContentPane().add(ndoors[0].getLbl());
		
		
		
		ndoors[1].getBtn().setBounds(465, 326, 149, 23);
		frame.getContentPane().add(ndoors[1].getBtn());

		ndoors[1].getLbl().setBounds(465, 11, 149, 338);
		frame.getContentPane().add(ndoors[1].getLbl());
		
		
	}
	
	public void threeDoor(Room room)
	{
		
		ndoors[0].getBtn().setBounds(69, 326, 149, 23);
		frame.getContentPane().add(ndoors[0].getBtn());
		
		ndoors[0].getLbl().setBounds(69, 11, 149, 338);
		frame.getContentPane().add(ndoors[0].getLbl());
		
		
		
		
		ndoors[1].getBtn().setBounds(287, 326, 149, 23);
		frame.getContentPane().add(ndoors[1].getBtn());
		
		ndoors[1].getLbl().setBounds(287, 11, 149, 338);
		frame.getContentPane().add(ndoors[1].getLbl());
		
	
		
		
		ndoors[2].getBtn().setBounds(505, 326, 149, 23);
		frame.getContentPane().add(ndoors[2].getBtn());
		
		ndoors[2].getLbl().setBounds(505, 11, 149, 338);
		frame.getContentPane().add(ndoors[2].getLbl());
	
	
		
	
	}
	
	
	public void fourDoor(Room room)
	{

		ndoors[0].getBtn().setBounds(30, 326, 149, 23);
		frame.getContentPane().add(ndoors[0].getBtn());
		
		ndoors[0].getLbl().setBounds(30, 11, 149, 338);
		frame.getContentPane().add(ndoors[0].getLbl());
		
		

		
		ndoors[1].getBtn().setBounds(209, 326, 149, 23);
		frame.getContentPane().add(ndoors[1].getBtn());
		
		ndoors[1].getLbl().setBounds(209, 11, 149, 338);
		frame.getContentPane().add(ndoors[1].getLbl());
		
	
	
		ndoors[2].getBtn().setBounds(391, 326, 149, 23);
		frame.getContentPane().add(ndoors[2].getBtn());
		
		ndoors[2].getLbl().setBounds(391, 11, 149, 338);
		frame.getContentPane().add(ndoors[2].getLbl());
		

		
		ndoors[3].getBtn().setBounds(565, 326, 149, 23);
		frame.getContentPane().add(ndoors[3].getBtn());
		
		
		ndoors[3].getBtn().addActionListener(makeAction(3));
	    
		
		ndoors[3].getLbl().setBounds(565, 11, 149, 338);
		frame.getContentPane().add(ndoors[3].getLbl());
		
	}
	
	public static ActionListener makeAction(final int i)
	{
		return new ActionListener() 
		{
			
		public void actionPerformed(ActionEvent arg0) 
		{
			//Open trivia
			System.out.println("Button was pushed");
			ndoors[i].lockDoor();
			waits = false; 
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

