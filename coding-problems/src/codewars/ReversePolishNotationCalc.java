package codewars;

import java.util.Stack;

public class ReversePolishNotationCalc 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ReversePolishNotationCalc c=new ReversePolishNotationCalc();
		System.out.println(c.evaluate("1 3 -"));
	}
	public double evaluate(String expr) 
	{
		if(expr.isEmpty())
			return 0.0;
		Stack<String> digits= new Stack<String>();
		String[] list=expr.split(" ");
		for(int i=0;i<list.length;i++)
		{
			if(list[i].matches("[0-9]*[.]?[0-9]*"))
				digits.push(list[i]);
			else if(list[i].matches("[+*/-]"))
			{
				double result=0d;
				String s2=digits.pop();
				String s1=digits.pop();
				if(list[i].equals("+")) result=Double.parseDouble(s1)+Double.parseDouble(s2);
				else if(list[i].equals("-")) result=Double.parseDouble(s1)-Double.parseDouble(s2);
				else if(list[i].equals("*")) result=Double.parseDouble(s1)*Double.parseDouble(s2);
				else if(list[i].equals("/")) result=Double.parseDouble(s1)/Double.parseDouble(s2);
				digits.push(result+"");  
			}
		}
		return Double.parseDouble(digits.pop());
	}
}
