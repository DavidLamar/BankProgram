package BankProgram;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class DialogBox extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	Account acc;
	JTextField Number, Owner, Date, Balance, Fee, minBalance, Interest;
	JRadioButton Checking, Savings;
	ButtonGroup rButtons;
	JButton Create, Cancel;
	
	JPanel look;
	
	public DialogBox(JFrame f){
		super(f, true);
		setTitle("Add an Account");
		this.setPreferredSize(new Dimension(300,300));
		
		look = new JPanel();
		look.setPreferredSize(new Dimension(300,300));
		
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
		
		Create = new JButton("Create Account");
		Cancel = new JButton("Cancel");
		Cancel.addActionListener(this);
		Create.addActionListener(this);
		look.add(Create);
		look.add(Cancel);
		
		setContentPane(look);
		pack();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Checking){
			Interest.setEnabled(false);
			minBalance.setEnabled(false);
			Fee.setEnabled(true);
		}
		
		if(e.getSource() == Savings){
			Interest.setEnabled(true);
			minBalance.setEnabled(true);
			Fee.setEnabled(false);
		}
		
		if(e.getSource() == Cancel){
			dispose();
		}
		
		if(e.getSource() == Create){
			
			if(Checking.isSelected()){
				acc = new CheckingAccount(
						Integer.parseInt(Number.getText()), 
						Owner.getText(),
						new GregorianCalendar(),
						Double.parseDouble(Balance.getText()),
						Double.parseDouble(Fee.getText()) );
			}else{
				acc = new SavingsAccount(
						Integer.parseInt(Number.getText()), 
						Owner.getText(),
						new GregorianCalendar(),
						Double.parseDouble(Balance.getText()),
						Double.parseDouble(minBalance.getText()),
						Double.parseDouble(Interest.getText()));
			}
			
			dispose();
		}
	}
	
	public Account getAccount(){
		return acc;
	}
	
}
