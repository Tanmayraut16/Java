import javax.swing.*;

import java.awt.FlowLayout;

class Calsi extends JFrame{

	JLabel num1Label, num2Label, resultLabel;
	JTextField num1TField, num2TField, resultTField;
	JButton addButton;
	
	public Calsi(){
		num1Label = new JLabel("Num 1:");
		num2Label = new JLabel("Num 2:");
		resultLabel = new JLabel("Result:");
		num1TField = new JTextField(20);
		num2TField = new JTextField(20);
		resultTField = new JTextField(21);
		addButton = new JButton("Addition");
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
		add(num1Label); add(num1TField);
		add(num2Label); add(num2TField);
		add(addButton); add(addButton);
		add(resultLabel); add(resultTField);
		setSize(400,400);
		setVisible(true);
	}
	
	public static void main(String args[]){
		
		System.out.println("Hi");
		Calsi myCalsi = new Calsi();
		//myCalsi.setVisible(true);
//		JOptionPane.showMessageDialog(null, "Hi", "Bye", JOptionPane.ERROR_MESSAGE);
	
	}

}
