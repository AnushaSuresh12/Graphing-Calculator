package graph;

import java.awt.Color;
import java.awt.GridLayout;





import javax.swing.*;


public class CalcGUI {
	// create the frame, textfield and buttons
	private JFrame frame;
	protected static JComboBox comboBox;
	protected static JTextField t;
	protected static JTextArea textarea;
	protected static JTextField t1;
	protected static JTextField t2;
	protected static JTextField t3;
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,plot,erase,load,answer,enter,add,mul,sub,div,sqt,pwr,exp,pi,sin,cos,tan,log,open,close,dot,clear;
	protected static JPanel GraphPanel;
	protected static String[] colors= {"Color","Blue","Green","Red"};
	// Constructor of the CalcGUI
	public CalcGUI() {
		
		initialize();
	}
	// Creation of the GUI of the Calculator
	private void initialize() {
		// create object of button class
		Buttons a = new Buttons();
		FunctionEvaluator func= new FunctionEvaluator();
		setFrame(new JFrame("Graph Calculator!"));
		getFrame().setBounds(100, 100, 1089, 713);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(659, 11, 419, 669);
		getFrame().getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEquation = new JLabel("Equation:-");
		lblEquation.setBounds(171, 23, 82, 14);
		panel.add(lblEquation);
		
		JLabel lblYFx = new JLabel("y = f(x) =");
		lblYFx.setBounds(54, 59, 68, 14);
		panel.add(lblYFx);
		
		t = new JTextField();
		t.setBounds(115, 56, 244, 20);
		panel.add(t);
		t.setColumns(10);

		JLabel lblXAxis = new JLabel("x- axis:-");
		lblXAxis.setBounds(54, 100, 46, 14);
		panel.add(lblXAxis);
		
		t1 = new JTextField();
		t1.setBounds(115, 97, 244, 20);
		panel.add(t1);
		t1.setColumns(10);
		JLabel lblYAxis = new JLabel("y- axis:-");
		lblYAxis.setBounds(54, 136, 46, 14);
		panel.add(lblYAxis);
		
		t2 = new JTextField();
		t2.setBounds(115, 133, 244, 20);
		panel.add(t2);
		t2.setColumns(10);
		
		plot = new JButton("PLOT");
		plot.setBounds(97, 161, 89, 23);
		panel.add(plot);
		plot.addActionListener(new FunctionEvaluator());


		erase = new JButton("ERASE");
		erase.setBounds(229, 164, 89, 23);
		panel.add(erase);
		erase.addActionListener(new FunctionEvaluator());
		
		
		JLabel lblSelectColor = new JLabel("Select Color:-");
		lblSelectColor.setBounds(82, 213, 82, 14);
		panel.add(lblSelectColor);
		
		comboBox = new JComboBox(colors);
		comboBox.setBounds(171, 210, 68, 20);
		panel.add(comboBox);
		comboBox.setSelectedItem(func);
		
		
		JLabel lblHistory = new JLabel("History:-");
		lblHistory.setBounds(97, 249, 46, 14);
		panel.add(lblHistory);
		
		textarea = new JTextArea();
		textarea.setBounds(152, 249, 117, 100);
		panel.add(textarea);
		
		load = new JButton("LOAD");
		load.setBounds(152, 366, 89, 23);
		panel.add(load);
		load.addActionListener(new FunctionEvaluator());
		
		t3 = new JTextField();
		t3.setBounds(0, 400, 404, 20);
		panel.add(t3);
		t3.setColumns(10);
		t3.addActionListener(a);
		
		// Creation of ButtonPanel
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 431, 404, 161);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(4, 6, 1, 1));
	
		b1 = new JButton("9");
		panel_2.add(b1);
		b1.addActionListener(a);	
		
		b2 = new JButton("8");
		panel_2.add(b2);
		b2.addActionListener(a);
		
		b3 = new JButton("7");
		panel_2.add(b3);
		b3.addActionListener(a);
		
		add = new JButton("+");
		panel_2.add(add);
		add.addActionListener(a);
		
		pwr = new JButton("^");
		panel_2.add(pwr);
		pwr.addActionListener(a);
		
		sin = new JButton("sin");
		panel_2.add(sin);
		sin.addActionListener(a);
		
		b4 = new JButton("6");
		panel_2.add(b4);
		b4.addActionListener(a);
		
		b5 = new JButton("5");
		panel_2.add(b5);
		b5.addActionListener(a);
		
		b6 = new JButton("4");
		panel_2.add(b6);
		b6.addActionListener(a);
		
		sub = new JButton("-");
		panel_2.add(sub);
		sub.addActionListener(a);
		
		sqt = new JButton("sqt");
		panel_2.add(sqt);
		sqt.addActionListener(a);
		
		cos = new JButton("cos");
		panel_2.add(cos);
		cos.addActionListener(a);
		
		b7= new JButton("3");
		panel_2.add(b7);
		b7.addActionListener(a);
		
		b8 = new JButton("2");
		panel_2.add(b8);
		b8.addActionListener(a);
		
		b9 = new JButton("1");
		panel_2.add(b9);
		b9.addActionListener(a);
		
		div = new JButton("/");
		panel_2.add(div);
		div.addActionListener(a);
		
		exp = new JButton("e");
		panel_2.add(exp);
		exp.addActionListener(a);
		
		tan= new JButton("tan");
		panel_2.add(tan);
		tan.addActionListener(a);
		
		dot = new JButton(".");
		panel_2.add(dot);
		dot.addActionListener(a);
		
		b0= new JButton("0");
		panel_2.add(b0);
		b0.addActionListener(a);
		
		clear = new JButton("C");
		panel_2.add(clear);
		clear.addActionListener(a);
		
		mul = new JButton("*");
		panel_2.add(mul);
		mul.addActionListener(a);
		
		pi = new JButton("pi");
		panel_2.add(pi);
		pi.addActionListener(a);
		
		log = new JButton("ln");
		panel_2.add(log);
		log.addActionListener(a);
		
		open = new JButton("(");
		open.setBounds(134, 603, 46, 23);
		panel.add(open);
		open.addActionListener(a);
		
		close = new JButton(")");
		close.setBounds(201, 603, 52, 23);
		panel.add(close);
		close.addActionListener(a);
		
		answer = new JButton("ANSWER");
		answer.setBounds(97, 637, 89, 23);
		panel.add(answer);
		answer.addActionListener(a);
		
		enter = new JButton("ENTER");
		enter.setBounds(211, 637, 89, 23);
		panel.add(enter);
		enter.addActionListener(a);
		
		// Graph Panel 
		GraphPanel = new GraphPanel();
		GraphPanel.setBackground(Color.WHITE);
		GraphPanel.setBounds(10, 11, 600, 600);
		frame.getContentPane().add(GraphPanel);
		GraphPanel.setBorder(BorderFactory.createLineBorder(Color.black));
} 
	
	// getters and setters for the frame
public JFrame getFrame() {
	return frame;
}

public void setFrame(JFrame frame) {
	this.frame = frame;
}


}