package BankProgram;

import java.util.GregorianCalendar;

public class CheckingAccount extends Account {

	private static final long serialVersionUID = 1L;
	   
	private double monthlyFee;

	// add constructor

	public CheckingAccount(int number, String owner, GregorianCalendar dateOpened, double balance, double monthlyFee) {
		super(number, owner, dateOpened, balance);
		this.monthlyFee = monthlyFee;
	}

	// add getter, setter, equals(), and toString() methods

}