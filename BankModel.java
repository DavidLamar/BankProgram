package BankProgram;

import java.awt.Dimension;
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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BankModel extends AbstractListModel {

	private ArrayList<Account> acts;
	private JFrame GUI;
	private JDialog jd;

	// constructor method that initializes the arraylist

	public BankModel(JFrame bGUI) {

		acts = new ArrayList<Account>();
		GUI = bGUI;
	}

	// override these two methods from AbstractListModel class

	@Override
	public Object getElementAt(int arg0) {
		//TODO - Make this nice / column headers(easy once we are using a table)
		return String.format("Account Number: %s Name: %s Balance: %s", 
				acts.get(arg0).getNumber(), acts.get(arg0).getOwner(), 
				acts.get(arg0).getBalance());
	}

	@Override
	public int getSize() {
		return acts.size();
	}
	
/*************************** Account *********************************/
	
	public void addAccount(){
		
		jd = new DialogBox(GUI);
		jd.setVisible(true);
		
		Account act = ((DialogBox) jd).getAccount();
		
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
			
			//removes all current accounts
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
	
	public void loadXML(String fileName){
//		try {
//			Scanner read = new Scanner(new File(fileName));
//			String info;
//			String type = null;
//			String data[] = null;
//			Account temp;
//			
//			//removes all current accounts
//			for(int i=0; i<acts.size();){
//				acts.remove(i);
//			}
//
//			while(read.hasNextLine()){
//				info = read.nextLine();
//				if(info.equals("<account>")){
//					
//					info = read.nextLine();
//					while(!info.equals("</account>")){
//						
//						if(info.equals(null) || !read.hasNextLine()){
//							break;
//						}
//						
//						System.out.println(info);
//						
//						if(info.equals("<type>")){
//							type = read.nextLine();
//							info = read.nextLine();
//							continue;
//						}
//						if(info.equals("<number>")){
//							data[0] = read.nextLine();
//							info = read.nextLine();
//							continue;
//						}
//						if(info.equals("<owner>")){
//							data[1] = read.nextLine();
//							info = read.nextLine();
//							continue;
//						}
//						if(info.equals("<date>")){
//							data[2] = read.nextLine();
//							info = read.nextLine();
//							continue;
//						}
//						if(info.equals("<balance>")){
//							data[3] = read.nextLine();
//							info = read.nextLine();
//							continue;
//						}
//						if(info.equals("<fee>")){
//							data[4] = read.nextLine();
//							info = read.nextLine();
//							continue;
//						}
//						if(info.equals("<min>")){
//							data[5] = read.nextLine();
//							info =read.nextLine();
//							continue;
//						}
//						if(info.equals("<interest>")){
//							data[6] = read.nextLine();
//							info = read.nextLine();
//							continue;
//						}
//						
//						info = read.nextLine();
//					}
//					
//					//after we have all the info, check account type
//					if(type.equals("BankProgram.CheckingAccount")){
//						temp = new CheckingAccount(
//								Integer.parseInt(data[0]), 
//								data[1], 
//								new GregorianCalendar(), 
//								Double.parseDouble(data[3]),
//								Double.parseDouble(data[4]));
//						
//						acts.add(temp);
//					}else{
//						temp = new SavingsAccount(
//								Integer.parseInt(data[0]),
//								data[1],
//								new GregorianCalendar(),
//								Double.parseDouble(data[3]),
//								Double.parseDouble(data[5]),
//								Double.parseDouble(data[6]));
//						
//						acts.add(temp);
//					}
//					
//				}
//			}
//			fireContentsChanged(this, 0, acts.size() - 1);
//			read.close();
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
				write += "<type>\n" + acts.get(i).getClass().getName() + "\n</type>\n";
				write += "<number>\n" + acts.get(i).getNumber() + "\n</number>\n";
				write += "<owner>\n" + acts.get(i).getOwner() + "\n</owner>\n";
				write += "<date>\n" + "<Fix Date in saveText>" + "\n</date>\n";
				write += "<balance>\n" + acts.get(i).getBalance() + "\n</balance>\n";
				write += "<fee>\n" + ((CheckingAccount)acts.get(i)).getMonthlyFee() + "\n</fee>\n";
				write += "</account>\n";
			}else{
				write += "<account>\n";
				write += "<type>\n" +acts.get(i).getClass().getName() + "\n</type>\n";
				write += "<number>\n" +acts.get(i).getNumber() + "\n</type>\n";
				write += "<owner>\n" +acts.get(i).getOwner() + "\n</type>\n";
				write += "<date>\n" +"<Fix Date in saveText>" + "\n</type>\n";
				write += "<balance>\n" +acts.get(i).getBalance() + "\n</type>\n";
				write += "<min>\n" +((SavingsAccount)acts.get(i)).getMinBalance() + "\n</type>\n";
				write += "<interest>\n" +((SavingsAccount)acts.get(i)).getInterestRate() + "\n</type>\n";
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