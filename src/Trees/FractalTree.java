package Trees;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class FractalTree extends JPanel {
	public FractalTree(int PANEL_WIDTH,int PANEL_HEIGHT ){
		setBackground(Color.white);
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
	}
//Recursive Method
	private void drawTree(Graphics g, int x1, int y1, double angle, int depth){
		if(depth ==0){return;}
		int x2 = x1+(int)(Math.cos(Math.toRadians(angle))* depth * 5);//left side
		int y2 = y1+(int)(Math.sin(Math.toRadians(angle))* depth * 5);//right side
		g.drawLine(x1,  y1,  x2,  y2);//base of tree
		drawTree(g, x2 ,y2, angle -30, depth -1); //Left side of tree
		drawTree(g, x2, y2, angle+ 30, depth -1);//right side of tree

	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black); //tree color
		//drawTree(g, 250, 400, -90, 15); //xPos, yPos, vertical, levels
		drawTree(g, 960, 540, -90, 21); //xPos, yPos, vertical, levels
	}
}
