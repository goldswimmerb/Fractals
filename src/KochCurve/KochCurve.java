package KochCurve;


import java.awt.*;

import javax.swing.JPanel;

public class KochCurve extends JPanel {
	private final int PW = 400;
	private final int PH = 400;
	
	private final double SQ = Math.sqrt(3.0)/6;
	
	private final int LX = 25, LY = 300;
	private final int RX = 375, RY = 300;
	
	private int current;
	
	
	
	public KochCurve(int currentOrder){
		current = currentOrder;
		setBackground(Color.white);
		setPreferredSize(new Dimension(PW,PH));
	}
	
	public void drawCurve(int order, double x1, double y1, double x5, double y5, Graphics page){
		if(order ==1)
			page.drawLine((int)x1, (int) y1, (int)x5, (int)y5);
			else{
				
				 double deltaX, deltaY, x2,y2,x3,y3,x4,y4;
	
	
	deltaX = x5-x1;
	deltaY = y5-y1;
	
	x2 = x1+ deltaX/3;
	y2 = y1+deltaY/3;
	
	x3 = ((x1+x5)/2 -(Math.sqrt(3.0)/6)* (y1-y5));
	y3 = ((y1+y2)/2 -(Math.sqrt(3.0)/6) *(x5-x1));
	
	x4 = y5 -deltaX/3;
	y4 = y5 -deltaY/3;
	
	drawCurve(order-1,x1,y1,x2,y2,page);
	drawCurve(order-1,x2,y2,x3,y3,page);
	drawCurve(order-1,x3,y3,x4,y4,page);
	drawCurve(order-1,x4,y4,x5,y5,page);
			}
	}
	
	public void paintComponent(Graphics page){
		paintComponent(page);
		page.setColor(Color.black);
		
		drawCurve(current,LX,LY,RX,RY,page);
		
	}
	public void setOrder(int order){current = order;}
	
	public int getOrder(){return current;}
	
}
