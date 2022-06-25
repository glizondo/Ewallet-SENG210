
public class ExpenseCalculator implements Expenser {
	User user;

	ExpenseCalculator(User user) {
		this.user = user;
	}

	@Override
	public void addExpense(Expense Ex) {
		// TODO Auto-generated method stub
		user.Spending.add(Ex);
	}

	@Override
	public void addMonthlyIncome(Wage W) {
		// TODO Auto-generated method stub

	}

	@Override
	public void PrintFullreport() {
		// TODO Auto-generated method stub
		
	}	


	@Override
	public String PrintExpensereport() {
		
		String str = "User's Expenses:\n";
		
		for (Expense ex : user.GetExpenses()) { //get expenses for report
			str += ex.toString() + "\n";
		}
		
		return str;

	}

	@Override
	public String PrintIncomereport() {
		String str = "User's Income Report:\n";
		
		for (Wage ex : user.getIncome()) { //get Income for report
			str += ex.toString() + "\n";
		}
		
		return str;

	}

	@Override
	public void PrintIncomereportbyTpe() {
		// TODO Auto-generated method stub

	}

	@Override
	public void PrintExpensebyType() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exportReport(String reportTitle) {
		// TODO Auto-generated method stub

	}

	@Override
	public Currency convertForeignCurrency(Currency C, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loadExpenseFile(String filePath) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean loadIncomeFile(String filePath) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int whenCanIBuy(String itemname, double price) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateMonthlySavings() {
		// TODO Auto-generated method stub

	}

}
