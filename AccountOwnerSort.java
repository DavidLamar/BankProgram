package BankProgram;

import java.util.Comparator;

public class AccountOwnerSort implements Comparator<Account>{

	@Override
	public int compare(Account o1, Account o2) {
		return o1.compareTo(1, o2);
	}

}
