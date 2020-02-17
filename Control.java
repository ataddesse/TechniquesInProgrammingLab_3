package Lab3;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;


import javax.swing.AbstractButton;
import javax.swing.JFrame;



import java.io.OutputStreamWriter;

public class Control extends View implements ActionListener, WindowListener {
	InterpreterFrame myInterpreter;
	Hashtable nextLine = new Hashtable();
	
	Hashtable code = new Hashtable();
	
	String startLine;
	
	FileDialog myFD;
	
	 File inputF = null;
	    File outputF = null;
	public static void main(String args[]) 
	//throws IOException
	{
		new Control();
	}
	public Control() {
		readB.addActionListener(this);
		saveB.addActionListener(this);
		runB.addActionListener(this);
		resetB.addActionListener(this);
		this.addWindowListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		String whichButton = e.getActionCommand();
				if(whichButton.equals("Read"))
					processRead();
		if(whichButton.equals("Save"))
			try {
				processSave();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if(whichButton.equals("Run"))
			processExecute();
		if(whichButton.equals("Reset"))
			processReset();
	}
	public void processExecute() {
		
		if(verbose) System.out.println("Prpcessing Execute" + startLine);
	    InterpreterFrame mymodel = new InterpreterFrame(startLine);
	    InterpreterFrame.runProgram(startLine, nextLine, code);
	    
	}
	public void processReset() {
	
	}
	public void processSave() throws IOException {
		String fileName = getFileName(true);
		AbstractButton display = null;
		String streamString = display.getText();
		try {
			if(verbose) System.out.println("Processing write method");
			FileWriter writerStream = new FileWriter(fileName);
			OutputStreamWriter writerStram = null;
			writerStram.write (streamString);
			writerStream.close();
			
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
			OutputStreamWriter writerStram;}
	}
		
	public void processRead() {
		String previousKey = ""; String line, lineNumber, codeLine;
		System.out.println("@read");
		display.append("// Program File STARTS Here\n");
		try {
			
			System.out.println("@read");
			FileReader nf = new FileReader(getFileName(true));
			System.out.println("@read");
			BufferedReader in = new BufferedReader(nf);
			while((line = in.readLine()) != null) {
				StringTokenizer tok = new StringTokenizer(line, "\t\n\r", false);
				lineNumber = tok.nextToken();
				codeLine = tok.nextToken(); 
				code.put((String) lineNumber, (String) codeLine);
				if(previousKey != "")
					nextLine.put((String) previousKey, (String) lineNumber);
				else startLine = lineNumber;
				display.append(lineNumber + "" + codeLine + "\n");
						}
			display.append("// Program File ENDS Here\n");
			}
		catch (IOException e) {}
		catch (NoSuchElementException e) {}
	}
	
	private String getFileName(boolean opt)
	{    
		if (verbose)  System.out.println ("proces get file name");
	    FileDialog myFD;
	    if(opt)  myFD = new FileDialog(this,"Open...", FileDialog.LOAD);
	    else  myFD = new FileDialog(this,"Save...", FileDialog.SAVE);
	    myFD.setVisible(true);
		String name = myFD.getFile();
		String dir = myFD.getDirectory();
	    return dir+name; // if save return both dir and name	
	
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

