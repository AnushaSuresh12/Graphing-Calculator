package graph;
import java.util.Stack;


public class EquationEvaluator 
{
	 // Infix to postfix conversion for the given input function
	
	public Double Calculator(String expression)
		{
		 Stack<Double> variables = new Stack<Double>();
		 Stack<Character> operators= new Stack<Character>();
		 
		// convert the function to String array to determine the number
		String[] function= expression.split(" ");
		
		//convert the function to char array to perform infix to postfix evaluation
		char[] equation= expression.toCharArray(); 
		
		// to determine the numbers and put into the variable stack
		for (int i=0;i<function.length;i++)
		{
			if(function[i].matches("^[0-9]+(\\.[0-9]{1,2})?$"))
				{
				StringBuffer sb= new StringBuffer();
				sb.append(function[i]);
				variables.push(Double.parseDouble(sb.toString()));
				}
			}
		
		// to determine the operators and push them into operators stack 
		for (int i=0;i<equation.length;i++)
		{ 
				if(equation[i]==' ')
				continue;
			if(equation[i]=='p' || equation[i]=='e')
		{
			StringBuffer s2= new StringBuffer();
			if(equation[i]=='e')
				s2.append(Math.E);
			if(equation[i]=='p')
				s2.append(Math.PI);
			variables.push(Double.parseDouble(s2.toString()));
		}
		else if(equation[i]=='(')
		{
			operators.push(equation[i]);
		}
		else if(equation[i]==')')
		{
			while(operators.peek()!='(')
				variables.push(evaluate(operators.pop(),variables.pop(),variables.pop()));
			operators.pop();
			
		}
			
		else if (equation[i] == '+' || equation[i] == '-' || equation[i]=='^'|| equation[i]=='v'||
                equation[i] == '*' || equation[i] == '/'||equation[i]=='s'||equation[i]=='c'||equation[i]=='t'||equation[i]=='l')
       {
           while (!operators.empty() && precedence(equation[i], operators.peek()))
           	variables.push(evaluate(operators.pop(), variables.pop(), variables.pop()));
           operators.push(equation[i]);
       }
		}

   while (!operators.empty()) {
   	 if (operators.peek()=='s'||operators.peek()=='c'||operators.peek()=='t'||operators.peek()=='l'||operators.peek()=='v'||operators.peek()=='-')
       	variables.push(evaluate(operators.pop(),variables.pop(),0.0));
   	else
   		 variables.push(evaluate(operators.pop(), variables.pop(), variables.pop()));
     
   
   }

   
   return variables.pop();
	}	
	// to check the precedence 
	private boolean precedence(char op1, char op2) {
		if(op2=='+' || op1=='-')
			return false;
		  if (op2 == '(' || op2 == ')')
	            return false;
	        if((op1=='^'|| op1== 'v') && (op2=='+' || op2=='-'))
	        	return false;
	        if ((op1=='^' || op1=='v') && (op2=='*' || op2=='/'))
	        	return false;
	        	
	        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
	            return false;
	        if((op1=='s'||op1=='c'||op1=='t'||op1=='l') && (op2=='+'||op2=='-'||op2=='*'||op2=='/'))
	        	return false;
	        else
	            return true;
		
	}
	// to calculate the output
	private Double evaluate(Character op, Double b, Double a) {
		switch (op)
        {
        case '+':
            return a + b;
        case '-':
        {if (a==0)
        	return 0-b;
        else
            return a - b;
        }
        case '*':
            return a * b;
        case '/':
            if (b == 0)
            {
            	return 0.0;
            }
            return a / b;
        case '^':
        	return Math.pow(a, b);
        case 'v':
        	return Math.sqrt(b);
        case 's':
        	return  Math.sin(b);
        case 'c':
        	return Math.cos(b);
        case 't':
        	return Math.tan(b);
        case 'l':
        	return Math.log(b);
        }
        return null;
    }
	
}


	
