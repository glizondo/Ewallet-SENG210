import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class EWalletApplication {
	
	private JFrame frame;
	private ArrayList<User> AllData = new ArrayList<User>();
	private JLabel msgLbl;
	private JTextField usernameField;
	private JTextField pwdField;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		msgLbl = new JLabel("Welcome to EWallet! Please create a user.");
		msgLbl.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		msgLbl.setBounds(10, 0, 414, 31);
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
		
		JButton enterBtn = new JButton("ENTER");
		enterBtn.setFont(new Font("Stencil", Font.PLAIN, 15));
		enterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameField.setVisible(false);
				pwdField.setVisible(false);
				enterBtn.setVisible(false);
				msgLbl.setText("Welcome " + usernameField.getText() + "! What would you like to do?");
				CreateUser(usernameField.getText(), pwdField.getText());
			}
		});
		enterBtn.setBounds(335, 219, 89, 31);
		frame.getContentPane().add(enterBtn);
	}
	
	public void CreateUser(String username, String password) {
		User newUser = new User(username, password);
		newUser.username = username;
		newUser.pwd = password;
		AllData.add(newUser);
	}
}
