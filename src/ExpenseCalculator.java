import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseCalculator implements Expenser {
	User user;
	FileInputStream fileReaderBalance;
	Scanner readerBalance;
	FileOutputStream fileStream;
	PrintWriter fileWriter;

	ExpenseCalculator(User user) {
		this.user = user;
	}

	@Override
	public void addExpense(Expense Ex) {
		user.Spending.add(Ex);

		try {
			fileStream = new FileOutputStream("Expenses.txt");
			fileWriter = new PrintWriter(fileStream);
			for (int i = 0; i < user.Spending.size(); i++) {
				fileWriter.println(i + 1);
				fileWriter.println(user.Spending.get(i).getSource());
				fileWriter.println(user.Spending.get(i).getAmount());
				fileWriter.println(user.Spending.get(i).getYearlyfrequency());
			}

		} catch (FileNotFoundException e) {
			System.out.println("Did not work");
		}
		fileWriter.close();

	}

	@Override
	public void addMonthlyIncome(Wage W) {
		user.Income.add(W);
		try {
			fileStream = new FileOutputStream("Income.txt");
			fileWriter = new PrintWriter(fileStream);
			for (int i = 0; i < user.Income.size(); i++) {
				fileWriter.println(i + 1);
				fileWriter.println(user.Income.get(i).getSource());
				fileWriter.println(user.Income.get(i).getAmount());
			}

		} catch (FileNotFoundException e) {
			System.out.println("Did not work");
		}
		fileWriter.close();

	}

	@Override
	public void PrintFullreport() {
		// TODO Auto-generated method stub

	}

	@Override
	public String PrintExpensereport() {  //function that returns the expense report as a string

		String str = "User's Expenses: ";

		for (Expense ex : user.Spending) {
			str += "| Expense " + (user.Spending.indexOf(ex) + 1) + ": (source: " + ex.source + ", amount: " + ex.amount + ", yearly frequency: " + ex.yearlyfrequency + ")";
		}

		return "<html>" + str + "<html>";

	}

	@Override
	public String PrintIncomereport() {  //function that returns the income report as a string
		
		String str = "User's Incomes:\n";

		for (Wage inc : user.Income) {
			str += "| Income " + (user.Income.indexOf(inc) + 1) + ": (source: " + inc.source + ", amount: " + inc.amount + ")";
		}

		return "<html>" + str + "<html>";
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
		double income = 0;
		double expense = 0;
		int timesAYear = 0;
		double total = 0;
		try {
			fileReaderBalance = new FileInputStream("Balance.txt");
			readerBalance = new Scanner(fileReaderBalance);
			for (int i = 0; i < user.Income.size(); i++) {
				income += user.Income.get(i).getAmount();
			}
			for (int i = 0; i < user.Spending.size(); i++) {

				timesAYear = user.Spending.get(i).getYearlyfrequency();
				expense += (user.Spending.get(i).getAmount() * timesAYear);
			}
			total = income - expense;


		} catch (FileNotFoundException e) {
			System.out.println("Did not work");
		}

		try {
			fileStream = new FileOutputStream("Balance.txt");
			fileWriter = new PrintWriter(fileStream);
			fileWriter.println(total);
		} catch (FileNotFoundException e) {
			System.out.println("Did not work");

		}

		fileWriter.close();
		readerBalance.close();
	}

}
