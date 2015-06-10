//package view;

import javax.swing.*;
import java.awt.*;

public class shortAnswerGUI extends makeGUI
{
  public shortAnswerGUI()
  {

    JTextField textField;

    frame = new JFrame();
    frame.setBounds(100, 100, 743, 435);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JTextPane txtpnWhatDoesIt = new JTextPane();
    txtpnWhatDoesIt.setBackground(SystemColor.menu);
    txtpnWhatDoesIt.setText("What does it mean for a bowler to score a turkey?");
    txtpnWhatDoesIt.setBounds(233, 189, 336, 77);
    frame.getContentPane().add(txtpnWhatDoesIt);

    JButton btnNewButton = new JButton("submit");
    btnNewButton.setBounds(565, 304, 89, 23);
    frame.getContentPane().add(btnNewButton);

    textField = new JTextField();
    textField.setBounds(172, 277, 385, 77);
    frame.getContentPane().add(textField);
    textField.setColumns(10);
  }

}
