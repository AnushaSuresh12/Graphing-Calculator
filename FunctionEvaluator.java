package graph;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;

public class FunctionEvaluator implements ActionListener{
	GraphPlotter eq= new GraphPlotter();
	Validatefunction eq1= new Validatefunction();
	Graphics g;
	String function="",x="",y="",temp="";
	int x1=10,y1=10,x2,y2;
	boolean validate=false;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Action Listener for the plot button
		if(e.getActionCommand()=="PLOT")
		{
			g=CalcGUI.GraphPanel.getGraphics();
			function=CalcGUI.t.getText();
			// the range is without parathensis eg: -10 , 10 and not [-10,10]
			 x=CalcGUI.t1.getText();
			 y=CalcGUI.t2.getText();
			CalcGUI.textarea.append("Plot: y=" + function + "\n");
			 String[] xvalue= x.split(",");
			 String[] yvalue= y.split(",");
			 Double Xmin= Double.parseDouble(xvalue[0]);
			 Double Xmax= Double.parseDouble(xvalue[1]);
			 Double ymin= Double.parseDouble(yvalue[0]);
			 Double ymax=Double.parseDouble(yvalue[1]);
			 
			 drawaxis(g,Xmax.intValue(),ymax.intValue());
			 // check whether the given range is correct or wrong
			 if((Math.abs(Xmin) != Xmax ) || (Math.abs(ymin) != ymax))
				 {
				 CalcGUI.t.setText("range not equal");
				 validate= false;
				 }
			 // Setting the color of the graph
			String s=(String)CalcGUI.comboBox.getSelectedItem();
			switch(s)
			{
			case "Red":
				g.setColor(Color.red);
				break;
			case "Blue":
				g.setColor(Color.BLUE);
				break;
			case "Green":
				g.setColor(Color.GREEN);
				break;
			default:
					g.setColor(Color.BLACK);
					break;
				
			}
			 x1= CalcGUI.GraphPanel.getWidth();
			 y1=CalcGUI.GraphPanel.getHeight();
			 
			 // check whether the given function is valid or not 
			 if(!eq1.validate(function))
			 {
				 CalcGUI.t.setText("Invalid function");
			 }
			 // if its valid then plot the graph
			 else {
				 
			int xScaled = x1/(2*Xmax.intValue());
			 
			int yScaled = y1/ (2*ymax.intValue());
			System.out.println(xScaled);
			System.out.println(yScaled);
			ArrayList<Integer> arrx = new ArrayList<Integer>();
			ArrayList<Integer> arry = new ArrayList<Integer>();
			for ( Double i= Xmin;i<=xScaled+1;i=i+0.1)
			{
				Double z = eq.solve(function, i.intValue());
				String temp =z.toString();
				if(!(temp.charAt(0)=='-'))
				{
					temp="-"+temp;
					
				}else {
					Double z1= Math.abs(Double.parseDouble(temp));
					temp=z1.toString();
				}
				Double y=Double.parseDouble(temp)*(y1/2)/ymax;
				int xval= (x1/2)+(i.intValue())*xScaled;
				int yval=(y1/2)+y.intValue();
				arrx.add(xval);
				arry.add(yval);
			}
				for(int j=0;j<arrx.size()-1;j++) {
					g.drawLine(arrx.get(j), arry.get(j), arrx.get(j+1), arry.get(j+1));
				}
			 
		}
		}
		
	// This clears the graph panel and repaints the graph with the co-ordinate axis
		if(e.getActionCommand()=="ERASE")
		{
			String temp=CalcGUI.t.getText();
			CalcGUI.textarea.append("Erase y= " + temp + "\n");
			CalcGUI.GraphPanel.repaint();
			
		}
// Action Listener for the load Button
		if(e.getActionCommand()=="LOAD")
		{
			String temp1= CalcGUI.textarea.getSelectedText();
			String[] var= temp1.split("=");
			CalcGUI.t.setText(var[1]);
		}
		
	}
		
	// when even plot is clicked the panel should be erased and grids should be drawn 
	public void drawaxis(Graphics g, int xSize, int ySize) 
	{
				g.clearRect(0, 0, x1,y1 );
				g.setColor(Color.BLACK);
				g.drawLine(300, 0, 300, 600);				
				g.drawLine(0,300, 600, 300);
				g.drawString("-"+String.valueOf(xSize), 1, 299);
				g.drawString(String.valueOf(xSize), 585, 299);
				g.drawString(String.valueOf(ySize), 301, 10);
				g.drawString("-"+String.valueOf(ySize), 301, 600);
	}
}


