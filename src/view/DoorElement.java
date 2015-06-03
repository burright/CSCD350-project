package view;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class DoorElement 
{
	private JButton btn;
	private JLabel door;
	
	
	public DoorElement(JButton btn, JLabel door)
	{
		this.btn = btn;
		this.door = door;
	}
	
	public void lockDoor()
	{
		try 
		{
			this.door.setIcon(new ImageIcon(new URL("//http://i.imgur.com/9Iyt73S.jpg")));
			this.btn.setText("Locked");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
