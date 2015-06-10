//package view;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

 public class DoorElement
 {
  private JButton btn;
  private JLabel door;
  private int in;
 
 
 public int getIndex()
 {
  return in;
 }
  
 public void setIndex(int index)
 {
  this.in = index;
 }
	
 public JButton getBtn() 
 {
  return btn;
 }

 public void setBtn(JButton btn)
 {	
  this.btn = btn;
 }
 
 public JLabel getLbl() 
 {
  return door;
 }
 
 public void setLbl(JLabel door) 
 {
  this.door = door;
 }

 public DoorElement(JButton btn, JLabel door, int index)
 {
  this.btn = btn;
  this.door = door;
  this.in = index;
 }

 public void lockDoor()
 {
  try
  {
   this.door.setIcon(new ImageIcon(new URL("http://i.imgur.com/9Iyt73S.jpg")));
   this.btn.setText("Locked");
  }
  catch (MalformedURLException e)
  {
   e.printStackTrace();
  }
 }

}
