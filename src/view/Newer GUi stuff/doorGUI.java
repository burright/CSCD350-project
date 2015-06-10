package view;
<<<<<<< HEAD
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class doorGUI  //rename to roomGUI
{
	private static Door n,s,e,w; //make private
	private static JFrame frame;
	private static int north, south, east, west;
	private static DoorElement nDoor,sDoor,eDoor,wDoor;
	private static DoorElement[] ndoors = new DoorElement[4];
	private static Door[] mazeDoors = new Door[4];
	private static int numDoors;
	private static Room rm;
	public static boolean waits = true;
	
	public void twoDoor(Room room)
	{
		
		//	private JButton btn;
		//private JLabel door;
	
		
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
	
	//re-analyze doors and lock doors
	public static ActionListener makeAction(final int i){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				//Open trivia
				System.out.println("Button was pushed");
				ndoors[i].lockDoor();
				waits = false; 
			}
		};
	}
	
	
	public static void checkDoorLocks(Room room){
		//analyzeRoom(room);
		if(n.exists && room.getDoor("North").locked()){
			//change to locked door
			nDoor.lockDoor();
			//ndoors[nDoor.getIndex()].lockDoor();
		}
		if(s.exists && room.getDoor("South").locked()){
			//change to locked door
			sDoor.lockDoor();
			//ndoors[sDoor.getIndex()].lockDoor();
		}
		if(e.exists && room.getDoor("East").locked()){
			//change to locked door
			eDoor.lockDoor();
			//ndoors[eDoor.getIndex()].lockDoor();
		}
		if(w.exists && room.getDoor("West").locked()){
			//change to locked door
			wDoor.lockDoor();
			//ndoors[wDoor.getIndex()].lockDoor();
		}
		
		rm = room;	
	}
	
	public static void refreshDoors(Room room){
		
	}
	
	
	
	
	
	
	private void clear(){
		ndoors = new DoorElement[4];
		mazeDoors = new Door[4];
		frame.removeAll();
		frame = new JFrame();
		frame.setBounds(100, 100, 740, 422);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//threeDoor(rm);
	}
	
	public doorGUI(Room room,int numOfDoors)
	{	
		
		frame = new JFrame();
		frame.setBounds(100, 100, 740, 422);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
	
		int c = analyzeRoom(room);
		System.out.println(c);
		//set layout to hold number of doors
		
		
		if(c==2)
			twoDoor(room);
		else if(c==3)
			threeDoor(room);
		else if(c==4)
			fourDoor(room);
		
		rm = room;
		//frame.setVisible(true);
	}

	
	
	private static int analyzeRoom(Room room) //Count and assign doors
	{
		int count = 0;
		if(room.doorIsNull("North"))
		{
			nDoor= makeDoor(room.getDoor("North"),count);
			mazeDoors[count] = room.getDoor("North");
			ndoors[count] = nDoor;
			count++;
		}
		if(room.doorIsNull("South"))
		{
			sDoor = makeDoor(room.getDoor("South"),count);
			mazeDoors[count] = room.getDoor("South");
			ndoors[count] = sDoor;
			count++;
		}
		if(room.doorIsNull("East"))
		{
			eDoor = makeDoor(room.getDoor("East"),count);
			mazeDoors[count] = room.getDoor("East");
			ndoors[count] = eDoor;
			count++;
		}
		if(room.doorIsNull("West")){
			
			wDoor = makeDoor(room.getDoor("West"),count);
			mazeDoors[count] = room.getDoor("West");
			ndoors[count] = wDoor;
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
			if(door.locked()){ //door unlocked
				 btn = new JButton("Try to open");
					
				 try {
					door1 = new JLabel(new ImageIcon(new URL("http://i.imgur.com/9Iyt73S.jpg")));
				} catch (MalformedURLException e) {
						System.out.println("Something went wrong");
						e.printStackTrace();
				}
				
			}else //door locked
			{
				btn = new JButton("");
				
				try {
					door1 = new JLabel(new ImageIcon(new URL("http://i.imgur.com/9Iyt73S.jpg")));
				} catch (MalformedURLException e) {
					System.out.println("Something went wrong");
					e.printStackTrace();
				}
				
			}
			
			
			//frame.getContentPane().add(door1);
			//frame.getContentPane().add(btn);
			
			
			return new DoorElement(btn,door1,index);
		}
		else
		{
			return null;
		}
		
	}
	
	public void makeDoor1(){
		
		
		JButton btn1 = new JButton("Door Locked");
		btn1.setBounds(69, 326, 149, 23);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("Open Door");
		btn2.setBounds(287, 326, 149, 23);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("Door Locked");
		btn3.setBounds(505, 326, 149, 23);
		frame.getContentPane().add(btn3);
		
		
		//http://i.imgur.com/o7UWme9.jpg    ---unlocked
		//http://i.imgur.com/9Iyt73S.jpg    ---locked
		//Set Images
		JLabel door1 = null;
		try {
			door1 = new JLabel(new ImageIcon(new URL("http://i.imgur.com/o7UWme9.jpg")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		door1.setBounds(287, 11, 149, 338);
		frame.getContentPane().add(door1);
		
		JLabel door2 = null;
		try {
			door2 = new JLabel(new ImageIcon(new URL("http://i.imgur.com/9Iyt73S.jpg")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		door2.setBounds(505, 11, 149, 338);
		frame.getContentPane().add(door2);
		
		JLabel door3 = null;
		try {
			door3 = new JLabel(new ImageIcon(new URL("http://i.imgur.com/9Iyt73S.jpg")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		door3.setBounds(69, 11, 149, 338);
		frame.getContentPane().add(door3);
		/*
		BufferedImage myPicture = ImageIO.read(new File(new URL("http://simpleicon.com/wp-content/uploads/lock-2.png")));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		add(picLabel);
		*/
	}

	public void show() {
		this.frame.setVisible(true);
	}
	public void hide()
	{
		this.frame.setVisible(false);
	}
=======

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class doorGUI  //rename to roomGUI
{
  private static Door n, s, e, w;
  private static JFrame frame;
  private static DoorElement nDoor, sDoor, eDoor, wDoor;

  public doorGUI(Room room, int numOfDoors)
  {

    frame = new JFrame();
    frame.setBounds(100, 100, 740, 422);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);


    int c = analyzeRoom(room); //count doors and assign objects

    //set layout to hold number of doors
    switch (c)
    {

      case 2:
        twoDoor();
      case 3:
        threeDoor();
      case 4:
        fourDoor();
    }

    //frame.setVisible(true);
  }

  //re-analyze doors and newly locked doors
  public static void refreshDoors(Room room)
  {
    analyzeRoom(room);
    if (n.exists && n.locked())
    {
      //change to locked door
      nDoor.lockDoor();
    }
    if (s.exists && s.locked())
    {
      //change to locked door
      sDoor.lockDoor();
    }
    if (e.exists && e.locked())
    {
      //change to locked door
      eDoor.lockDoor();
    }
    if (w.exists && w.locked())
    {
      //change to locked door
      wDoor.lockDoor();
    }


  }

  private static int analyzeRoom(Room room) //Count and assign doors
  {
    int count = 0;
    if (room.doorIsNull("North"))
    {
      n = room.getDoor("North");
      nDoor = makeDoor(n);
      count++;
    }
    if (room.doorIsNull("South"))
    {
      s = room.getDoor("South");
      sDoor = makeDoor(s);
      count++;
    }
    if (room.doorIsNull("East"))
    {
      e = room.getDoor("East");
      eDoor = makeDoor(e);
      count++;
    }
    if (room.doorIsNull("West"))
    {
      w = room.getDoor("West");
      wDoor = makeDoor(w);
      count++;
    }
    return count;
  }

  public static DoorElement makeDoor(Door door)
  {
    if (door.exists) //door exists
    {
      JButton btn = null;
      JLabel door1 = null;
      if (door.locked())
      { //door unlocked
        btn = new JButton("Open Door");

        try
        {
          door1 = new JLabel(new ImageIcon(new URL("//http://i.imgur.com/o7UWme9.jpg"))); //unlocked
        }
        catch (MalformedURLException e)
        {
          e.printStackTrace();
        }
        // door1.setBounds(287, 11, 149, 338);
        //place in order method call for door and btn
        //placeDoor(btn,door1);

      }
      else //door locked
      {
        btn = new JButton("Door Locked");

        try
        {
          door1 = new JLabel(new ImageIcon(new URL("//http://i.imgur.com/9Iyt73S.jpg"))); //locked
        }
        catch (MalformedURLException e)
        {
          e.printStackTrace();
        }
        //door1.setBounds(287, 11, 149, 338);
        //place in order method call
        //placeDoor(btn,door1);
      }
      frame.getContentPane().add(door1);
      frame.getContentPane().add(btn);
      return new DoorElement(btn, door1);
    }
    else
    {
      return null; //do nothing
    }

  }

  public void twoDoor()
  {
    //set two door layout
  }

  public void threeDoor()
  {
    //set three door layout
  }

  public void fourDoor()
  {
    //set four door layout
  }

  public void makeDoor1()
  {


    JButton btn1 = new JButton("Door Locked");
    btn1.setBounds(69, 326, 149, 23);
    frame.getContentPane().add(btn1);

    JButton btn2 = new JButton("Open Door");
    btn2.setBounds(287, 326, 149, 23);
    frame.getContentPane().add(btn2);

    JButton btn3 = new JButton("Door Locked");
    btn3.setBounds(505, 326, 149, 23);
    frame.getContentPane().add(btn3);


    //http://i.imgur.com/o7UWme9.jpg    ---unlocked
    //http://i.imgur.com/9Iyt73S.jpg    ---locked
    //Set Images
    JLabel door1 = null;
    try
    {
      door1 = new JLabel(new ImageIcon(new URL("http://i.imgur.com/o7UWme9.jpg")));
    }
    catch (MalformedURLException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    door1.setBounds(287, 11, 149, 338);
    frame.getContentPane().add(door1);

    JLabel door2 = null;
    try
    {
      door2 = new JLabel(new ImageIcon(new URL("http://i.imgur.com/9Iyt73S.jpg")));
    }
    catch (MalformedURLException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    door2.setBounds(505, 11, 149, 338);
    frame.getContentPane().add(door2);

    JLabel door3 = null;
    try
    {
      door3 = new JLabel(new ImageIcon(new URL("http://i.imgur.com/9Iyt73S.jpg")));
    }
    catch (MalformedURLException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    door3.setBounds(69, 11, 149, 338);
    frame.getContentPane().add(door3);
    /*
    BufferedImage myPicture = ImageIO.read(new File(new URL("http://simpleicon.com/wp-content/uploads/lock-2.png")));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		add(picLabel);
		*/
  }

  public void show()
  {
    this.frame.setVisible(true);
  }

  public void hide()
  {
    this.frame.setVisible(false);
  }
>>>>>>> origin/master

}
