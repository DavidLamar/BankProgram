package BankProgram;

import java.io.Serializable;
import java.util.GregorianCalendar;

public abstract class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	//we could make these protected if we wanted easier access
	private int number;
	private String owner;
	private GregorianCalendar dateOpened;
	private double balance;

	// add constructor

	//default
	public Account() {}

	//all Parameters
	public Account(int number, String owner, GregorianCalendar dateOpened, double balance) {

		this.number = number;
		this.owner = owner;
		this.dateOpened = dateOpened;
		this.balance = balance;
	}

	// add getter, setter, equals(), and toString() methods

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}


	public GregorianCalendar getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(GregorianCalendar dateOpened) {
		this.dateOpened = dateOpened;
	}


	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}