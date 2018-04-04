package graph;

import java.awt.EventQueue;
// Main Class
public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					// Create the GUI 
					CalcGUI window = new CalcGUI();
					window.getFrame().setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
