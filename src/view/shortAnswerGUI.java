package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.*;

public class shortAnswerGUI extends makeGUI
{

  private int answer = 0;//0 means not answered, 1 means correct, 2 means incorrect
  private Question question;
  public JTextField textField;

  public int getAnswer()
  {
    return this.answer;
  }
  public void setAnswer(int answer)
  {
    this.answer = answer;
  }

  public shortAnswerGUI(Question question)
  {
    this.question = question;

    

    frame = new JFrame();
    frame.setBounds(100, 100, 743, 435);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JTextPane txtpnWhatDoesIt = new JTextPane();
    txtpnWhatDoesIt.setBackground(SystemColor.menu);
    txtpnWhatDoesIt.setText(question.getQuestion());
    txtpnWhatDoesIt.setBounds(233, 189, 336, 77);
    frame.getContentPane().add(txtpnWhatDoesIt);

    JButton btnNewButton = new JButton("submit");
    btnNewButton.setBounds(565, 304, 89, 23);
    btnNewButton.addActionListener(getAction());
    frame.getContentPane().add(btnNewButton);

    textField = new JTextField();
    textField.setBounds(172, 277, 385, 77);
    frame.getContentPane().add(textField);
    textField.setColumns(10);
    
  }

  public void show() {
    frame.setVisible(true);

  }
  public void hide() {
    frame.setVisible(false);
  }
  
  public ActionListener getAction()
	{
		return new ActionListener(){
			
		public void actionPerformed(ActionEvent arg0) 
		{
			//Display dialog saying correct
			
			
			String txt = textField.getText();
			System.out.println(txt);
			if(txt.equals("")){
				JOptionPane.showMessageDialog(frame,
					    "You did not answer the question!",
					    "Hey!",
					    JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				if(txt.equalsIgnoreCase(question.getAnswer())==true){
					JOptionPane.showMessageDialog(frame,
						    "Correct answer!",
						    "Congrats!",
						    JOptionPane.PLAIN_MESSAGE);
					
					setAnswer(1);
				}
				else if(txt.equalsIgnoreCase(question.getAnswer())==false)
				{
					JOptionPane.showMessageDialog(frame,
						    "You got the answer wrong!",
						    "Sorry!",
						    JOptionPane.PLAIN_MESSAGE);
					
					setAnswer(2);
				}
				frame.removeAll();
				frame.dispose();
			}
			
			
			
		}
	};
	}
}
