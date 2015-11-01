package BankProgram;

import java.util.Comparator;

public class DateOpenedSort implements Comparator<Account>{

	@Override
	public int compare(Account arg0, Account arg1) {
		return arg0.compareTo(3, arg1);
	}

}
