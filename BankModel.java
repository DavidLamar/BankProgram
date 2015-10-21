package BankProgram;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class BankModel extends AbstractListModel {

	private ArrayList<Account> acts;

	// constructor method that initializes the arraylist

	// override these two methods from AbstractListModel class

	public Object getElementAt(int arg0) {
		return acts.get(arg0);
	}

	public int getSize() {
		return acts.size();
	}

	// add methods to find, add, delete, and update accounts

	// add methods to sort accounts on required fields

	// add methods to load/save accounts from/to a binary file

	// add methods to load/save accounts from/to a text file

	// add methods to load/save accounts from/to an XML file

	// add other methods as needed
}