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
	double balance;
	// possible monthly savings, calculated using monthly income (most recent)
	// assuming the data we have is for one year, and monthly and biweekly expenses,
	// here you can assume yearly expenses that are recorded have already been paid.
	double monthlysavings;

	// should add constructor(s)
	User(String username, String pwd) {
		this.username = username;
		this.pwd = pwd;
	}

	public double getBalance() {
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
		boolean isValid;
		String regex;
		regex = "^([\\w\\d\\S]){8,12}$";
//		regex = "^([\\w\\d]){6,8}$";
		if (!Pattern.matches(regex, regexEntered)) {
			return false;
		}

		return true;
	}
	
	
}
