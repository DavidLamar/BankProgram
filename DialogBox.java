package BankProgram;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class DialogBox extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	Account acc;
	JTextField Number, Owner, Date, Balance, Fee, minBalance, Interest;
	JRadioButton Checking, Savings;
	ButtonGroup rButtons;
	
	
	public DialogBox(Account newAccount){
		this.setPreferredSize(new Dimension(300,200));
		rButtons = new ButtonGroup();
		Checking = new JRadioButton("Checking");
		Savings = new JRadioButton("Savings");
		rButtons.add(Checking);
		rButtons.add(Savings);
		Checking.setSelected(true);
		Checking.addActionListener(this);
		Savings.addActionListener(this);
		
		
		add(Checking);
		add(Savings);
		
		Number = new JTextField(10);
		Owner = new JTextField(10);
		Date = new JTextField(10);
		Balance = new JTextField(10);
		Fee = new JTextField(10);
		minBalance = new JTextField(10);
		minBalance.setEnabled(false);
		Interest = new JTextField(10);
		Interest.setEnabled(false);
		add(Number);
		add(Owner);
		add(Date);
		add(Balance);
		add(Fee);
		add(minBalance);
		add(Interest);
		
		
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
	}
	
}
