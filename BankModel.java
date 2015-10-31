package BankProgram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.AbstractListModel;

public class BankModel extends AbstractListModel {

	private ArrayList<Account> acts;

	// constructor method that initializes the arraylist

	public BankModel() {

		acts = new ArrayList<Account>();

		//test accounts to test scroll panel
		for(int i = 0; i < 25; i++){
			acts.add(new CheckingAccount(123, "Marc " + i, new GregorianCalendar(), 12345, 1));
		}
	}

	// override these two methods from AbstractListModel class

	@Override
	public Object getElementAt(int arg0) {
		//TODO - show relevant info not just the name
		return acts.get(arg0).getOwner();
	}

	@Override
	public int getSize() {
		return acts.size();
	}
	
/*************************** Account *********************************/
	
	public void addAccount(Account act){
		acts.add(act);
		fireContentsChanged(this, 0 , getSize() - 1);
	}
	
	public void findAccount(){
		
	}
	
	public void deleteAccount(int i){
		acts.remove(i);
		fireContentsChanged(this, 0 , getSize() - 1);
	}
	
	public void updateAccount(){
		
	}
	
	
/****************************** Load *********************************/
	
	@SuppressWarnings("unchecked")
	public void loadBinary(String fileName){
		FileInputStream in;
		ObjectInputStream objIn;
		
		try{
			in = new FileInputStream(fileName);
			objIn = new ObjectInputStream(in);
			acts = (ArrayList<Account>) objIn.readObject();
			// tell the JList to update
			fireContentsChanged(this, 0, acts.size() - 1);
		} catch(Exception e){
			System.out.println("Could not load file!");
		}
	}
	
	public void loadText(){
		
	}
	
	public void loadXML(){
		
	}
	
	
/****************************** Save *********************************/
	
	public void saveBinary(String fileName){
		FileOutputStream fos;
		ObjectOutputStream oos;
		
		try {
			
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(acts);
			
			//These don't need to go into a finally block since they
			//will never be opened if an error occurs.
			fos.close();
			oos.close();
			
		} catch (Exception e) {
			System.out.println("Could not save binary file!");
			e.printStackTrace();
		} 
		
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