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

	}