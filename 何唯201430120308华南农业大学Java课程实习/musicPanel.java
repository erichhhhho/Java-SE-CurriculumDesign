package øŒ…Ë1;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class musicPanel extends JPanel {
	private JComboBox musicCombo;
	   private JButton stopButton, playButton;
	   private AudioClip[] music;
	   private AudioClip current;
	   public musicPanel()
	   {
	      URL url1, url2, url3;
	      url1 = url2 = url3 = null;
	      try
	      {
	         url1 = new URL ("file", "localhost", "C:/Users/v5-573/Desktop/JAVA project eric/Maroon 5 - Moves Like Jagger.wav");
	         url2 = new URL ("file", "localhost", "C:/Users/v5-573/Desktop/JAVA project eric/Everglow.wav");
	         url3 = new URL ("file", "localhost", "C:/Users/v5-573/Desktop/JAVA project eric/Hello.wav");
	
	      }
	      catch (Exception exception) {}

	      music = new AudioClip[4];
	      music[0] = null;  // Corresponds to "Make a Selection..."
	      music[1] = JApplet.newAudioClip (url1);
	      music[2] = JApplet.newAudioClip (url2);
	      music[3] = JApplet.newAudioClip (url3);

	      JLabel titleLabel = new JLabel ("“Ù¿÷≤•∑≈∆˜");
	      titleLabel.setAlignmentX (Component.CENTER_ALIGNMENT);

	      // Create the list of strings for the combo box options
	      String[] musicNames = {"«Î—°‘Ò“ª ◊∏Ë...", "Maroon 5 - Moves Like Jagger",
	               "Everglow", "Hello"};

	      musicCombo = new JComboBox (musicNames);
	      musicCombo.setAlignmentX (Component.CENTER_ALIGNMENT);

	      //  Set up the buttons
	      playButton = new JButton ("Play");
	      playButton.setBackground (Color.white);
	      stopButton = new JButton ("Stop");
	      stopButton.setBackground (Color.white);

	      JPanel buttons = new JPanel();
	      buttons.setLayout (new BoxLayout (buttons, BoxLayout.X_AXIS));
	      buttons.add (playButton);
	      buttons.add (Box.createRigidArea (new Dimension(15,0)));
	      buttons.add (stopButton);
	      buttons.setBackground (Color.lightGray);

	      //  Set up this panel
	      setPreferredSize (new Dimension (300, 100));
	      setBackground (Color.lightGray);
	      setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
	      add (Box.createRigidArea (new Dimension(0,5)));
	      add (titleLabel);
	      add (Box.createRigidArea (new Dimension(0,5)));
	      add (musicCombo);
	      add (Box.createRigidArea (new Dimension(0,5)));
	      add (buttons);
	      add (Box.createRigidArea (new Dimension(0,5)));

	      musicCombo.addActionListener (new ComboListener());
	      stopButton.addActionListener (new ButtonListener());
	      playButton.addActionListener (new ButtonListener());

	      current = null;
	   }

	   private class ComboListener implements ActionListener
	   {
	      public void actionPerformed (ActionEvent event)
	      {
	         if (current != null)
	            current.stop();

	         current = music[musicCombo.getSelectedIndex()];
	      }
	    }

	   private class ButtonListener implements ActionListener
	   {
	      public void actionPerformed (ActionEvent event)
	      {
	         if (current != null)
	            current.stop();

	         if (event.getSource() == playButton)
	            if (current != null)
	               current.play();
	      }
	   }
}
