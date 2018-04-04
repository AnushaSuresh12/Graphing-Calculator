package graph;

import java.util.LinkedList;
import java.text.DecimalFormat;
// This class plots the graph for the given function
public class GraphPlotter
{
   private String input,output,Precision_str;
   private int  precision=16;
   private double xValue;
   private final char pi='p',e='e', sin='s',cos='c',tan='t',ln='l',sqr='q',x='x';
   
   //constructor for GraphPlotter
   public GraphPlotter()
   {
       setPrecision(precision);
   }
   
   //solve the function
   public double solve(String function,int i)
   {
       input=function;
       xValue=i;
       //cleanse input
       purify();
       //remove parentheses
       removePars();
       //return final result
       output=toString(evaluate(input+"="));
       return Double.parseDouble(output);
   }
   // this removes the paratheses
   private void removePars()
   {
       try{
       String inPars;
       boolean closepars=false;
       int beginPars=0, endPars=0;
       while(beginPars!=-1&&endPars!=-1)
       {
           closepars=false;
           beginPars=input.indexOf("(");
           endPars=beginPars;
           if (beginPars!=-1)
           {
           while(closepars==false)
           {
               endPars++;
               switch(input.charAt(endPars))
               {
                   case '(':
                       beginPars=endPars;
                       break;
                   case ')':
                       closepars=true;
                       break;
               }
           }
           inPars=input.substring(beginPars+1,endPars);
           //Calculate the value with in the parathensis
           input=input.substring(0,beginPars)+evaluate(inPars+"=")+input.substring(endPars+1,input.length());
           noMultipleNegatives();
           }
       }
       }catch(Exception e)
       {
           input="NaN";
       }
   }

   // this adds paranthesis if needed
   private void addPars()
   {
	   int beginParCount=0, endParCount=0;
	   for (int i=0;i<input.length();i++)
	   {
               switch (input.charAt(i))
		{
		case '(':
                    beginParCount+=1;
                    break;
		case ')':
                    endParCount+=1;
                    break;
		}
	   }
	   if (endParCount<beginParCount)
	   {
               for (int i=0;i<(beginParCount-endParCount);i++)
               {
                   input+=")";
	       }
	   }
   }
   
   // this evaluates the output 
   public double evaluate(String function)
   {
       try{
       int i=0; char index; String Num="";
       LinkedList<Double> Nums = new LinkedList<Double>();
       LinkedList<Character> Ops = new LinkedList<Character>();
       do
       {
           index=function.charAt(i);
           i++;
           switch (index)
           {
           // if it is a number 
               case '0':
               case '1':
               case '2':
               case '3':
               case '4':
               case '5':
               case '6':
               case '7':
               case '8':
               case '9':
               case '.':
               case sin:
               case cos:
               case tan:
               case 'e':
                   Num+=index;
                   break;
               //if it is an operator:
               case '+':
               case '-':
               case '*':
               case '/':
               case '^':
                   if (Num.length()!=0&&confirmNegative(Num,function,i))
                   {
                       Nums.add(parseNumber(Num));
                       Num="";
                       Ops.add(index);
                   }else{
                       if (index=='-')
                       Num+='-';
                   }
                   break;
               case '=':
                   Nums.add(parseNumber(Num));
           }
       }while(i<function.length());

       double result=Nums.get(0);
       Nums.remove(0);
       for (char a:Ops)
       {
           switch (a)
           {
               case '+':
                   result+=Nums.get(0);
                   Nums.remove(0);
                   break;
               case '-':
                   result-=Nums.get(0);
                   Nums.remove(0);
                   break;
               case '*':
                   result*=Nums.get(0);
                   Nums.remove(0);
                   break;
               case '/':
                   result/=Nums.get(0);
                   Nums.remove(0);
                   break;
               case '^':
                   result=Math.pow(result,Nums.get(0));
                   Nums.remove(0);
                   break;
           }
       }
       DecimalFormat DForm = new DecimalFormat(getPrecisionString());
       result=Double.valueOf(DForm.format(result));
       return result;
       }catch(Exception e)
       {
           return Math.sqrt(-1);
       }
   }
   private double parseNumber(String Num)
   {
       double result=0;
       DecimalFormat DForm = new DecimalFormat(getPrecisionString());
       try{
       switch(Num.charAt(0))
       {
           //negative inside sin, cos, tan, log, ...etc
           case '-':
               result=negativeFunction(Num);
               break;
           case sin:
               Num=Num.substring(1,Num.length());
               result= Math.sin(0.4 * Double.parseDouble( Num));
               break;
           case cos:
               Num=Num.substring(1,Num.length());
               result=  Math.cos(0.4 * Double.parseDouble(Num));

               break;
           case tan:
               Num=Num.substring(1,Num.length());
               result= Math.tan(0.4 * Double.parseDouble(Num));
               break;
           case ln:
               Num=Num.substring(1,Num.length());
               result=Math.log(Double.parseDouble(Num));
               break;
           case sqr:
               Num=Num.substring(1,Num.length());
               result=Math.sqrt(Double.parseDouble(Num));
               break;


           default:
               result=Double.parseDouble(Num);
               break;
       }
       result=Double.valueOf(DForm.format(result));
       }
       catch(Exception e)
       {
          return Math.sqrt(Double.parseDouble("-1"));
       }
       return result;
   }
   // if it is sin(-1)
   private double negativeFunction(String Num)
   {
       double result=0;
       switch (Num.charAt(1))
               {
                   case sin:
                   case cos:
                   case tan:
                   case ln:
                   case sqr:

                       Num=""+parseNumber(Num.substring(1,Num.length()))*-1;
                       result=Double.parseDouble(Num);
                       break;
                   default:
                       result=Double.parseDouble(Num);
                       break;
               }
       return result;
   }

   private boolean confirmNegative(String Num,String function,int i)
   {
        boolean result=false;if
       (function.charAt(i-2)!=sin && function.charAt(i-2)!=cos &&  function.charAt(i-2)!=tan && function.charAt(i-2)!=ln && function.charAt(i-2)!=sqr && function.charAt(i-2)!='e')
        {
            result=true;
        }
        return result;
    }

   private void addTimesChar()
   {
       int i=0;char index,lastItem='X';
       do
       {
           index=input.charAt(i);
           i++;
           switch (index)
           {
               //if it's a number or decimal:
               case '0':
               case '1':
               case '2':
               case '3':
               case '4':
               case '5':
               case '6':
               case '7':
               case '8':
               case '9':
               case '.':               
                   if(lastItem==')') {
                       input=input.substring(0,i-1)+"*"+input.substring(i-1,input.length());
                       i++;
                   }
                   lastItem='N';
                   break;

               case '+':
               case '-':
               case '*':
               case '/':
               case '^':
                   lastItem='O';
                   break;
               case '(':
               case sin:
               case cos:
               case tan:
               case ln:
               case sqr:
                   if (lastItem=='N'||lastItem==')')
                   {
                       input=input.substring(0,i-1)+"*"+input.substring(i-1,input.length());
                       i++;lastItem='X';
                   }
                   break;
               case ')':
                   lastItem=')';
                   break;
           }
       }while(i<input.length());
   }
   private void removeConstantsandVars()
   {
       int i=0;char index,lastItem='X';
       try{
       do
       {
           index=input.charAt(i);
           i++;
           switch (index)
           {
               //if it's a number or decimal:
               case '0':
               case '1':
               case '2':
               case '3':
               case '4':
               case '5':
               case '6':
               case '7':
               case '8':
               case '9':
               case '.':
                   if (lastItem=='C')
                   {
                       input=input.substring(0,i-1)+"*"+input.substring(i-1,input.length());
                       i++;
                   }
                   lastItem='N';
                   break;
               //if it's an operator:
               case '+':
               case '-':
               case '*':
               case '/':
               case '^':
                   lastItem='O';
                   break;
               case pi:
               case e:
               case x:
                   if (lastItem=='N')
                   {
                       input=input.substring(0,i-1)+"*"+input.substring(i-1,input.length());
                       i++;
                   }
                   lastItem='C';
                   break;
           }
       }while(i<input.length());
           //replace Constants with their correspoding numbers
	   input=input.replace(Character.toString(pi),"3.141592653589793");
	   input=input.replace(Character.toString(e),"2.718281828459045");
           //Replace sequences of Xs. ie xxx => x*x*x
           for(int k=0; k<2; k++)
           input=input.replaceAll("xx", "x*x");           
           //replace x with its value
           input=input.replace(Character.toString(x),Double.toString(xValue));           
       }catch(Exception e)
       {
	   input="NaN";
       }
   }
   //remove all multiple and nested negative signs. example: --------2 yields 2.0
    private void noMultipleNegatives()
   {
        char index;        
        int minusCount=0;
        for (int i=0;i<input.length();i++)
        {
            index=input.charAt(i);
            switch (index)
            {
                case '-':
                    minusCount++;
                    if (minusCount>1)
                    {
                        input=input.replace("--","+");
                        input=input.replace("-(-","+");
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '.':
                case sin:
                case cos:
                case tan:
                case ln:
                case sqr:
                case pi:
                case e:
                case x:
                    minusCount=0;
            }
        }
    }
   private String toString(double number)
   {
	   String result="";
	   if (Double.toString(number).equals("NaN")||Double.toString(number).equals("Infinity"))
	   {
		   result="Error";
	   }else{
		   result=Double.toString(number);
                   //if it's an integer, remove ".0"
                   if (result.substring(result.length()-2,result.length()).equals(".0"))
                   {
                       result=result.substring(0,result.length()-2);
                   }
                   //get rid of negative zero
                   if (result.equals("-0"))
                   {
                       result="0";
                   }
	   }
	   return result;
   }   
   private void purify()
   {
       convert();
       noMultipleNegatives();
       addPars();
       removeConstantsandVars();
       addTimesChar();
       noMultipleNegatives();
   }
   private void convert()
   {
       input=input.replace(" ","");
       input=input.replace(")x",")*x");
       input=input.replace("sin(","s(");
       input=input.replace("cos(","c(");
       input=input.replace("tan(","t(");
       input=input.replace("π","p");
       input=input.replace("√","q");       
   }

   public void setPrecision(int prec)
   {
        String result="#.";
        if (prec>0&&prec<17)
        {
        precision=prec;
        for (int i=0;i<precision;i++)
        {
            result+="#";
        }
        Precision_str=result;
        }
    }
   public int getPrecision()
   {
        return precision;
    }
   private String getPrecisionString()
   {
        setPrecision(precision);
        return Precision_str;
    }
}