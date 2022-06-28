import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class EWalletApplication {

	private JFrame frameLogin;
	private JFrame frameMainMenu;
	private JFrame frameAddExpense;
	private JFrame frameAddIncome;
	private JFrame frameExpReport;
	private JFrame frameIncReport;
	private JFrame FrameDetailIncReport;
	private ArrayList<User> AllData = new ArrayList<User>();
	private ExpenseCalculator expenseCalc;
	private JLabel msgLbl;
	private JLabel IncDetReportLabel;	
	private JTextField usernameField;
	private JTextField pwdField;
	private JButton loginBtn;
	private JButton addExp;
	private JTextField expSourceField;
	private JTextField expAmountField;
	private JTextField expFreqField;
	private JLabel expSourceLbl;
	private JLabel expAmountLbl;
	private JLabel expFreqLbl;
	private JButton expEnter;
	private JButton expReport;
	private JButton addInc;
	private JTextField incSourceField;
	private JTextField incAmountField;
	private JLabel incSourceLbl;
	private JLabel incAmountLbl;
	private JButton incEnter;
	private JButton incReport;
	private JLabel labelCurrentBalance;
	private JTextField textFieldCurrentBalance;
	private JButton buttonConvertToDollars;
	private JButton buttonConvertToEuros;
	private JLabel reportLbl;
	private JButton detailIncReport;
	private User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EWalletApplication window = new EWalletApplication();
					window.frameLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EWalletApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frameLogin.
	 */
	private void initialize() {

		// frame for login with credentials. Closes after being logged in
		frameLogin = new JFrame();
		frameLogin.getContentPane().setFont(new Font("Perpetua", Font.PLAIN, 11));
		frameLogin.setTitle("Login");
		frameLogin.setBounds(100, 100, 475, 300);
		frameLogin.getContentPane().setLayout(null);

		// frame for the main menu where the user can add expenses, incomes and check
		// balance
		frameMainMenu = new JFrame();
		frameMainMenu.getContentPane().setFont(new Font("Perpetua", Font.PLAIN, 11));
		frameMainMenu.setTitle("Main Menu");
		frameMainMenu.setBounds(100, 100, 485, 300);
		frameMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMainMenu.getContentPane().setLayout(null);

		// frame for adding expense, closes once one is added
		frameAddExpense = new JFrame();
		frameAddExpense.getContentPane().setFont(new Font("Perpetua", Font.PLAIN, 11));
		frameAddExpense.setTitle("Expenses");
		frameAddExpense.setBounds(100, 100, 485, 300);
		frameAddExpense.getContentPane().setLayout(null);

		// frame for adding income, closes once one is added
		frameAddIncome = new JFrame();
		frameAddIncome.getContentPane().setFont(new Font("Perpetua", Font.PLAIN, 11));
		frameAddIncome.setTitle("Incomes");
		frameAddIncome.setBounds(100, 100, 485, 300);
		frameAddIncome.getContentPane().setLayout(null);

		// frame for expense report
		frameExpReport = new JFrame();
		frameExpReport.getContentPane().setFont(new Font("Perpetua", Font.PLAIN, 11));
		frameExpReport.setTitle("Expense Report");
		frameExpReport.setBounds(100, 100, 485, 300);
		frameExpReport.getContentPane().setLayout(null);

		// frame for income report
		frameIncReport = new JFrame();
		frameIncReport.getContentPane().setFont(new Font("Perpetua", Font.PLAIN, 11));
		frameIncReport.setTitle("Expense Report");
		frameIncReport.setBounds(100, 100, 485, 300);
		frameIncReport.getContentPane().setLayout(null);

		
		//frame for detailed income report 
		FrameDetailIncReport = new JFrame();
		FrameDetailIncReport.getContentPane().setFont(new Font("Perpetua", Font.PLAIN, 11));
		FrameDetailIncReport.setTitle("Expense Report");
		FrameDetailIncReport.setBounds(100, 100, 485, 300);
		FrameDetailIncReport.getContentPane().setLayout(null);
		
		
		//creating the dynamic message label


		// creating the dynamic message label
		msgLbl = new JLabel("Welcome to EWallet! Please create a user.");
		msgLbl.setVerticalAlignment(SwingConstants.TOP);
		msgLbl.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		msgLbl.setBounds(10, 0, 414, 261);
		frameLogin.getContentPane().add(msgLbl);

		// creating the username field
		usernameField = new JTextField();
		usernameField.setText("username");
		usernameField.setBounds(145, 104, 140, 20);
		frameLogin.getContentPane().add(usernameField);
		usernameField.setColumns(10);

		// creating the password field
		pwdField = new JTextField();
		pwdField.setText("password");
		pwdField.setBounds(145, 135, 140, 20);
		frameLogin.getContentPane().add(pwdField);
		pwdField.setColumns(10);

		// creating the login button
		loginBtn = new JButton("ENTER");
		loginBtn.setFont(new Font("Stencil", Font.PLAIN, 15));
		loginBtn.setBounds(360, 219, 89, 31);
		frameLogin.getContentPane().add(loginBtn);

		// creating the current balance label
		labelCurrentBalance = new JLabel("Current Balance");
		labelCurrentBalance.setFont(new Font("Perpetua", Font.PLAIN, 12));
		labelCurrentBalance.setBounds(145, 44, 89, 14);
		frameMainMenu.getContentPane().add(labelCurrentBalance);

		// creating the current balance field
		textFieldCurrentBalance = new JTextField();
		textFieldCurrentBalance.setEditable(true);
		textFieldCurrentBalance.setBounds(224, 42, 107, 20);
		frameMainMenu.getContentPane().add(textFieldCurrentBalance);
		textFieldCurrentBalance.setColumns(10);

		// creating the dollar conversion button
		buttonConvertToDollars = new JButton("Dollars");
		buttonConvertToDollars.setFont(new Font("Perpetua", Font.PLAIN, 12));
		buttonConvertToDollars.setBounds(341, 70, 115, 20);
		frameMainMenu.getContentPane().add(buttonConvertToDollars);
		buttonConvertToDollars.setEnabled(false);

		// creating the euro conversion button
		buttonConvertToEuros = new JButton("Euros");
		buttonConvertToEuros.setFont(new Font("Perpetua", Font.PLAIN, 12));
		buttonConvertToEuros.setBounds(341, 43, 115, 20);
		frameMainMenu.getContentPane().add(buttonConvertToEuros);

		// creating the expense source field
		expSourceField = new JTextField();
		expSourceField.setBounds(203, 82, 107, 20);
		frameAddExpense.getContentPane().add(expSourceField);
		expSourceField.setColumns(10);

		// creating the expense amount field
		expAmountField = new JTextField();
		expAmountField.setBounds(203, 113, 107, 20);
		frameAddExpense.getContentPane().add(expAmountField);
		expAmountField.setColumns(10);

		// creating the expense frequency field
		expFreqField = new JTextField();
		expFreqField.setBounds(203, 144, 107, 20);
		frameAddExpense.getContentPane().add(expFreqField);
		expFreqField.setColumns(10);

		// creating the expense source label
		expSourceLbl = new JLabel("Source of Expense");
		expSourceLbl.setFont(new Font("Perpetua", Font.PLAIN, 12));
		expSourceLbl.setBounds(103, 85, 99, 14);
		frameAddExpense.getContentPane().add(expSourceLbl);

		// creating the expense amount label
		expAmountLbl = new JLabel("Amount");
		expAmountLbl.setFont(new Font("Perpetua", Font.PLAIN, 12));
		expAmountLbl.setBounds(103, 116, 46, 14);
		frameAddExpense.getContentPane().add(expAmountLbl);

		// creating the expense frequency label
		expFreqLbl = new JLabel("Yearly frequency");
		expFreqLbl.setFont(new Font("Perpetua", Font.PLAIN, 12));
		expFreqLbl.setBounds(103, 147, 90, 14);
		frameAddExpense.getContentPane().add(expFreqLbl);

		// creating the income source field
		incSourceField = new JTextField();
		incSourceField.setBounds(203, 82, 107, 20);
		frameAddIncome.getContentPane().add(incSourceField);
		incSourceField.setColumns(10);

		// creating the income source label
		incSourceLbl = new JLabel("Source of Income");
		incSourceLbl.setFont(new Font("Perpetua", Font.PLAIN, 12));
		incSourceLbl.setBounds(103, 85, 99, 14);
		frameAddIncome.getContentPane().add(incSourceLbl);

		// creating the income amount field
		incAmountField = new JTextField();
		incAmountField.setBounds(203, 113, 107, 20);
		frameAddIncome.getContentPane().add(incAmountField);
		incAmountField.setColumns(10);

		// creating the income amount label
		incAmountLbl = new JLabel("Amount");
		incAmountLbl.setFont(new Font("Perpetua", Font.PLAIN, 12));
		incAmountLbl.setBounds(103, 116, 46, 14);
		frameAddIncome.getContentPane().add(incAmountLbl);

		// creating the expense addition button
		addExp = new JButton("Add an Expense");
		addExp.setFont(new Font("Perpetua", Font.PLAIN, 12));
		addExp.setBounds(20, 42, 107, 31);
		frameMainMenu.getContentPane().add(addExp);

		// creating the expense addition enter button
		expEnter = new JButton("ENTER");
		expEnter.setFont(new Font("Stencil", Font.PLAIN, 15));
		expEnter.setBounds(360, 194, 89, 28);
		frameAddExpense.getContentPane().add(expEnter);

		// creating the expense report button
		expReport = new JButton("Expense Report");
		expReport.setFont(new Font("Stencil", Font.PLAIN, 10));
		expReport.setVisible(true);
		expReport.setBounds(327, 222, 122, 28);
		frameAddExpense.getContentPane().add(expReport);

		// creating the income addition button
		addInc = new JButton("Add an Income");
		addInc.setFont(new Font("Perpetua", Font.PLAIN, 11));
		addInc.setBounds(20, 92, 107, 31);
		frameMainMenu.getContentPane().add(addInc);
		
		//creating the income addition enter button
		incEnter = new JButton("Add An Income");
		incEnter.setFont(new Font("Stencil", Font.PLAIN, 10));
		incEnter.setBounds(326, 105, 123, 28);
		frameAddIncome.getContentPane().add(incEnter);
		
		//Creating the detailed income button
		detailIncReport = new JButton("Report By Type");
		detailIncReport.setFont(new Font("Stencil", Font.PLAIN, 10));
		detailIncReport.setBounds(326, 193, 123, 28);
		frameAddIncome.getContentPane().add(detailIncReport);
		
		//creating the income report button
		JButton detailedReportBtn = new JButton("Detailed Report");
		detailedReportBtn.setFont(new Font("Perpetua", Font.PLAIN, 11));
		detailedReportBtn.setBounds(20, 145, 107, 31);
		frameMainMenu.getContentPane().add(detailedReportBtn);

		// creating the income addition enter button
		incEnter = new JButton("ENTER");
		incEnter.setFont(new Font("Stencil", Font.PLAIN, 15));
		incEnter.setBounds(360, 193, 89, 28);
		frameAddIncome.getContentPane().add(incEnter);

		// creating the income report button
		incReport = new JButton("Income Report");
		incReport.setFont(new Font("Stencil", Font.PLAIN, 10));
		incReport.setBounds(326, 222, 123, 28);
		frameAddIncome.getContentPane().add(incReport);

		// creating the report label (user for expense and income reports)
		reportLbl = new JLabel("");
		reportLbl.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		reportLbl.setVerticalAlignment(SwingConstants.TOP);
		reportLbl.setBounds(10, 11, 449, 239);
		
		//creating the detailed income report label 
        IncDetReportLabel= new JLabel("");
        IncDetReportLabel.setVerticalAlignment(SwingConstants.TOP);
        IncDetReportLabel.setBounds(10, 170, 400, 100);
		
		//when loginBtn is pressed do the following
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameMainMenu.setVisible(true);
				frameLogin.setVisible(false);
				msgLbl.setText("Welcome " + usernameField.getText() + "! What would you like to do?");
				frameMainMenu.getContentPane().add(msgLbl);
				CreateUser(usernameField.getText(), pwdField.getText());
				expenseCalc = new ExpenseCalculator(AllData.get(AllData.size() - 1));
				expenseCalc.copyInfoToArrayList();
				expenseCalc.updateBalance();
				expenseCalc.updateMonthlySavings();

			}
		});

		// when addExp is pressed do the following
		addExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameAddExpense.setVisible(true);
				msgLbl.setText(
						"<html>Please add the source, amount and yearly frequency of your Expense. Or you can generate an expense report.<html>");
				frameAddExpense.getContentPane().add(msgLbl);
				expenseCalc = new ExpenseCalculator(AllData.get(AllData.size() - 1));
			}

		});

		// when expEnter is pressed do the following
		expEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Expense expense = new Expense(expSourceField.getText(), Double.parseDouble(expAmountField.getText()),
						Integer.parseInt(expFreqField.getText()));
				expenseCalc.addExpense(expense);
				frameAddExpense.setVisible(false);
				expenseCalc.updateMonthlySavings();
				expenseCalc.updateBalance();
				expenseCalc.copyInfoToTextFiles();

			}

		});

		// when expReport is pressed do the following
		expReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reportLbl.setText(expenseCalc.PrintExpensereport());
				frameExpReport.getContentPane().add(reportLbl);
				frameExpReport.setVisible(true);
				frameAddExpense.setVisible(false);
			}
		});

		// when addInc is pressed do the following
		addInc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameAddIncome.setVisible(true);
				msgLbl.setText("<html>Please add the source and amount of your income.<html>");
				frameAddIncome.getContentPane().add(msgLbl);
				expenseCalc = new ExpenseCalculator(AllData.get(AllData.size() - 1));
			}
		});
		
		//when detailIncReport is pressed do the following 
		detailIncReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameDetailIncReport.setVisible(true);
		        FrameDetailIncReport.add(IncDetReportLabel);
				msgLbl.setText("<html>Please select the type of income your want to view. <html>");
				FrameDetailIncReport.getContentPane().add(msgLbl);
				
				//creating the list to pick from 
		        String[] IncOptionsToChoose = {"Salary", "Rental Income", "CashBack", "Gift", "None of the listed"};
		        //setting up the box and button
		        JComboBox<String> IncDropDown = new JComboBox<>(IncOptionsToChoose);
		        IncDropDown.setBounds(80, 50, 140, 20);
		        JButton IncReportDoneBtn = new JButton("Done");
		        IncReportDoneBtn.setBounds(100, 100, 90, 20);
		        FrameDetailIncReport.add(IncReportDoneBtn);
		        FrameDetailIncReport.add(IncDropDown);

		        //when detailed report is clicked 
		        IncReportDoneBtn.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		               String IncReport = IncDropDown.getItemAt(IncDropDown.getSelectedIndex());
		               expenseCalc.PrintIncomereport(); 
		              

		               
		    			switch(IncReport)
		    			{
		    			case "Salary":
		    				System.out.printf("Salary made");
		    				break;
		    			
		    			case "Rental Income":
		    				System.out.printf("rental  made");
		    				break;
		    			case "CashBack":
		    				System.out.printf("cashback made");
		    				break;
		    			case "Gift":
		    				System.out.printf("gift made");
		    				break;
		    			case "None of the listed":
		    				System.out.printf("all others");
		    				break;
		    			
		    			}

		                IncDetReportLabel.setText(expenseCalc.PrintIncomereport());
		            }
		        });

				
				Wage wage = new Wage(incSourceField.getText(), Double.parseDouble(incAmountField.getText()));
				expenseCalc.addMonthlyIncome(wage);
				frameAddIncome.setVisible(false);
				expenseCalc.updateMonthlySavings();
	
			}
		});	
		
		//when incEnter is pressed do the following
		incEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wage wage = new Wage(incSourceField.getText(), Double.parseDouble(incAmountField.getText()));
				expenseCalc.addMonthlyIncome(wage);
				frameAddIncome.setVisible(false);
				expenseCalc.updateMonthlySavings();
				expenseCalc.updateBalance();
				expenseCalc.updateMonthlySavings();
				expenseCalc.copyInfoToTextFiles();

			}
		});

		// when incReport is pressed do the following
		incReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reportLbl.setText(expenseCalc.PrintIncomereport()); // message
				frameIncReport.getContentPane().add(reportLbl);
				frameIncReport.setVisible(true);
				frameAddIncome.setVisible(false);
			}
		});

		// when buttonConvertToEuros is pressed do the following
		buttonConvertToEuros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					buttonConvertToDollars.setEnabled(true);
					Currency currency = new Currency();
					double amount = Double.parseDouble(textFieldCurrentBalance.getText());
					textFieldCurrentBalance.setText(Double.toString(currency.dollarToEuros(amount)));
					buttonConvertToEuros.setEnabled(false);
				} catch (Exception exceptionNotFound) {
					JOptionPane.showMessageDialog(null, "Error converting", "Message", JOptionPane.PLAIN_MESSAGE);
					System.out.println("Error converting");
					buttonConvertToDollars.setEnabled(false);
				}
			}
		});

		// when buttonConvertToDollars is pressed do the following
		buttonConvertToDollars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					buttonConvertToEuros.setEnabled(true);
					Currency currency = new Currency();
					double amount = Double.parseDouble(textFieldCurrentBalance.getText());
					textFieldCurrentBalance.setText(Double.toString(currency.euroToDollars(amount)));
					buttonConvertToDollars.setEnabled(false);
				} catch (Exception exceptionNotFound) {
					JOptionPane.showMessageDialog(null, "Error converting", "Message", JOptionPane.PLAIN_MESSAGE);
					System.out.println("Error converting");
					buttonConvertToDollars.setEnabled(false);
				}
			}
		});
		// when detailedReport is pressed it shows a detailed report
		detailedReportBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reportLbl.setText(expenseCalc.PrintFullreport());
				frameIncReport.getContentPane().add(reportLbl);
				frameIncReport.setVisible(true);
				frameAddIncome.setVisible(false);
			}
		});

	    }

	// method to create user
	public void CreateUser(String username, String password) {
		User newUser = new User(username, password);
		AllData.add(newUser);
	}
}
