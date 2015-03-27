package SquareCurve;

import java.awt.*;
import javax.swing.JPanel;

public class KochPanel extends JPanel{
  
  private final int PANEL_WIDTH = 1000;
  private final int PANEL_HEIGHT = 1000;
  private final double SQ = Math.sqrt(5.0)/6;
  private final int TOPX = 250, TOPY = 250;
  private final int LEFTX = 250, LEFTY = 700;
  private final int RIGHTX = 700, RIGHTY = 250;
  private final int BOTTOMX = 700, BOTTOMY = 700;
  private int current; //current order
  

  //sets the initial fractal order to the value specified
  public KochPanel(int currentOrder){
    current = currentOrder;
    setBackground (Color.white);
    setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
  }
  

  /*Draws the fractal recursively. Base case is an order of 1 for
  which a simple straight line is drawn. Otherwise three
  intermediate points are computed, and each line segment is
  drawn as a fractal.*/

  public void drawFractal (Graphics g, int order, int x1, int y1, int x5, int y5){
    
    int deltaX, deltaY, x2, y2, x3, y3, x4, y4;
    
    if(order == 1){ g.drawLine (x1, y1, x5, y5); }
    else{
      
      //calculates the distance between end points
      deltaX = x5 - x1;
      deltaY = y5 - y1;
      
      //calculates one third
      x2 = x1 + deltaX / 2; 
      y2 = y1 + deltaY / 2;
      
      //calculates the tip of the projection
      x3 = (int) ((x1+x5)/2 - (SQ) * (y1-y5)); 
      y3 = (int) ((y1+y5)/2 - (SQ) * (x5-x1));
      
      //calculates two thirds
      x4 = x1 + deltaX * 2/3;
      y4 = y1 + deltaY * 2/3;
      
      drawFractal(g, order-1, x1, y1, x2, y2);
      drawFractal(g, order-1, x2, y2, x3, y3);
      drawFractal(g, order-1, x3, y3, x4, y4);
      drawFractal(g, order-1, x4, y4, x5, y5);
    }
  }
  
  /*performs the initial calls to the drawFractal method; 
  one for each side of the square*/
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.black);
    drawFractal(g, current, TOPX, TOPY, LEFTX, LEFTY);
    drawFractal(g, current, LEFTX, LEFTY, BOTTOMX, BOTTOMY);
    drawFractal(g, current, RIGHTX, RIGHTY, TOPX, TOPY);
    drawFractal(g, current, BOTTOMX, BOTTOMY, RIGHTX, RIGHTY);
  }
  
  //sets the fractal order to the value specified
  public void setOrder (int order){
    current = order;
  }
  

  //returns the current order
  public int getOrder (){
    return current;
  }
}