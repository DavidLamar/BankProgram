package BankProgram;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class BankGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 700;
	private static final int HEIGHT = 500;
	//Instance Variables
	private static JPanel programPannel;
	private static JMenuBar fileBar;
	

	//table
	BankModel bModel;
	
	private JTable table;

	private JScrollPane listScroller;

	//menu
	private JMenu file, edit, sort;
	private JMenuItem loadBinary, loadText, loadXML, saveBinary, 
	saveText, saveXML, exit, createAccount, deleteAccount, 
	updateAccount, sortNumber, sortOwner, sortDate;
	
	private JPopupMenu editPopup;
	JMenuItem createAccountPopup, deleteAccountPopup, 
	updateAccountPopup, sortNumberPopup, sortOwnerPopup, sortDatePopup;
	
	
	public BankGUI(){
		//Set up the panels and stuff we need to make everything appear
		programPannel = new JPanel();
		fileBar = new JMenuBar();
		
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

		
//		//set up the JList
//		list = new JList(bModel); //data has type Object[]
//		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//		list.setLayoutOrientation(JList.VERTICAL);
//		list.setVisibleRowCount(-1);

		
		//Set up the table
		table = new JTable(bModel); //modify bModel later to make it work correctly
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		table.setVisible(true);
		table.addMouseListener(new MouseMenuListener() );
		
		
		//Set up right click menu stuff:
		editPopup = new JPopupMenu();
		//createAccountPopup, deleteAccountPopup, 
		//updateAccountPopup, sortNumberPopup, sortOwnerPopup, sortDatePopup;
		createAccountPopup = new JMenuItem("Create new Account");
		createAccountPopup.addActionListener(listener);
		
		deleteAccountPopup = new JMenuItem("Delete Selected Account");
		deleteAccountPopup.addActionListener(listener);
		
		updateAccountPopup = new JMenuItem("Update Selected Account");
		updateAccountPopup.addActionListener(listener);
		
		sortNumberPopup = new JMenuItem("Sort by Account Number");
		sortNumberPopup.addActionListener(listener);
		
		sortOwnerPopup = new JMenuItem("Sort by Account Owner");
		sortOwnerPopup.addActionListener(listener);
		
		sortDatePopup = new JMenuItem("Sort by Date Opened");
		sortDatePopup.addActionListener(listener);
		
		
		editPopup.add(createAccountPopup);
		editPopup.add(deleteAccountPopup);
		editPopup.add(updateAccountPopup);
		editPopup.addSeparator();
		editPopup.add(sortNumberPopup);
		editPopup.add(sortOwnerPopup);
		editPopup.add(sortDatePopup);
		
		//Scroll pane
		listScroller = new JScrollPane(table);
		listScroller.setPreferredSize(new Dimension(WIDTH-10, HEIGHT - 70));

		programPannel.add(listScroller);
		
	}
	
	public static void main(String[] args){
		
		BankGUI bank = new BankGUI();
		
		bank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bank.setTitle("Bank Program");
		
		bank.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
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
			if (arg0.getSource() == createAccount || arg0.getSource() == createAccountPopup) {
				bModel.addAccount();
			}
			
			//delete an existing bank account
			if (arg0.getSource() == deleteAccount || arg0.getSource() == deleteAccountPopup) {

				if (table.getSelectedRow() != -1) {
					bModel.deleteAccount(table.getSelectedRow());
				}
				table.clearSelection();
			}
			
			//update an existing account
			if (arg0.getSource() == updateAccount || arg0.getSource() == updateAccountPopup) {
				if (table.getSelectedRow() != -1) {
					bModel.updateAccount(table.getSelectedRow());
				}
			}
			
			
			//sort table by account number
			if (arg0.getSource() == sortNumber || arg0.getSource() == sortNumberPopup) {
				bModel.sortAccountNumber();
			}
			
			//sort table by account owner
			if (arg0.getSource() == sortOwner || arg0.getSource() == sortOwnerPopup) {
				bModel.sortOwner();
			}
			
			//sort table by date opened
			if (arg0.getSource() == sortDate || arg0.getSource() == sortDatePopup) {
				bModel.sortDate();
			}
			
			//Exit the Program
			if (arg0.getSource() == exit) {
				System.exit(0);
			}

		}

	}
	
	private class MouseMenuListener extends MouseAdapter {
		
		public void mousePressed(MouseEvent ev) {
	        if (ev.isPopupTrigger()) {
	        	int row = table.rowAtPoint(ev.getPoint());
	        	table.clearSelection();
	        	table.changeSelection(row, 0, false, false);
	          editPopup.show(ev.getComponent(), ev.getX(), ev.getY());
	        }
	      }

		
	      public void mouseReleased(MouseEvent ev) {
	        if (ev.isPopupTrigger()) {
	        	int row = table.rowAtPoint(ev.getPoint());
	        	table.clearSelection();
	        	table.changeSelection(row, 0, false, false);
	        	editPopup.show(ev.getComponent(), ev.getX(), ev.getY());
	        }
	      }
	}
	
}