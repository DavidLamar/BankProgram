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
	
/*************************** Account *********************************/
	
	public void addAccount(){
		
	}
	
	public void findAccount(){
		
	}
	
	public void deleteAccount(){
		
	}
	
	public void updateAccount(){
		
	}
	
	
/****************************** Load *********************************/
	
	public void loadBinary(){
		
	}
	
	public void loadText(){
		
	}
	
	public void loadXML(){
		
	}
	
	
/****************************** Save *********************************/
	
	public void saveBinary(){
		
	}
	
	public void saveText(){
		
	}
	
	public void saveXML(){
		
	}
	
	
/****************************** Sort *********************************/
	
	public void sortAccountNumber(){
		
	}
	
	public void sortOwner(){
		
	}
	
	public void sortDate(){
		
	}
	
	
	
	
}