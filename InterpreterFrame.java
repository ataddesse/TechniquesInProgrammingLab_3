package Lab3;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.Hashtable;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterpreterFrame extends Frame implements WindowListener {
	static Hashtable symbolTable = new Hashtable();
	Hashtable controlTable = new Hashtable();
	TextArea consoleDisplay = new TextArea(20,40);
	static String lineNumber;
	static String codeLine; static String in; static int insType;
	static StringTokenizer tok, tok2;
	final static boolean verbose = true;
	static String line;
	static boolean execFlag;
	
	public InterpreterFrame(String startLine) {
		setTitle("Console Output");
		setSize(200,200); this.addWindowListener(this);
		setBounds(50,50,500,500);
		consoleDisplay.append("Running from line" + startLine + "\n______________________\n\n");
	    consoleDisplay.setBackground(Color.BLACK);
	    consoleDisplay.setBackground(Color.YELLOW);
	    setVisible(true);pack();
	}
 
	public static  void runProgram(String startLine, Hashtable nextLine, Hashtable code)
	{
		
		
		String nextKey = startLine;
				execFlag = true;
		
		while(execFlag) {
			
			lineNumber = nextKey;
			codeLine = (String) code.get((String) lineNumber);
			if(verbose) System.out.println("line" + lineNumber
					+ "code:" + ((String) code.get((String) lineNumber))
					);
			       nextKey = (String) nextLine.get(lineNumber);
			       if(verbose) System.out.println(lineNumber + "" + codeLine + "\n");
			       if(verbose) System.out.println(lineNumber + "" +codeLine + "\n");
			       insType = instructionType();
			       switch(insType) {
			       case 0: proComment(); break;
			       case 1: proAssign(); break;
			       case 2: proPrint(); break;
			       case 3: String x = proGOTO(nextLine);
			               if(!x.equals("UNDEFINED")) nextKey=x; break;
			       case 4: String x2 = proIF();
			                if(!x2.contentEquals("NOTRANSFER")) nextKey=x2; break;
			       case 5: proEND(); break;
			       }
			       
			       
		}
	}

	public static int instructionType() {
		if(verbose) System.out.println("decoding");
		int insType;
		
		tok2 = new StringTokenizer(codeLine, "");
		String type = tok2.nextToken();
		if(type.equals("if(")) { codeLine = tok2.nextToken(); insType = 4;}
		else if (type.equals("goto")) {codeLine = tok2.nextToken(); insType = 3;}
		else if (type.equals("//")) insType = 0;
		else if (type.equals("print")) {codeLine = tok2.nextToken(); insType = 2;}
		else if (type.equals("end")) insType=5;
		else insType = 1;
		if(verbose) System.out.println("decoding" + type + "as" + insType);
		return insType;
		}

	public static String proIF(nextLine) {
		if(verbose) System.out.println("If processing" + codeLine);
		Evaluator3 e  = new Evaluator3(symbolTable);
		Variable value = new Variable();
		value.LHS = e.getVariable(codeLine);
		if(symbolTable.containKey(value.LHS))
			value.RHS = ((Float)) symbolTable.get(value.LHS).floatValue();
		else value.RHS = 0 ;
	}
		
		
		public static void proEND() {}
		public static String proGOTO(Hashtable nextLine) {
			
		}
	
		public static void proAssign() {
			
		}
public static void proComment() {
			
		}
        public static void proPrint() {
			if(verbose) System.out.println(" print processing");
			Evaluator3 e = new Evaluator3(symbolTable);
			Variable value = e.getAssignmentValue(codeLine);
			symbolTable.compute(value.LHS, new void (value.RHS));
			
			
		}


@Override
public void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosing(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosed(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowIconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeiconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowActivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeactivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
	}
	}
}
