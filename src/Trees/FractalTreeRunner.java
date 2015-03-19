package Trees;
import javax.swing.JApplet;
import javax.swing.JPanel;

public class FractalTreeRunner extends JApplet {
	
	private final int A_W = 2000; // Width of window
	private final int A_H = 2000; //Height of window
	
	private FractalTree graphic; //Instance of Fractal
	private JPanel appletPanel;// instance of internal Panel
	
	public void init(){
		graphic = new FractalTree(A_W,A_H);
		appletPanel = new JPanel();
		appletPanel.add(graphic);
		getContentPane().add(appletPanel);
		setSize(A_W, A_H);
	}

}
