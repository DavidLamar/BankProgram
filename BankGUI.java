package BankProgram;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.*;

public class BankGUI extends JFrame {

	//Instance Variables
	private static JPanel programPannel;
	private static JMenuBar fileBar;

	//list
	BankModel bModel;
	private JList list;

	private JScrollPane listScroller;

	//menu
	private JMenu file, edit, sort;
	private JMenuItem loadBinary, loadText, loadXML, saveBinary, 
	saveText, saveXML, exit, createAccount, deleteAccount, 
	updateAccount, sortNumber, sortOwner, sortDate;
	
	
	
	public BankGUI(){
		//Set up the panels and stuff we need to make everything appear
		programPannel = new JPanel();
		fileBar = new JMenuBar();
		
		//I know we'll need this later, but it's currently unused.
		bModel = new BankModel(this);

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
		//TODO - Make different JMenuItems for different account types?
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

		
		//set up the JList
		list = new JList(bModel); //data has type Object[]
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);

		//Scroll pane
		listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(630, 410));

		programPannel.add(listScroller);
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
	
	private class FileListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			//All of the events; we can delete the print statements
			//whenever; they're just there to make sure buttons work.

//*****************************Load************************************
			//load binary file
			if (arg0.getSource() == loadBinary) {
				bModel.loadBinary("BinaryFile");
			}

			//load text file
			if (arg0.getSource() == loadText) {
				bModel.loadText("TextFile");
			}

			//load XML file
			if (arg0.getSource() == loadXML) {
				bModel.loadXML("XMLFile");
			}

			
//*****************************Save************************************
			//save binary file
			if (arg0.getSource() == saveBinary) {
				bModel.saveBinary("BinaryFile");
			}

			//save text file
			if (arg0.getSource() == saveText) {
				bModel.saveText("TextFile");
			}

			//save XML file
			if (arg0.getSource() == saveXML) {
				bModel.saveXML("XMLFile");
			}

			
//****************************Accounts*********************************
			//create a new bank account
			if (arg0.getSource() == createAccount) {
				//TODO - we need the input dialog here

				//temp add for testing
				//bModel.addAccount(new CheckingAccount(123, "not Marc", new GregorianCalendar(), 12345, 1));
				
				Account act = null;
				JPanel jp = new DialogBox(act);
				
				Object[] options = {"Create Account", "Cancel"};
				JOptionPane.showOptionDialog(null, jp, "Add an Account", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
				
				//bModel.addAccount(act);
			}
			
			//delete an existing bank account
			if (arg0.getSource() == deleteAccount) {

				if (!list.isSelectionEmpty()) {
					bModel.deleteAccount(list.getAnchorSelectionIndex());
				}
				list.clearSelection();
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