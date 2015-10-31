package BankProgram;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	Object[] options = {"Create Account", "Cancel"};
	static final int OK = 0;
	static final int CANCEL = 1;
	private int status = 0;
	
	JPanel holder;
	JTextField Number, Owner, Date, Balance;
	ButtonGroup checkField;
	JRadioButton Checking, Savings;
	
	JButton create, cancel;
	
	Account acc;
	
	public DialogBox(Account newAccount){
		setModal(true);
		setTitle("Create Account");
		setLayout(new FlowLayout());
		setSize(new Dimension(300,200));
		
		acc = newAccount;
		
		holder = new JPanel();
		
		//Handles the radio buttons for checking or savings
		Checking = new JRadioButton("Checking");
		Checking.setSelected(true);
		Savings = new JRadioButton("Savings");
		checkField = new ButtonGroup();
		checkField.add(Checking);
		checkField.add(Savings);
		holder.add(new JLabel("Account Type:"));
		holder.add(Checking);
		holder.add(Savings);
		
		Number = new JTextField(15);
		Owner = new JTextField(15);
		Date = new JTextField(15);
		Balance = new JTextField(15);
		holder.add(new JLabel("Account Number:"));
		holder.add(Number);
		holder.add(new JLabel("Account Owner:"));
		holder.add(Owner);
		holder.add(new JLabel("Date Opened:"));
		holder.add(Date);
		holder.add(new JLabel("Balance:"));
		holder.add(Balance);
		
		create = new JButton("Create Account");
		create.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		holder.add(create);
		holder.add(cancel);
		
		
		setContentPane(holder);
		setVisible(true);
	}
	
	public void setStatus(int s){
		status = s;
	}
	public int getStatus(){
		return status;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancel){
			setStatus(CANCEL);
			
			
			setVisible(false);
			dispose();
		}
		
		if(e.getSource() == create){
			setStatus(OK);
			
			
			setVisible(false);
			dispose();
		}
		
		
	}
	
}
