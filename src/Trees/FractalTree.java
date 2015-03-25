package Trees;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class FractalTree extends JPanel {
	public FractalTree(int PANEL_WIDTH,int PANEL_HEIGHT ){
		setBackground(Color.white);
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
	}
	Graphics g2d ;
//Recursive Method
	int i = 0;
	int j = 50;
	int k = 100;
	private void drawTree(Graphics g, int x1, int y1, double angle, int depth){
		if(depth ==0){return;}
		int x2 = x1+(int)(Math.cos(Math.toRadians(angle))* depth * 9);//left side
		i++;
		j++;
		k++;
		int y2 = y1+(int)(Math.sin(Math.toRadians(angle))* depth * 9) ;//right side
		g.drawLine(x1,  y1,  x2,  y2);//base of tree
		
		drawTree(g, x2 ,y2, angle -9, depth -1); //Left side of tree
		drawTree(g, x2, y2, angle + 30, depth -1);//right side of tree
		g.setColor(new Color(i%200,i%100,k%200,255));
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.setColor(Color.black); //tree color
		//drawTree(g, 250, 400, -90, 15); //xPos, yPos, vertical, levels
		for(int i = 640; i < 800; i++){
			//System.out.println(840-i);
		drawTree(g, i, 700, -90, 12); /*xPos, yPos, vertical, levels*/}
		
	}
}
