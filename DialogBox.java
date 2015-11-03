package BankProgram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.*;


public class DialogBox extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	Account acc;
	JTextField Number, Owner, Date, Balance, Fee, minBalance, Interest;
	JRadioButton Checking, Savings;
	ButtonGroup rButtons;
	JButton Create, Cancel;
	
	JPanel look;
	
	//blank
	public DialogBox(JFrame f){
		super(f, true);
		setTitle("Add an Account");
		this.setPreferredSize(new Dimension(300,300));
		
		//Initialize main panel
		look = new JPanel();
		look.setPreferredSize(new Dimension(300,300));
		look.setLayout(new GridLayout(9, 2));
		
		//Radio Buttons for checkings and savings
		rButtons = new ButtonGroup();
		Checking = new JRadioButton("Checking");
		Savings = new JRadioButton("Savings");
		
		rButtons.add(Checking);
		rButtons.add(Savings);
		Checking.setSelected(true);
		Checking.addActionListener(this);
		Savings.addActionListener(this);
		look.add(Checking);
		look.add(Savings);
		
		//Text fields and labels:
		Number = new JTextField(10);
		Owner = new JTextField(10);
		Date = new JTextField(10);
		Balance = new JTextField(10);
		Fee = new JTextField(10);
		minBalance = new JTextField(10);
		minBalance.setEnabled(false);
		Interest = new JTextField(10);
		Interest.setEnabled(false);

		look.add(new JLabel("Account Number: "));
		look.add(Number);
		look.add(new JLabel("Account Owner: "));
		look.add(Owner);
		look.add(new JLabel("Date Opened: "));
		look.add(Date);
		look.add(new JLabel("Account Balance: "));
		look.add(Balance);
		look.add(new JLabel("Fee: "));
		look.add(Fee);
		look.add(new JLabel("Minimum Balance: "));
		look.add(minBalance);
		look.add(new JLabel("Interest Rate: "));
		look.add(Interest);
		
		
		//Create and cancel buttons:
		Create = new JButton("Create Account");
		Cancel = new JButton("Cancel");
		Cancel.addActionListener(this);
		Create.addActionListener(this);
		look.add(Create);
		look.add(Cancel);
		
		
		
		setContentPane(look);
		pack();
		
	}

	//used for updating accounts
	//they start full of data
	//uses blank constructor then sets text values

	//checking account
	public DialogBox(JFrame f, int Number, String Owner, String Date, double Balance, double Fee){
		this(f);

		//set text values
		this.Number.setText(Integer.toString(Number));
		this.Owner.setText(Owner);
		this.Date.setText(Date);
		this.Balance.setText(Double.toString(Balance));
		this.Fee.setText(Double.toString(Fee));
	}

	//saving account
	public DialogBox(JFrame f, int Number, String Owner, String Date, double Balance, double minBalance, double Interest){
		this(f);

		//set DialogBox to savingsAccount
		Savings.setSelected(true);
		this.Interest.setEnabled(true);
		this.minBalance.setEnabled(true);
		Fee.setEnabled(false);

		//set text values
		this.Number.setText(Integer.toString(Number));
		this.Owner.setText(Owner);
		this.Date.setText(Date);
		this.Balance.setText(Double.toString(Balance));
		this.minBalance.setText(Double.toString(minBalance));
		this.Interest.setText(Double.toString(Interest));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Enables fee for checking and disables savings fields
		if(e.getSource() == Checking){
			Interest.setEnabled(false);
			minBalance.setEnabled(false);
			Fee.setEnabled(true);
		}
		
		//Enables savings fields, dissables checking feilds
		if(e.getSource() == Savings){
			Interest.setEnabled(true);
			minBalance.setEnabled(true);
			Fee.setEnabled(false);
		}
		
		//Gets rid of window if cancel is hit
		if(e.getSource() == Cancel){
			dispose();
		}
		
		if(e.getSource() == Create){
			String[] date = Date.getText().split("/");

			//check if it is a valid date
			if(isValidDate(date)){

				int day = Integer.parseInt(date[1]);
				int month = Integer.parseInt(date[0]) - 1;
				int year = Integer.parseInt(date[2]);

				//attempt to make the account
				try {

					if (Checking.isSelected()) {
						acc = new CheckingAccount(
								Integer.parseInt(Number.getText()),
								Owner.getText(),
								new GregorianCalendar(year, month, day),
								Double.parseDouble(Balance.getText()),
								Double.parseDouble(Fee.getText()));
					} else {
						acc = new SavingsAccount(
								Integer.parseInt(Number.getText()),
								Owner.getText(),
								new GregorianCalendar(year, month, day),
								Double.parseDouble(Balance.getText()),
								Double.parseDouble(minBalance.getText()),
								Double.parseDouble(Interest.getText()));
					}

					dispose();
				}
				//catch parse errors and inform the user the input is invalid
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(this, "Invalid Input");
				}
			}else{

				//tell the user the date is invalid
				JOptionPane.showMessageDialog(this, "Invalid Date");
			}
		}
	}

	private boolean isValidDate(String[] str){

		if(str.length != 3){
			return false;
		}

		try{

			int day = Integer.parseInt(str[1]);
			int month = Integer.parseInt(str[0]) - 1;
			int year = Integer.parseInt(str[2]);

			GregorianCalendar c = new GregorianCalendar();
			c.setLenient(false);
			c.set(year, month, day);
			c.getTime();

		}
		//catch NumberFormatExeptions and Invalid date exeptions
		catch(Exception e){

			return false;
		}

		return true;
	}
	
	public Account getAccount(){
		//TODO - Return null if acc data is not correct or whatever
		return acc;
	}
	
}
