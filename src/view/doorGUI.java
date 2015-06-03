package view;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class doorGUI  //rename to roomGUI
{
	private static Door n,s,e,w; //make private
	private static JFrame frame;
	private static DoorElement nDoor,sDoor,eDoor,wDoor;

	public void twoDoor()
	{

	}
	
	public void threeDoor()
	{

	}
	
	public void fourDoor()
	{

	}
	
	//re-analyze doors and lock doors
	public static void refreshDoors(Room room){
		analyzeRoom(room);
		if(n.exists && n.locked()){
			//change to locked door
			nDoor.lockDoor();
		}
		if(s.exists && s.locked()){
			//change to locked door
			sDoor.lockDoor();
		}
		if(e.exists && e.locked()){
			//change to locked door
			eDoor.lockDoor();
		}
		if(w.exists && w.locked()){
			//change to locked door
			wDoor.lockDoor();
		}
		
			
	}
	public doorGUI(Room room,int numOfDoors)
	{	
		
		frame = new JFrame();
		frame.setBounds(100, 100, 740, 422);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
	
		int c = analyzeRoom(room);
		//set layout to hold number of doors
		switch(c){
			
		case 2:
			twoDoor();
		case 3:
			threeDoor();
		case 4:
			fourDoor();
		}
	
		//frame.setVisible(true);
	}

	
	private static int analyzeRoom(Room room) //Count and assign doors
	{
		int count = 0;
		if(room.doorIsNull("North"))
		{
			n = room.getDoor("North");
			nDoor = makeDoor(n);
			count++;
		}
		if(room.doorIsNull("South"))
		{
			s = room.getDoor("South");
			sDoor = makeDoor(n);
			count++;
		}
		if(room.doorIsNull("East"))
		{
			e = room.getDoor("East");
			eDoor = makeDoor(n);
			count++;
		}
		if(room.doorIsNull("West")){
			w = room.getDoor("West");
			wDoor = makeDoor(n);
			count++;
		}
		return count;
	}
	
	
	public static DoorElement makeDoor(Door door)
	{
		if(door.exists) //door exists
		{
			JButton btn = null;
			JLabel door1 = null;
			if(door.locked()){ //door unlocked
				 btn = new JButton("Open Door");
					
				 try {
					door1 = new JLabel(new ImageIcon(new URL("//http://i.imgur.com/o7UWme9.jpg")));
				} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
				// door1.setBounds(287, 11, 149, 338);
				//place in order method call for door and btn
				//placeDoor(btn,door1);
				
			}else //door locked
			{
				btn = new JButton("Door Locked");
				
				try {
					door1 = new JLabel(new ImageIcon(new URL("//http://i.imgur.com/9Iyt73S.jpg")));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//door1.setBounds(287, 11, 149, 338);
				//place in order method call
				//placeDoor(btn,door1);
			}
			frame.getContentPane().add(door1);
			frame.getContentPane().add(btn);
			return new DoorElement(btn,door1);
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

}
