/*File name: Mortgage Calculator GUI.java
Programmer: Ryan Sazid   
Date: 5-10-24
Version:1.0
Mortgage calculator with GUI elements. Calculates monthly payments. 
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JCalcFrame extends JFrame implements ActionListener {
	FlowLayout flow = new FlowLayout();
	JLabel num1 = new JLabel("Principal: ");
	JTextField number1 = new JTextField(6);

	JLabel num2 = new JLabel("Rate: ");
	JTextField number2 = new JTextField(6);
	
	JLabel num3 = new JLabel("Terms: ");
	JTextField number3 = new JTextField(6);
	
	JButton calcButton = new JButton("Calculate Monthly Payments");
	JButton reset = new JButton("Reset");
	JButton exitButton = new JButton("Exit");

	JLabel blankSpaces1 = new JLabel("              ");
	JLabel blankSpaces2 = new JLabel("                        ");
	
	JLabel num4 = new JLabel("Monthly payment total: ");
	JLabel sum = new JLabel("");//We use this for output
	
	//default constructor
	public JCalcFrame(){
	Container con = getContentPane(); // we get fresh JFrame
	con.setLayout(flow);
	
	//Buttons and spaces for the input of numbers.
	con.add(num1);
	con.add(number1);
	con.add(num2);
	con.add(number2);
	con.add(num3);
	con.add(number3);
	con.add(blankSpaces1);
	con.add(calcButton);
	con.add(reset);
	con.add(exitButton);
	con.add(blankSpaces2);
	con.add(num4);
	con.add(sum);
	
	//Action of the button does in the program
	calcButton.addActionListener(this);
	exitButton.addActionListener(this);
	reset.addActionListener(this);
       }

    //Driver for class
    public static void main(String args[]){
	JCalcFrame f1 = new JCalcFrame(); //using default constructor
	f1.setTitle("Input a Principal, Rate, and Term values");
	f1.setDefaultCloseOperation(JCalcFrame.EXIT_ON_CLOSE);
	f1.setSize(550,650);
	f1.setVisible(true);
	} //end of main

	//actionPerformed
	public void actionPerformed(ActionEvent e)
	{
	Object source = e.getSource();
	if(source == calcButton)
	{
	String n1 = number1.getText();
	String n2 = number2.getText();
	String n3 = number3.getText();
	double nm1 = Double.parseDouble(n1);
	double nm2 = Double.parseDouble(n2);
	double nm3 = Double.parseDouble(n3);
	
	nm3 = nm3 * 12;
	nm2 = nm2 / 1200.0;
	double monthlyPayment = (nm1 * nm2) / ( 1.0 - Math.pow(nm2 + 1, -nm3));
            //Convert data type of total to String
            //This can be any formula
	sum.setText(String.format("%.2f", (monthlyPayment)));
      }
     else if (source == reset){
	  sum.setText("");
	  number1.setText("");
	  number2.setText("");
	  number3.setText("");
      }	
      else{
	System.exit(0);
	}
  } //end actionPerformed
} //end JCalcFrame Class