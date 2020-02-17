package Lab3;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Evaluator3 {
    final boolean verbose = true;
	private ExpressionTokenizer3 tokenizer;	
	
	public Evaluator3(String n) {
	  tokenizer = new ExpressionTokenizer3(n);
	}
	  public Evaluator3(Hashtable symbolTable) {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) 
      {  System.out.print("type expression>");
		 Scanner  in = new Scanner(System.in);
		 String input = in.nextLine();
         String str = "56*67";
		 Evaluator3 e = new Evaluator3(input);
		 int output = e.getExpressionValue();
		 System.out.println("Result is > "+ output);
			 
		 
		}


	
	public int getExpressionValue() {  
		int value = getTermValue();  // go search for * /  terms
		boolean done = false;
		while(!done) {
			String next = tokenizer.peekToken();
			if ("+".equals(next) || "-".equals(next)) {
				tokenizer.nextToken();	//Discard the "+" or "-"
				float value2 = getTermValue();
				if ("+".equals(next)) value += value2;
				else value -= value2;
			}
			else done = true;
		}
		return value;
	}
	
	
	public int getTermValue() {
		int value = getFactorValue(); // go search for ( )  
		boolean done = false;
		while(!done) {
			String next = tokenizer.peekToken();
			if ("*".equals(next) || "/".equals(next)) {
				tokenizer.nextToken();	//Discard the "*" or "/"
				float value2 = getFactorValue();
				if ("*".equals(next)) value *= value2;
				else value /= value2;
			}
			else done = true;
		}
		return value;
	}
	
	
	public int getFactorValue() {
		int value; String variable;
		String next = tokenizer.peekToken();
		if ("(".equals(next)) {
			tokenizer.nextToken();	//Discard the "("
			value = getExpressionValue();  //  recursively go back to expression value
			tokenizer.nextToken();	//Discard the ")"
		}
		else value = Integer.parseInt(tokenizer.nextToken());
        return value;
	}
	public Variable getAssignmentValue(String codeLine) {
		// TODO Auto-generated method stub
		return null;
	}	
}
