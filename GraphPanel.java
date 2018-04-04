package graph;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
// To create a graph panel 
public class GraphPanel extends JPanel {
	public void paint(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawLine(300, 0, 300, 600);
		g.drawLine(0,300, 600, 300);

	}
	
}
	


