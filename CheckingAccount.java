package BankProgram;

import java.util.GregorianCalendar;

public class CheckingAccount extends Account {

	private static final long serialVersionUID = 1L;
	
	/** Stores monthly fee of the account */
	private double monthlyFee;

	/******************************************************************
	 * Constructor sets the account number, owner, date opened, 
	 * balance, and monthly fee.
	 * 
	 * @param number The account number
	 * @param owner The account owner
	 * @param dateOpened The day the account was opened
	 * @param balance The account balance
	 * @param monthlyFee The monthly fee of the account
	 *****************************************************************/
	public CheckingAccount(int number, String owner, 
			GregorianCalendar dateOpened, double balance, 
			double monthlyFee) {
		super(number, owner, dateOpened, balance);
		this.monthlyFee = monthlyFee;
	}


	/******************************************************************
	 * Gets the monthly fee
	 * 
	 * @return monthlyFee The monthly fee of the account
	 *****************************************************************/
	public double getMonthlyFee() {
		return monthlyFee;
	}

	/******************************************************************
	 * Sets the montly fee
	 * 
	 * @param monthlyFee The monthly fee we are setting to the account
	 *****************************************************************/
	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	
}