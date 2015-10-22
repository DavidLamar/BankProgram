package BankProgram;

import java.util.GregorianCalendar;

public class SavingsAccount extends Account {

	private static final long serialVersionUID = 1L;
	   
	private double minBalance;
	private double interestRate;

	// add constructor

	public SavingsAccount(int number, String owner, GregorianCalendar dateOpened, double balance, double minBalance, double interestRate) {
		super(number, owner, dateOpened, balance);
		this.minBalance = minBalance;
		this.interestRate = interestRate;
	}

	// add getter, setter, equals(), and toString() methods

}