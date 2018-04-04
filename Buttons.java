package graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons implements ActionListener 
{
	// create object for EquationEvaluator  
	EquationEvaluator eq= new EquationEvaluator();
	private static StringBuffer str= new StringBuffer();
	private Double temp;
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// ActionListener for ENTER button
		if(e.getActionCommand()=="ENTER")
		{
			temp=eq.Calculator(str.toString());
			if(temp==0.0)
			{
				CalcGUI.t3.setText("Invalid function");
			}
			else{
				CalcGUI.t3.setText(temp.toString());
			}
			System.out.println(temp);
			
		}
		// ActionListener for ANSWER button
		if(e.getActionCommand()=="ANSWER")
		{
			CalcGUI.t3.setText(temp.toString());
			str.append(temp);	
			System.out.println(str);
			}
		// ActionListener for Clear button
		if(e.getActionCommand()=="C")
		{
			CalcGUI.t3.setText(null);
			str.delete(0,str.length());
		}
		// ActionListener for the buttons
		String temp=e.getActionCommand();
		switch(temp)
		{
		case "9":
			str.append("9").toString();
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("9"));
			break;
		case "8":
			str.append("8");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("8"));
			break;
		case "7":
			str.append("7");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("7"));
			break;
		case "6":
			str.append("6");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("6"));
			break;
		case "5":
			str.append("5");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("5"));
			break;
		case "4":
			str.append("4");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("4"));
			break;
		case "3":
			str.append("3");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("3"));
			break;
		case "2":
			str.append("2");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("2"));
			break;
		case "1":
			str.append("1");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("1"));
			break;
		case "0":
			str.append("0");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("0"));
			break;
		case "sin":
			str.append("s");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("sin "));
			break;
		case "cos":
			str.append("c");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("cos"));
			break;
		case "tan":
			str.append("t");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("tan"));
			break;
		case "*":
			str.append(" * ");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("*"));
			break;
		case "+":
			str.append( " + ");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("+"));
			break;
		case "-":
			str.append(" - ");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("-"));
			break;
		case "/":
			str.append(" / ");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("/"));
			break;
		case "e":
			str.append("e");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat("e"));
			break;
		case "pi":
			str.append("p");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat(" pi "));
			break;
		case "ln":
			str.append("l");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat(" ln "));
			break;
		case ".":
			str.append(".");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat(" . "));
			break;
		case "sqt":
			str.append(" v ");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat(" sqt "));
			break;
		case "^":
			str.append(" ^ ");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat(" ^ "));
			break;
		case "(":
			str.append(" ( ");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat(" ( "));
			break;
		case ")":
			str.append(" ) ");
			CalcGUI.t3.setText(CalcGUI.t3.getText().concat(" ) "));
			break;
		}	
		
			
	}
}



	


