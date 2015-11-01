package BankProgram;

import java.io.Serializable;
import java.util.GregorianCalendar;

public abstract class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Holds the account number*/
	private int number;
	
	/** Holds the account owner*/
	private String owner;
	
	/** Holds the date the account was opened*/
	private GregorianCalendar dateOpened;
	
	/** Holds the account balance*/
	private double balance;

	

	/******************************************************************
	 * Constructor the default constructor; doesn't set anything
	 *****************************************************************/
	public Account() {}

	
	/******************************************************************
	 * Constructor sets the number, owner, date opened, and balance 
	 * with the given parameters
	 * 
	 * @number The account number
	 * @owner The account owner
	 * @dateOpened The date the account was opened
	 * @balance The balance of the account
	 *****************************************************************/
	public Account(int number, String owner, GregorianCalendar dateOpened, double balance) {

		this.number = number;
		this.owner = owner;
		this.dateOpened = dateOpened;
		this.balance = balance;
	}


	/******************************************************************
	 * Gets the account number
	 * 
	 * @return number The number of the account
	 *****************************************************************/
	public int getNumber() {
		return number;
	}

	
	/******************************************************************
	 * Sets the account number
	 * 
	 * @param number The number we're setting to be the account number
	 *****************************************************************/
	public void setNumber(int number) {
		this.number = number;
	}

	
	/******************************************************************
	 * Gets the account owner
	 * 
	 * @return owner The owner of the account
	 *****************************************************************/
	public String getOwner() {
		return owner;
	}

	
	/******************************************************************
	 * Sets the account owner
	 * 
	 * @param owner The owner we're setting to the account
	 *****************************************************************/
	public void setOwner(String owner) {
		this.owner = owner;
	}

	
	/******************************************************************
	 * Gets the date opened in the form of a GregorianCalendar
	 * 
	 * @return dateOpened The date the account was opened
	 *****************************************************************/
	public GregorianCalendar getDateOpened() {
		return dateOpened;
	}

	
	/******************************************************************
	 * Sets the date the account was opened
	 * 
	 * @param dateOpened The date we're setting to be the date opened
	 *****************************************************************/
	public void setDateOpened(GregorianCalendar dateOpened) {
		this.dateOpened = dateOpened;
	}

	
	/******************************************************************
	 * Gets the account balance
	 * 
	 * @return balance The account balance
	 *****************************************************************/
	public double getBalance() {
		return balance;
	}

	
	/******************************************************************
	 * Sets the account balance
	 * 
	 * @param balance The balance we are setting to the account
	 *****************************************************************/
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	/******************************************************************
	 * Compares against another account; can compare by account number,
	 * account owner, and date opened. Returns a -1 if THIS account is
	 * lower, returns 0 if they are the same, returns 1 if this account
	 * is higher.
	 * 
	 * @param type Type of compare; 0 is number, 1 is owner, 2 is date
	 * @param act The other account to be compared to
	 * 
	 * @return -1, 0, or 1 based on how it's compared
	 *****************************************************************/
	public int compareTo(int type, Account act){
		switch(type){
		case 0:
			if(getNumber() < act.getNumber()){
				return -1;
			}
			
			if(getNumber() > act.getNumber()){
				return 1;
			}
			return 0;
		case 1:
			
			return 0;
		case 2:
			
			return 0;
		default:
			return 0;
		}
	}
}