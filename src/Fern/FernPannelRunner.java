package Fern;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FernPannelRunner extends JApplet implements ActionListener
{
  private final int APPLET_WIDTH = 1280;
  private final int APPLET_HEIGTH = 1024;
  
  private final int MIN = 1, MAX = 100;
  
  private JButton increase, decrease;
  private JLabel titleLabel, orderLabel;
  private FernPanel fern;
  private JPanel appletPanel, tools;
  
  public void init()
  {
    tools = new JPanel();
    tools.setLayout(new BoxLayout(tools, BoxLayout.X_AXIS));
    tools.setBackground(Color.YELLOW);
    tools.setOpaque(true);
    
    titleLabel = new JLabel("Fern");
    titleLabel.setForeground(Color.BLACK);
    
    increase = new JButton(new ImageIcon("increase.jpg"));
    increase.setPressedIcon(new ImageIcon("increasePressed.jpg"));
    increase.setMargin(new Insets(0, 0, 0, 0));
    increase.addActionListener(this);
    decrease = new JButton(new ImageIcon("decrease.jpg"));
    decrease.setPressedIcon(new ImageIcon("decreasePressed.jpg"));
    decrease.setMargin(new Insets(0, 0, 0, 0));
    decrease.addActionListener(this);
    
    orderLabel = new JLabel("Order: 1");
    orderLabel.setForeground(Color.BLACK);
    
    tools.add(titleLabel);
    tools.add(Box.createHorizontalStrut(20));
    tools.add(decrease);
    tools.add(increase);
    tools.add(Box.createHorizontalStrut(20));
    tools.add(orderLabel);
    
    fern = new FernPanel(1);
    
    appletPanel = new JPanel();
    appletPanel.add(tools);
    appletPanel.add(fern);
    
    getContentPane().add(appletPanel);
    
    setSize(APPLET_WIDTH, APPLET_HEIGTH);
  }
  
  public void actionPerformed(ActionEvent event)
  {
    int length = fern.getLength();
    
    if(event.getSource() == increase)
      length++;
    else
      length--;
 
    if(length >= MIN && length <= MAX)
    {
      orderLabel.setText("Order: " + length);
      fern.setLength(length);
      repaint();
    }
  }
}