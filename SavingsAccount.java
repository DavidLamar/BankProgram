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

	// equals(), and toString() methods

	//Min balence
	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	//interest rate
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
}