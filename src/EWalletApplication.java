import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class EWalletApplication {
	
	private JFrame frame;
	private ArrayList<User> AllData = new ArrayList<User>();
	private ExpenseCalculator expenseCalc;
	private JLabel msgLbl;
	private JTextField usernameField;
	private JTextField pwdField;
	private JButton enter1Btn;
	private JButton addExpBtn;
	private JTextField sourceField;
	private JTextField amountField;
	private JTextField freqField;
	private JLabel sourceLbl;
	private JLabel amountLbl;
	private JLabel freqLbl;
	private JButton enter2Btn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EWalletApplication window = new EWalletApplication();
					window.frame.setVisible(true);
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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Perpetua", Font.PLAIN, 11));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		msgLbl = new JLabel("Welcome to EWallet! Please create a user.");
		msgLbl.setVerticalAlignment(SwingConstants.TOP);
		msgLbl.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		msgLbl.setBounds(10, 0, 414, 73);
		frame.getContentPane().add(msgLbl);
		
		usernameField = new JTextField();
		usernameField.setText("username");
		usernameField.setBounds(145, 104, 140, 20);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		pwdField = new JTextField();
		pwdField.setText("password");
		pwdField.setBounds(145, 135, 140, 20);
		frame.getContentPane().add(pwdField);
		pwdField.setColumns(10);
		
		enter1Btn = new JButton("ENTER");
		enter1Btn.setFont(new Font("Stencil", Font.PLAIN, 15));
		enter1Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameField.setVisible(false);
				pwdField.setVisible(false);
				enter1Btn.setVisible(false);
				msgLbl.setText("Welcome " + usernameField.getText() + "! What would you like to do?");
				CreateUser(usernameField.getText(), pwdField.getText());
				expenseCalc = new ExpenseCalculator(AllData.get(AllData.size() - 1));
				addExpBtn.setVisible(true);
			}
		});
		enter1Btn.setBounds(335, 219, 89, 31);
		frame.getContentPane().add(enter1Btn);
		
		addExpBtn = new JButton("Add an Expense");
		addExpBtn.setFont(new Font("Perpetua", Font.PLAIN, 12));
		addExpBtn.setVisible(false);
		addExpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addExpBtn.setVisible(false);
				sourceField.setVisible(true);
				amountField.setVisible(true);
				freqField.setVisible(true);
				sourceLbl.setVisible(true);
				amountLbl.setVisible(true);
				freqLbl.setVisible(true);
				enter2Btn.setVisible(true);
				msgLbl.setText("<html>Please add the source, amount and yearly frequency of your Expense.<html>");
				expenseCalc = new ExpenseCalculator(AllData.get(AllData.size() - 1));
			}
		});
		addExpBtn.setBounds(20, 42, 107, 31);
		frame.getContentPane().add(addExpBtn);
		
		sourceField = new JTextField();
		sourceField.setBounds(203, 82, 107, 20);
		sourceField.setVisible(false);
		frame.getContentPane().add(sourceField);
		sourceField.setColumns(10);
		
		amountField = new JTextField();
		amountField.setBounds(203, 113, 107, 20);
		amountField.setVisible(false);
		frame.getContentPane().add(amountField);
		amountField.setColumns(10);
		
		freqField = new JTextField();
		freqField.setBounds(203, 144, 107, 20);
		freqField.setVisible(false);
		frame.getContentPane().add(freqField);
		freqField.setColumns(10);
		
		sourceLbl = new JLabel("Source of Expense");
		sourceLbl.setFont(new Font("Perpetua", Font.PLAIN, 12));
		sourceLbl.setBounds(103, 85, 99, 14);
		sourceLbl.setVisible(false);
		frame.getContentPane().add(sourceLbl);
		
		amountLbl = new JLabel("Amount");
		amountLbl.setFont(new Font("Perpetua", Font.PLAIN, 12));
		amountLbl.setBounds(103, 116, 46, 14);
		amountLbl.setVisible(false);
		frame.getContentPane().add(amountLbl);
		
		freqLbl = new JLabel("Yearly frequency");
		freqLbl.setFont(new Font("Perpetua", Font.PLAIN, 12));
		freqLbl.setBounds(103, 147, 90, 14);
		freqLbl.setVisible(false);
		frame.getContentPane().add(freqLbl);
		
		enter2Btn = new JButton("ENTER");
		enter2Btn.setFont(new Font("Stencil", Font.PLAIN, 15));
		enter2Btn.setVisible(false);
		enter2Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sourceField.setVisible(false);
				amountField.setVisible(false);
				freqField.setVisible(false);
				sourceLbl.setVisible(false);
				amountLbl.setVisible(false);
				freqLbl.setVisible(false);
				enter2Btn.setVisible(false);
				Expense expense = new Expense(sourceField.getText(), Double.parseDouble(amountField.getText()), Integer.parseInt(freqField.getText()));
				expenseCalc.addExpense(expense);
				msgLbl.setText("");
			}
		});
		enter2Btn.setBounds(335, 222, 89, 28);
		frame.getContentPane().add(enter2Btn);
	}
	
	public void CreateUser(String username, String password) {
		User newUser = new User(username, password);
		AllData.add(newUser);
	}
}
