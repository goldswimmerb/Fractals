package TRIANGLE;

import java.awt.*;
import javax.swing.JPanel;

public class kochPanel extends JPanel
{
 private final int PANEL_WIDTH = 1000;
 private final int PANEL_HEIGHT = 1080;
 private final double SQ = Math.sqrt(3.0) / 6;
 private final int TOPX = 500, TOPY = 140;
 private final int LEFTX = 220, LEFTY = 700;
 private final int RIGHTX = 780, RIGHTY = 700;
 private int current; // current order
 
public kochPanel (int currentOrder)
 {
 current = currentOrder;
 setBackground (Color.white);
 setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
 }
 

 public void drawFractal (Graphics g, int order, int x1, int y1, int x5, int y5)
 {
   
 int deltaX, deltaY, x2, y2, x3, y3, x4, y4;
 
 //base case draw a line
 if (order == 1) { g.drawLine (x1, y1, x5, y5); }
 else
 {
   
 //difference in length
 deltaX = x5 - x1; 
 deltaY = y5 - y1; 
 
 // one third
 x2 = x1 + deltaX / 3; 
 y2 = y1 + deltaY / 3;
 
 // tip of projection
 x3 = (int) ((x1+x5)/2 + (Math.sqrt(2.0) / 6) * (y1-y5)*2); 
 y3 = (int) ((y1+y5)/2 + (Math.sqrt(2.0) / 6) * (x5-x1)*2);
 
 // two thirds
 x4 = x1 + deltaX * 2/3; 
 y4 = y1 + deltaY * 2/3;
 
 drawFractal (g, order-1, x1, y1, x2, y2);
 drawFractal (g, order-1, x2, y2, x3, y3);
 drawFractal (g, order-1, x3, y3, x4, y4);
 drawFractal (g, order-1, x4, y4, x5, y5);
 }
 }
 

 public void paintComponent (Graphics g)
 {
 super.paintComponent(g);
 g.setColor (Color.black); 
 //draws left side of triangle
 drawFractal (g, current, TOPX, TOPY, LEFTX, LEFTY);
 //draws bottom of triangle
 drawFractal (g, current, LEFTX, LEFTY, RIGHTX, RIGHTY);
 //draws right side of triangle
 drawFractal (g, current, RIGHTX, RIGHTY, TOPX, TOPY);
 }
 

 public void setOrder (int order)
 {
 current = order;
 }
 

 public int getOrder ()
 {
 return current;
 }
}