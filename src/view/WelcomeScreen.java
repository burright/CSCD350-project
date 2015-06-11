package view;

import javax.swing.*;

/**
 * Created by Sean on 6/10/2015.
 */
public class WelcomeScreen
{
  private JOptionPane _options;
  private JDialog _dialog;
  private final String[] options = new String[] {"Play","Add Questions"};

  public WelcomeScreen()
  {
    _options = new JOptionPane("Welcome to Trivia Maze!");
    _options.setOptions(options);
    _dialog = _options.createDialog(new JFrame(),"Welcome");
  }

  public int getChoice()
  {
    _dialog.setVisible(true);
    Object object = _options.getValue();
    int result = -1;
    for (int k = 0; k < options.length; k++)
      if (options[k].equals(object))
        result = k;
    return result;
  }
}
