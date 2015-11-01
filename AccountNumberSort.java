package BankProgram;

import java.util.Comparator;

public class AccountNumberSort implements Comparator<Account>{

	@Override
	public int compare(Account o1, Account o2) {
		return o1.compareTo(0, o2);
	}

}
