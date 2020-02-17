package Lab3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class View extends JFrame {
	
	final boolean verbose = true;
    public   JTextField inputFileName = new JTextField(15);
    public   JTextField outputFileName = new JTextField(15);
	JButton readB, runB, saveB, resetB;
	JTextArea resultField;
	JTextArea display = new JTextArea(200,250); 
	
	JScrollPane scropane = new JScrollPane(display);
	JPanel northPanel, centerPanel, southPanel;
	Color color;
	JTextField fileLabel;
	
	
	public static void main(String[] args) {
		new View();
		
	}
	
	public View() {
		setBounds(600,300,600,300);
		setTitle("Basic Interpreter");
		setLayout(new BorderLayout());
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		northPanel = new JPanel(new GridLayout(1,4));
	   centerPanel = new JPanel(new GridLayout(1,1));
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		readB = new JButton("Read");
		runB = new JButton("Run");
		saveB = new JButton("Save");
		resetB = new JButton("Reset");
		
		resultField = new JTextArea(10,10);
		scropane = new JScrollPane(resultField);
		color = new Color(5,5,240);
		scropane.setBackground(color);
		fileLabel = new JTextField("");
		
		
		 northPanel.add(readB);
		 northPanel.add(runB);
		 northPanel.add(saveB);
		 northPanel.add(resetB);
		 centerPanel.add(scropane);
			setVisible(true);
	}

}
