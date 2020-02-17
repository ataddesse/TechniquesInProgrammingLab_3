package Lab3;

public class ExpressionTokenizer3 {
	private String input;
	private int start;
	private int end;
	
		public ExpressionTokenizer3(String anInput) {
		input = anInput;
	    System.out.println (input + " L " +  input.length() );
		start = 0;
		end = 0;
		nextToken();	//sets start and end for first token
	}

	

	public String nextToken() {
		String r = peekToken();
		start = end;		
		if (start >= input.length())  return r;
		if (Character.isDigit(input.charAt(start)))
            { System.out.println(input.charAt(start));
			  end = start + 1; // read digits 
		      while (end < input.length() &&
		            Character.isDigit(input.charAt(end)))
		            { 
		    	  System.out.println(input.charAt(end));
		              end++; 
		              }
		    }
		   else 
			   
		      end = start + 1;   // move the end marker
		
		return r; 
		}

	

	
	public String peekToken() {
	   	if (start >= input.length()) return null;
	    return input.substring(start, end);
	}
	
}

		   

