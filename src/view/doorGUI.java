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

public class doorGUI extends makeGUI {
	
	public doorGUI(){
		frame = new JFrame();
		frame.setBounds(100, 100, 740, 422);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		BufferedImage myPicture = null;
		
	    /*
		try {
			myPicture = ImageIO.read(new File("C:\\Users\\Braden\\workspace\\GUI\\src\\DoorUnlocked.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			myPicture = ImageIO.read(new File("C:\\Users\\Braden\\workspace\\GUI\\src\\DoorLocked.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			myPicture = ImageIO.read(new File("C:\\Users\\Braden\\workspace\\GUI\\src\\DoorLocked.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		//Create buttons
		JButton btn1 = new JButton("Door Locked");
		btn1.setBounds(94, 326, 103, 23);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("Open Door");
		btn2.setBounds(311, 326, 103, 23);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("Door Locked");
		btn3.setBounds(530, 326, 103, 23);
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

}
