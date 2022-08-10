import java.util.ArrayList;
import java.util.regex.Pattern;

public class User {
	ArrayList<Currency> currencyRates = new ArrayList<Currency>();
	ArrayList<Wage> Income = new ArrayList<Wage>(); // user income sources that user can record or view or
	// search by type or month
	ArrayList<Expense> Spending = new ArrayList<Expense>(); // user's expenses
	String username;
	String pwd;
	// current total income - total
	Double balance;
	// possible monthly savings, calculated using monthly income (most recent)
	// assuming the data we have is for one year, and monthly and biweekly expenses,
	// here you can assume yearly expenses that are recorded have already been paid.
	double monthlysavings;

	// should add constructor(s)
	User(String username, String pwd) {
		this.username = username;
		this.pwd = pwd;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMonthlysavings() {
		return monthlysavings;
	}

	public void setMonthlysavings(double monthlysavings) {
		this.monthlysavings = monthlysavings;
	}

	public boolean checkValidPassword(String regexEntered) {
		String regexPassword;
		regexPassword = "^([\\w\\d\\S]){8,12}$";
		if (!Pattern.matches(regexPassword, regexEntered)) {
			return false;
		}

		return true;
	}

	public boolean checkRegexUsername(String username) {
		String regexUsername;
		regexUsername = "^([\\w\\d]){6,8}$";
		if (!Pattern.matches(regexUsername, username)) {
			return false;
		}
		return true;
	}
	
	

}
