import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FoodOptionsPane {
	private JFrame frame;  
	public FoodOptionsPane(String food){  
	    frame=new JFrame("Food List");
	    frame.setAlwaysOnTop(true);
	    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    JOptionPane.showMessageDialog(frame, food);  
	}  
}
