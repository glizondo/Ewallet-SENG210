import java.util.ArrayList;

public class User {
	private ArrayList <Currency>currencyRates = new ArrayList<Currency>();
	private ArrayList <Wage>Income = new ArrayList<Wage>();  // user income sources that user can record or view or search by type or month 
	ArrayList <Expense>Spending = new ArrayList<Expense>(); //user's expenses 
	String username;
	String pwd;
	//current total income - total 
	double balance;
	// possible monthly savings, calculated using monthly income (most recent) assuming the data we have is for one year, and monthly and biweekly expenses, here you can assume yearly expenses that are recorded have already been paid. 
	double monthlysavings;	
	//should add constructor(s)
	User(String username,String pwd){
		this.username = username;
		this.pwd = pwd;
	}
	public Expense[] GetExpenses() {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList <Wage> getIncome() {
		return Income;
	}
	public void setIncome(ArrayList <Wage> income) {
		Income = income;
	}
	
}
