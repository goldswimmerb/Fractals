package KochCurve;

import java.awt.Graphics;

public class KochCurve {
	deltaX = x5-x1;
	deltaY = y5-y1;
	
	x2 = x1+ deltaX/3;
	y2 = y1+deltaY/3;
	
	x3 = ((x1+x5)/2 -(Math.sqrt(3.0)/6)* (y1-y5));
	y3 = ((y1+y2)/2 -(Math.sqrt(3.0)/6) *(x5-x1));
	
	public void paintComponent(Graphics g){
		paintComponent(g);
		super.g.setColor(Color.black)
	}
	
}
