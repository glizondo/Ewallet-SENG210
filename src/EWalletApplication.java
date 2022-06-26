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
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class EWalletApplication {

	private JFrame frameLogin;
	private JFrame frameMainMenu;
	private JFrame frameAddExpense;
	private JFrame frameAddIncome;
	private ArrayList<User> AllData = new ArrayList<User>();
	private ExpenseCalculator expenseCalc;
	private JLabel msgLbl;
	private JTextField usernameField;
	private JTextField pwdField;
	private JButton loginBtn;
	private JButton addExpBtn;
	private JTextField sourceField;
	private JTextField IncSourceField;
	private JTextField amountField;
	private JTextField IncAmountField;
	private JTextField freqField;
	private JLabel sourceLbl;
	private JLabel amountLbl;
	private JLabel IncSourceLbl;
	private JLabel IncAmountLbl;
	private JLabel freqLbl;
	private JButton enterAddExpenseBtn;
	private JButton incEnterBtn;
	private JTextField textFieldCurrentBalance;
	private JButton buttonConvertToDollars;
	private JButton incomeBtn;
	private JButton incReport;
	private JButton expReport;

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
//		frame for login with credentials. Closes after being logged in
		frameLogin = new JFrame();
		frameLogin.getContentPane().setFont(new Font("Perpetua", Font.PLAIN, 11));
		frameLogin.setBounds(100, 100, 800, 600);
		frameLogin.getContentPane().setLayout(null);
//		frame for the main menu where the user can add expenses, incomes and check balance
		frameMainMenu = new JFrame();
		frameMainMenu.getContentPane().setFont(new Font("Perpetua", Font.PLAIN, 11));
		frameMainMenu.setBounds(100, 100, 800, 600);
		frameMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMainMenu.getContentPane().setLayout(null);
//		frame to specially add expenses, closes once one is added
		frameAddExpense = new JFrame();
		frameAddExpense.getContentPane().setFont(new Font("Perpetua", Font.PLAIN, 11));
		frameAddExpense.setBounds(100, 100, 800, 600);
		frameAddExpense.getContentPane().setLayout(null);
//		frame for adding income
		frameAddIncome = new JFrame();
		frameAddIncome.getContentPane().setFont(new Font("Perpetua", Font.PLAIN, 11));
		frameAddIncome.setBounds(100, 100, 800, 600);
		frameAddIncome.getContentPane().setLayout(null);

		msgLbl = new JLabel("Welcome to EWallet! Please create a user.");
		msgLbl.setVerticalAlignment(SwingConstants.TOP);
		msgLbl.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		msgLbl.setBounds(20, 0, 291, 44);
		frameLogin.getContentPane().add(msgLbl);

		usernameField = new JTextField();
		usernameField.setText("username");
		usernameField.setBounds(145, 104, 140, 20);
		frameLogin.getContentPane().add(usernameField);
		usernameField.setColumns(10);

		pwdField = new JTextField();
		pwdField.setText("password");
		pwdField.setBounds(145, 135, 140, 20);
		frameLogin.getContentPane().add(pwdField);
		pwdField.setColumns(10);

		JLabel labelCurrentBalance = new JLabel("Current Balance");
		labelCurrentBalance.setFont(new Font("Perpetua", Font.PLAIN, 12));
		labelCurrentBalance.setBounds(145, 44, 89, 14);
		frameMainMenu.getContentPane().add(labelCurrentBalance);

		textFieldCurrentBalance = new JTextField();
		textFieldCurrentBalance.setEditable(true);
		textFieldCurrentBalance.setBounds(224, 42, 107, 20);
		frameMainMenu.getContentPane().add(textFieldCurrentBalance);
		textFieldCurrentBalance.setColumns(10);

		buttonConvertToDollars = new JButton("Dollars");
		buttonConvertToDollars.setFont(new Font("Perpetua", Font.PLAIN, 12));
		buttonConvertToDollars.setBounds(341, 70, 115, 20);
		frameMainMenu.getContentPane().add(buttonConvertToDollars);
		buttonConvertToDollars.setEnabled(false);

		JButton buttonConvertToEuros = new JButton("Euros");
		buttonConvertToEuros.setFont(new Font("Perpetua", Font.PLAIN, 12));
		buttonConvertToEuros.setBounds(341, 43, 115, 20);
		frameMainMenu.getContentPane().add(buttonConvertToEuros);

		addExpBtn = new JButton("Add an Expense");
		addExpBtn.setFont(new Font("Perpetua", Font.PLAIN, 12));

		addExpBtn.setBounds(20, 42, 107, 31);
		frameMainMenu.getContentPane().add(addExpBtn);

		sourceField = new JTextField();
		sourceField.setBounds(203, 82, 107, 20);
		frameAddExpense.getContentPane().add(sourceField);
		sourceField.setColumns(10);

		amountField = new JTextField();
		amountField.setBounds(203, 113, 107, 20);
		frameAddExpense.getContentPane().add(amountField);
		amountField.setColumns(10);

		freqField = new JTextField();
		freqField.setBounds(203, 144, 107, 20);
		frameAddExpense.getContentPane().add(freqField);
		freqField.setColumns(10);

		sourceLbl = new JLabel("Source of Expense");
		sourceLbl.setFont(new Font("Perpetua", Font.PLAIN, 12));
		sourceLbl.setBounds(103, 85, 99, 14);
		frameAddExpense.getContentPane().add(sourceLbl);

		amountLbl = new JLabel("Amount");
		amountLbl.setFont(new Font("Perpetua", Font.PLAIN, 12));
		amountLbl.setBounds(103, 116, 46, 14);
		frameAddExpense.getContentPane().add(amountLbl);

		freqLbl = new JLabel("Yearly frequency");
		freqLbl.setFont(new Font("Perpetua", Font.PLAIN, 12));
		freqLbl.setBounds(103, 147, 90, 14);
		frameAddExpense.getContentPane().add(freqLbl);

		enterAddExpenseBtn = new JButton("ENTER");
		enterAddExpenseBtn.setFont(new Font("Stencil", Font.PLAIN, 15));

		expReport = new JButton("Expense Report"); // expense report button
		expReport.setFont(new Font("Stencil", Font.PLAIN, 10));
		expReport.setVisible(false);

		// setting expense report button
		expReport.setBounds(322, 250, 115, 28);
		frameAddExpense.getContentPane().add(expReport);
	

		//// Feature 5 -- Creating the Expense report button
		enterAddExpenseBtn.setBounds(335, 222, 89, 28);
		frameAddExpense.getContentPane().add(enterAddExpenseBtn);

		//// Feature 3 -- creating an income button
		incomeBtn = new JButton("Add an Income"); // creating the income button
		incomeBtn.setFont(new Font("Perpetua", Font.PLAIN, 11)); // setting font size and font for btn
		incomeBtn.setBounds(20, 92, 107, 31); // creating the size of button
		frameMainMenu.getContentPane().add(incomeBtn); // adding button to stage

		// creating the income source field
		IncSourceField = new JTextField();
		IncSourceField.setBounds(203, 82, 107, 20);
		frameAddIncome.getContentPane().add(IncSourceField);
		IncSourceField.setColumns(10);

		// creating the income source label
		IncSourceLbl = new JLabel("Source of Income");
		IncSourceLbl.setFont(new Font("Perpetua", Font.PLAIN, 12));
		IncSourceLbl.setBounds(103, 85, 99, 14);
		frameAddIncome.getContentPane().add(IncSourceLbl);

		// Income Amount field creating the field, size and adding to stage
		IncAmountField = new JTextField();
		IncAmountField.setBounds(203, 113, 107, 20);
		frameAddIncome.getContentPane().add(IncAmountField);
		IncAmountField.setColumns(10);
		
		IncAmountLbl = new JLabel("Amount");
		IncAmountLbl.setFont(new Font("Perpetua", Font.PLAIN, 12));
		IncAmountLbl.setBounds(103, 116, 46, 14);
		frameAddIncome.getContentPane().add(IncAmountLbl);

		// Creating the income enter button
		incEnterBtn = new JButton("ENTER");
		incEnterBtn.setFont(new Font("Stencil", Font.PLAIN, 15));

		// Creating the income enter button
		incReport = new JButton("Income Report");
		incReport.setFont(new Font("Stencil", Font.PLAIN, 10));
		incReport.setVisible(false);

		
		loginBtn = new JButton("ENTER");
		loginBtn.setFont(new Font("Stencil", Font.PLAIN, 15));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameMainMenu.setVisible(true);
				frameLogin.setVisible(false);
				msgLbl.setText("Welcome " + usernameField.getText() + "! What would you like to do?");
				CreateUser(usernameField.getText(), pwdField.getText());
				expenseCalc = new ExpenseCalculator(AllData.get(AllData.size() - 1));
				
			}
		});
		loginBtn.setBounds(335, 219, 89, 31);
		frameLogin.getContentPane().add(loginBtn);
		
		addExpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameAddExpense.setVisible(true);
				msgLbl.setText("<html>Please add the source, amount and yearly frequency of your Expense.<html>");
				expenseCalc = new ExpenseCalculator(AllData.get(AllData.size() - 1));
			}

		});
		
		enterAddExpenseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Expense expense = new Expense(sourceField.getText(), Double.parseDouble(amountField.getText()),
						Integer.parseInt(freqField.getText()));
				expenseCalc.addExpense(expense);
				msgLbl.setText("");
				frameAddExpense.setVisible(false);
				expenseCalc.updateMonthlySavings();
			}

		});
		
		incomeBtn.addActionListener(new ActionListener() { // when button clicked do...
			public void actionPerformed(ActionEvent e) {
				frameAddIncome.setVisible(true);
				msgLbl.setText("<html>Please add the source and amount of your income.<html>"); // message on stage
				// expenseCalc = new ExpenseCalculator(AllData.get(AllData.size() - 1));
		}
		});
		// setting the stage for the income enter button
		incEnterBtn.setBounds(335, 222, 89, 28);
		frameAddIncome.getContentPane().add(incEnterBtn);
		
		// when income enter is pressed do the following
		incEnterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msgLbl.setText("income added"); // create a message on stage
				Wage wage = new Wage(IncSourceField.getText(), Double.parseDouble(IncAmountField.getText()));
				expenseCalc.addMonthlyIncome(wage);
				frameAddIncome.setVisible(false);
				expenseCalc.updateMonthlySavings();
	
			}
		});
		
		
		// when income report is pressed do the following
		incReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msgLbl.setText("this is the income report"); // create a message on stage

			}
		});
		// setting the stage for the income report button
		incReport.setBounds(322, 250, 115, 28);
		frameLogin.getContentPane().add(incReport);

		// when Expense report is pressed do the following
		expReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msgLbl.setText("Users Expense report"); // message
				System.out.print(expenseCalc.PrintExpensereport());
			}
		});

		
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

	}

	public void CreateUser(String username, String password) {
		User newUser = new User(username, password);
		AllData.add(newUser);
	}
}
