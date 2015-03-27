package KochCurve;
import javax.swing.JApplet;
import javax.swing.JPanel;



public class FractalTreeRunner extends JApplet {
	
	private final int A_W = 1920; // Width of window
	private final int A_H = 1080; //Height of window
	
	private KochCurve graphic; //Instance of Fractal
	private JPanel appletPanel;// instance of internal Panel
	
	public void init(){
		graphic = new KochCurve(1);
		appletPanel = new JPanel();
		appletPanel.add(graphic);
		getContentPane().add(appletPanel);
		setSize(1920, 1080);
	}

}
