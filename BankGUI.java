package BankProgram;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class BankGUI extends JFrame {

	//Instance Variables
	private static JPanel programPannel;
	private static JMenuBar fileBar;
	private JMenu file, edit, sort;
	private JMenuItem loadBinary, loadText, loadXML, saveBinary, 
	saveText, saveXML, exit, createAccount, deleteAccount, 
	updateAccount, sortNumber, sortOwner, sortDate;
	
	
	
	public BankGUI(){
		//Set up the panels and stuff we need to make everything appear
		programPannel = new JPanel();
		fileBar = new JMenuBar();
		
		//I know we'll need this later, but it's currently unused.
		BankModel bModel = new BankModel();
		
		
		//set up the file bar
		file = new JMenu("File");
		edit = new JMenu("Edit");
		sort = new JMenu("Sort");
		fileBar.add(file);
		fileBar.add(edit);
		fileBar.add(sort);
		
		FileListener listener = new FileListener();
		
		//File:
		loadBinary = new JMenuItem("Load from Binary File");
		loadBinary.addActionListener(listener);
		file.add(loadBinary);
		
		loadText = new JMenuItem("Load from Text File");
		loadText.addActionListener(listener);
		file.add(loadText);
		
		loadXML = new JMenuItem("Load from XML File");
		loadXML.addActionListener(listener);
		file.add(loadXML);
		
		
		file.addSeparator();
		
		
		saveBinary = new JMenuItem("Save as Binary File");
		saveBinary.addActionListener(listener);
		file.add(saveBinary);
		
		saveText = new JMenuItem("Save as Text File");
		saveText.addActionListener(listener);
		file.add(saveText);
		
		saveXML = new JMenuItem("Save as XML File");
		saveXML.addActionListener(listener);
		file.add(saveXML);
		
		
		file.addSeparator();
		
		
		exit = new JMenuItem("Exit");
		exit.addActionListener(listener);
		file.add(exit);
		
		
		//Edit:
		createAccount = new JMenuItem("Start new Account");
		createAccount.addActionListener(listener);
		edit.add(createAccount);
		
		deleteAccount = new JMenuItem("Delete an Account");
		deleteAccount.addActionListener(listener);
		edit.add(deleteAccount);
		
		updateAccount = new JMenuItem("Update an Account");
		updateAccount.addActionListener(listener);
		edit.add(updateAccount);
		
		
		//Sort:
		sortNumber = new JMenuItem("Sort by Account Number");
		sortNumber.addActionListener(listener);
		sort.add(sortNumber);
		
		sortOwner = new JMenuItem("Sort by Account Owner");
		sortOwner.addActionListener(listener);
		sort.add(sortOwner);
		
		sortDate = new JMenuItem("Sort by Date Opened");
		sortDate.addActionListener(listener);
		sort.add(sortDate);
		
		
	}
	
	public static void main(String[] args){
		
		BankGUI bank = new BankGUI();
		
		bank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bank.setTitle("Bank Program");
		
		bank.setPreferredSize(new Dimension(640, 480));
		
		bank.setJMenuBar(fileBar);
		
		bank.add(programPannel);
		
		bank.setResizable(false);
		bank.pack();
		bank.setVisible(true);
	}
	
   // declare GUI components (menu items, buttons, etc.) needed
   
   // constructor method that prepares the GUI

   // event handlers and other methods needed to build the GUI
	
	
	
	private class FileListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			//All of the events; we can delete the print statements
			//whenever; they're just there to make sure buttons work.

			//load binary file
			if (arg0.getSource() == loadBinary) {
				System.out.println("Clicked: " + arg0.getSource());
			}

			//load text file
			if (arg0.getSource() == loadText) {
				System.out.println("Clicked: " + arg0.getSource());
			}

			//load XML file
			if (arg0.getSource() == loadXML) {
				System.out.println("Clicked: " + arg0.getSource());
			}

			//save binary file
			if (arg0.getSource() == saveBinary) {
				System.out.println("Clicked: " + arg0.getSource());
			}

			//save text file
			if (arg0.getSource() == saveText) {
				System.out.println("Clicked: " + arg0.getSource());
			}

			//save XML file
			if (arg0.getSource() == saveXML) {
				System.out.println("Clicked: " + arg0.getSource());
			}

			//create a new bank account
			if (arg0.getSource() == createAccount) {
				System.out.println("Clicked: " + arg0.getSource());
			}
			
			//delete an existing bank account
			if (arg0.getSource() == deleteAccount) {
				System.out.println("Clicked: " + arg0.getSource());
			}
			
			//update an existing account
			if (arg0.getSource() == updateAccount) {
				System.out.println("Clicked: " + arg0.getSource());
			}
			
			//sort table by account number
			if (arg0.getSource() == sortNumber) {
				System.out.println("Clicked: " + arg0.getSource());
			}
			
			//sort table by account owner
			if (arg0.getSource() == sortOwner) {
				System.out.println("Clicked: " + arg0.getSource());
			}
			
			//sort table by date opened
			if (arg0.getSource() == sortDate) {
				System.out.println("Clicked: " + arg0.getSource());
			}
			
			//Exit the Program
			if (arg0.getSource() == exit) {
				System.exit(0);
			}

		}

	}
	
	
	
}