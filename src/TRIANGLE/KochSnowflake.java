package TRIANGLE;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KochSnowflake extends JApplet implements ActionListener
{
   private final int APPLET_WIDTH = 1000;
   private final int APPLET_HEIGHT = 1000;

   private final int MIN = 1, MAX = 20;

   private JButton increase, decrease;
   private JLabel titleLabel, orderLabel;
   private kochPanel drawing;
   private JPanel appletPanel, tools;

   //sets up the components for the applet
   public void init()
   {
      tools = new JPanel ();
      tools.setLayout(new BoxLayout(tools, BoxLayout.X_AXIS));
      tools.setPreferredSize(new Dimension (APPLET_WIDTH, 40));
      tools.setBackground(Color.yellow);
      tools.setOpaque(true);

      titleLabel = new JLabel ("The Koch Snowflake");
      titleLabel.setForeground (Color.black);

      increase = new JButton (new ImageIcon ("increase.gif"));
      increase.setPressedIcon (new ImageIcon ("increasePressed.gif"));
      increase.setMargin (new Insets (0, 0, 0, 0));
      increase.addActionListener (this);

      decrease = new JButton (new ImageIcon ("decrease.gif"));
      decrease.setPressedIcon (new ImageIcon ("decreasePressed.gif"));
      decrease.setMargin (new Insets (0, 0, 0, 0));
      decrease.addActionListener (this);

      orderLabel = new JLabel ("Order: 1");
      orderLabel.setForeground (Color.black);

      tools.add (titleLabel);
      tools.add (Box.createHorizontalStrut (40));
      tools.add (decrease);
      tools.add (increase);
      tools.add (Box.createHorizontalStrut (20));
      tools.add (orderLabel);

      drawing = new kochPanel (1);

      appletPanel = new JPanel();
      appletPanel.add (tools);
      appletPanel.add (drawing);

      getContentPane().add (appletPanel);

      setSize (APPLET_WIDTH, APPLET_HEIGHT);
   }


   // determine which button was pushed, and set the new order if it is in range
   public void actionPerformed (ActionEvent event)
   {
      int order = drawing.getOrder();

      if (event.getSource() == increase) { order++; }
      else{
         order--;
      }

      if (order >= MIN && order <= MAX)
      {
         orderLabel.setText ("Order: " + order);
         drawing.setOrder (order);
         repaint();
      }
   }
}