/*
package view;


import java.awt.EventQueue;
import model.maze.*;


public class Test_GUI {
	public static void main(String[] args) 
	{

		//doorGUI window4 = new doorGUI(new Room(1,1,1,1),4);
		//window4.show();
		
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			Room room = new Room(1,1,1,1);
			doorGUI window2 = new doorGUI(room,3);

			EventQueue.invokeLater(new Runnable()
			{
				public void run()
				{

					
				 //makeGUI window1 = new makeGUI();
				  multiChoiceGUI window1 =  new multiChoiceGUI("hey", "a", "b", "c");
				  window1.frame.setVisible(true);
				  window1.show();
				  window1.hide();
				  //window.frame.setVisible(true);
					
				  //makeGUI window1 = new trueFalseGUI();
			      //window1.frame.setVisible(true);
					
				  Room room = new Room(1,1,1,1);
				  boolean bo = true;
				  doorGUI window2 = new doorGUI(room,3);
				  window2.show();
				  
				  
				  //room.lockDoor("North");
				  //window2.checkDoorLocks(room);
				  
				 
					
					
					System.out.println("this should not print until button push");
					
					try
					{
						//makeGUI window = new makeGUI();

						//makeGUI window = new multiChoiceGUI();
						//window.frame.setVisible(true);

						//makeGUI window1 = new trueFalseGUI();
						//window1.frame.setVisible(true);


						window2.show();



*/
					/*
					System.out.println("this should not print until button push");
					room.lockDoor("North");
					doorGUI.refreshDoors(room);
					//window2.frame.setVisible(true);

					*/

						//makeGUI window3 = new shortAnswerGUI();
						//window3.frame.setVisible(true);
/*
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			});

			while(window2.getWaiting() == true)
			{
				System.out.println("waiting");
			}


		System.out.println("waited succesfully");

	}
}
*/