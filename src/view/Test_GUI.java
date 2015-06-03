package view;

import java.awt.EventQueue;


public class Test_GUI {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//makeGUI window = new makeGUI();
					
					makeGUI window = new multiChoiceGUI();
					window.frame.setVisible(true);
					
					makeGUI window1 = new trueFalseGUI();
					window1.frame.setVisible(true);
					
					Room room = new Room(1,0,1,0);
					doorGUI window2 = new doorGUI(room,4);
					window2.show();
					//window2.frame.setVisible(true);
					
					
					
					makeGUI window3 = new shortAnswerGUI();
					window3.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
