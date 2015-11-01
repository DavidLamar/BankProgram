package BankProgram;

import java.util.GregorianCalendar;

public class SavingsAccount extends Account {

	private static final long serialVersionUID = 1L;
	   
	/** Holds the minimum balance of the account */
	private double minBalance;
	
	/** Holds the interest rate of the account */
	private double interestRate;


	/******************************************************************
	 * Constructor sets the account number, owner, date opened, 
	 * balance, minimum balance, and interest rate of the account
	 * 
	 * @param number The account number
	 * @param owner The account owner
	 * @param dateOpened The day the account was opened
	 * @param balance The account balance
	 * @param minBalance The minimum balance of the account
	 * @param interestRate The account interest rate
	 *****************************************************************/
	public SavingsAccount(int number, String owner, 
			GregorianCalendar dateOpened, double balance, 
			double minBalance, double interestRate) {
		super(number, owner, dateOpened, balance);
		this.minBalance = minBalance;
		this.interestRate = interestRate;
	}


	/******************************************************************
	 * Gets the minimum balance
	 * 
	 * @return minBalance The minimum balance of the account
	 *****************************************************************/
	public double getMinBalance() {
		return minBalance;
	}

	
	/******************************************************************
	 * Sets the minimum balance
	 * 
	 * @param minBalance The minimum balance we are setting
	 *****************************************************************/
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	
	/******************************************************************
	 * Gets the interest rate of the account
	 * 
	 * @return interestRate The account's interest rate
	 *****************************************************************/
	public double getInterestRate() {
		return interestRate;
	}

	
	/******************************************************************
	 * Sets the interest rate of the account
	 * 
	 * @param interestRate The interest rate we are setting
	 *****************************************************************/
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
}