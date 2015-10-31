package BankProgram;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BankModel extends AbstractListModel {

	private ArrayList<Account> acts;
	private JFrame GUI;

	// constructor method that initializes the arraylist

	public BankModel(JFrame bGUI) {

		acts = new ArrayList<Account>();
		GUI = bGUI;

		//test accounts to test scroll panel
		for(int i = 0; i < 25; i++){
			acts.add(new CheckingAccount(123, "Marc " + i, new GregorianCalendar(), 12345, 1));
		}
	}

	// override these two methods from AbstractListModel class

	@Override
	public Object getElementAt(int arg0) {
		//TODO - Make this nice / column headers(easy once we are using a table)
		return String.format("Account Number: %s Name: %s Balance: %s", acts.get(arg0).getNumber(), acts.get(arg0).getOwner(), acts.get(arg0).getBalance());
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
		JOptionPane.showMessageDialog(GUI, "Deleted Account: " + 
				acts.get(i).getNumber());

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
	
	public void loadText(String fileName){
		try {
			Scanner read = new Scanner(new File(fileName));
			String[] info;
			Account temp;
			for(int i=0; i<acts.size();){
				acts.remove(i);
			}
			
			while(read.hasNextLine()){
				info = read.nextLine().split("\\|");

				//****GOTTA FIX GREGORIAN CALENDAR STUFF
				if(info[0].equals("BankProgram.CheckingAccount")){
					temp = new CheckingAccount(
							Integer.parseInt(info[1]), 
							info[2], 
							new GregorianCalendar(), 
							Double.parseDouble(info[4]),
							Double.parseDouble(info[5]));
					
					acts.add(temp);
					
				}else{
					temp = new SavingsAccount(
							Integer.parseInt(info[1]),
							info[2],
							new GregorianCalendar(),
							Double.parseDouble(info[4]),
							Double.parseDouble(info[5]),
							Double.parseDouble(info[6]));
					
					acts.add(temp);
				}
			}
			
			fireContentsChanged(this, 0, acts.size() - 1);
			read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public void saveText(String fileName){
		
		String write = "";
		
		for(int i = 0; i < acts.size(); i++){
			
			//checks if it's savings or checkings
			if(acts.get(i).getClass().getName().equals("BankProgram.CheckingAccount")){
				write += acts.get(i).getClass().getName() + "|";
				write += acts.get(i).getNumber() + "|";
				write += acts.get(i).getOwner() + "|";
				write += "<Fix Date in saveText>" + "|";
				write += acts.get(i).getBalance() + "|";
				write += ((CheckingAccount)acts.get(i)).getMonthlyFee() + "\n";
			}else{
				write += acts.get(i).getClass().getName() + "|";
				write += acts.get(i).getNumber() + "|";
				write += acts.get(i).getOwner() + "|";
				write += "<Fix Date in saveText>" + "|";
				write += acts.get(i).getBalance() + "|";
				write += ((SavingsAccount)acts.get(i)).getMinBalance() + "|";
				write += ((SavingsAccount)acts.get(i)).getInterestRate() + "\n";
			}
			
		}
		
		
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter(fileName));
			bf.write(write);
			
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveXML(String fileName){

		String write = "";
		
		for(int i = 0; i < acts.size(); i++){
			
			//checks if it's savings or checking
			if(acts.get(i).getClass().getName().equals("BankProgram.CheckingAccount")){
				write += "<account>\n";
				write += "<type>" + acts.get(i).getClass().getName() + "</type>\n";
				write += "<number>" + acts.get(i).getNumber() + "</number>\n";
				write += "<owner>" + acts.get(i).getOwner() + "</owner>\n";
				write += "<date>" + "<Fix Date in saveText>" + "</date>\n";
				write += "<balance>" + acts.get(i).getBalance() + "</balance>\n";
				write += "<fee>" + ((CheckingAccount)acts.get(i)).getMonthlyFee() + "</fee>\n";
				write += "</account>\n";
			}else{
				write += "<account>\n";
				write += "<type>" +acts.get(i).getClass().getName() + "</type>\n";
				write += "<number>" +acts.get(i).getNumber() + "</type>\n";
				write += "<owner>" +acts.get(i).getOwner() + "</type>\n";
				write += "<date>" +"<Fix Date in saveText>" + "</type>\n";
				write += "<balance>" +acts.get(i).getBalance() + "</type>\n";
				write += "<min>" +((SavingsAccount)acts.get(i)).getMinBalance() + "</type>\n";
				write += "<interest>" +((SavingsAccount)acts.get(i)).getInterestRate() + "</type>\n";
				write += "</account>\n";
			}
			
		}
		
		
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter(fileName));
			bf.write(write);
			
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
/****************************** Sort *********************************/
	
	public void sortAccountNumber(){
		
	}
	
	public void sortOwner(){
		
	}
	
	public void sortDate(){
		
	}
	
	
	
	
}