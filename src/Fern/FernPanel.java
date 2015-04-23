package Fern;

import java.awt.*;

import javax.swing.JPanel;

public class FernPanel extends JPanel {

	// size of the window
	private final int HEIGHT = 1280, WIDTH = 1024;
	// start position of the line
	private final int STARTX = 640, STARTY = 800;
	// in radians
	private final double START_ANGLE = Math.PI / 2;
	// the length of the first part of the stem
	private final int START_LENGTH = 150;

	/*
	 * points down the initial stem where each of the subferns will be placed
	 */
	private final double LEFT_PART = 0.6;
	private final double RIGHT_PART = 0.8;

	/*
	 * how much each line will be shortened with each subfern these should be
	 * greater than 0 and less than 1
	 */
	private final double LEFT_DECREASE = 0.6;
	private final double RIGHT_DECREASE = 0.5;
	private final double UP_DECREASE = .7;

	/* The angle change from the stem for both left and right sides of the fern */
	// this should be possitive
	private final double LEFT_ANGLE = (Math.PI * 2) / 12;
	private final double RIGHT_ANGLE = (Math.PI * 2) / 10;
	// the amount of angle change by going one section up the stem
	private final double UP_ANGLE = (Math.PI * 2) / 48;
	private int times;// how many sections the main fern will have

	public FernPanel(int length) {
		setBackground(Color.white);
		setPreferredSize(new Dimension(HEIGHT, WIDTH));
		times = length;
	}

	int i = 0;
	int j = 50;
	int k = 100;

	public void drawFern(int branches, double length, double angle, double x1, double y1, Graphics page)
  {
		
		
			
			i++;
			i++;
			j++;
			k++;
			page.setColor(new Color(i%200,i%100,k%200,255));
		
    if(branches >= 1)
    {
      while(angle > Math.PI/3)
        angle = (Math.PI * -1) + (angle - Math.PI);
      while(angle < Math.PI/-3)
        angle = Math.PI + (angle + Math.PI);
      
      double deltaY = Math.sin(angle) * length;
      double deltaX = Math.sqrt(Math.pow(length, 2) - Math.pow(deltaY, 2));
      if(angle < START_ANGLE && angle > START_ANGLE * -1)
        deltaX *= -1;
      
      double x2 = x1 + deltaX;
      double y2 = y1 - deltaY;
      
      page.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
      
      double xLeft, yLeft, xRight, yRight;
      xLeft = x1 + (deltaX * LEFT_PART);
      xRight = x1 + (deltaX * RIGHT_PART);
      yLeft = y1 - (deltaY * LEFT_PART);
      yRight = y1 - (deltaY * RIGHT_PART);
      
      if(branches > 5)
      {
        drawFern(5, length*LEFT_DECREASE, angle-LEFT_ANGLE, xLeft, yLeft, page);
        drawFern(5, length*RIGHT_DECREASE, angle+RIGHT_ANGLE, xRight, yRight, page);
      }
      else
      {
        drawFern(branches-1, length*LEFT_DECREASE, angle-LEFT_ANGLE, xLeft, yLeft, page);
        drawFern(branches-1, length*RIGHT_DECREASE, angle+RIGHT_ANGLE, xRight, yRight, page);
      }
      drawFern(branches-1, length*UP_DECREASE, angle+UP_ANGLE, x2, y2, page);
    }
  }

	/*
	 * public void paintComponent(Graphics page) { super.paintComponent(page);
	 * 
	 * page.setColor(Color.BLACK);
	 * 
	 * drawFern(times, START_LENGTH, START_ANGLE, STARTX, STARTY, page); }
	 */

	public int getLength() {
		return times;
	}

	public void setLength(int length) {
		times = length;
	}

	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		// g.setColor(Color.black); //tree color
		// drawTree(g, 250, 400, -90, 15); //xPos, yPos, vertical, levels
		for (int i = 640; i < 800; i++) {
			// System.out.println(840-i);
			drawFern(times, START_LENGTH, START_ANGLE, STARTX, STARTY, page); /*
																			 * xPos,
																			 * yPos
																			 * ,
																			 * vertical
																			 * ,
																			 * levels
																			 */
		}

	}
}