import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseCalculator implements Expenser {
	
	User user;
	FileInputStream fileReaderExpenses;
	FileInputStream fileReaderIncome;
	Scanner readerExpenses;
	Scanner readerIncome;
	FileOutputStream fileStream;
	FileOutputStream fileStreamExpenses;
	FileOutputStream fileStreamIncome;
	PrintWriter fileWriter;
	PrintWriter fileWriterExpenses;
	PrintWriter fileWriterIncome;

	ExpenseCalculator(User user) {
		this.user = user;
	}

	@Override
	public void addExpense(Expense Ex) {
		user.Spending.add(Ex);

	}

	@Override
	public void addMonthlyIncome(Wage W) {
		user.Income.add(W);

	}

	@Override
	public String PrintFullreport() {

		return PrintExpensereport() + PrintIncomereport() + " | Your monthly savings are: "
				+ Math.round(user.monthlysavings) + " | Your yearly balance is: " + user.balance;
	}

	@Override
	public String PrintExpensereport() { // function that returns the expense report as a string

		String str = "User's Expenses: ";

		for (Expense ex : user.Spending) {
			str += "| Expense " + (user.Spending.indexOf(ex) + 1) + ": (source: " + ex.source + ", amount: " + ex.amount
					+ ", yearly frequency: " + ex.yearlyfrequency + ")";
		}

		return "<html>" + str + "<html>";

	}

	@Override
	public String PrintIncomereport() { // function that returns the income report as a string

		String str = "User's Incomes:\n";

		for (Wage inc : user.Income) {
			str += "| Income " + (user.Income.indexOf(inc) + 1) + ": (source: " + inc.source + ", amount: " + inc.amount
					+ ")";
		}
		return "<html>" + str + "<html>";
	}
	
	
//method for print income report by type 
	@Override
	public String PrintIncomereportbyTpe(String reportRequested) {
		String msgReturned ="";
   if(reportRequested.equals("Salary")) {
	  for(int i =1; i < user.Income.size();i++) {
			if(user.Income.get(i).getSource().equalsIgnoreCase(reportRequested)) {
				msgReturned += "Source " +user.Income.get(i).getSource() + " Amount " +user.Income.get(i).getAmount();
			}
		}  
   }
   if(reportRequested.equals("Rental Income")) {
	  for(int i =1; i < user.Income.size();i++) {
			if(user.Income.get(i).getSource().equalsIgnoreCase(reportRequested)) {
				msgReturned += "Source " +user.Income.get(i).getSource() + " Amount " +user.Income.get(i).getAmount();
			}
		}  
   }
   if(reportRequested.equals("CashBack")) {
	  for(int i =1; i < user.Income.size();i++) {
			if(user.Income.get(i).getSource().equalsIgnoreCase(reportRequested)) {
				msgReturned += "Source " +user.Income.get(i).getSource() + " Amount " +user.Income.get(i).getAmount();
			}
		}  
   }
   if(reportRequested.equals("Gift")) {
	  for(int i =1; i < user.Income.size();i++) {
			if(user.Income.get(i).getSource().equalsIgnoreCase(reportRequested)) {
				msgReturned += "Source " +user.Income.get(i).getSource() + " Amount " +user.Income.get(i).getAmount();
			}
		}  
   }
   if(reportRequested.equals("Other")) {
	  for(int i =1; i < user.Income.size();i++) {
			if(user.Income.get(i).getSource().equalsIgnoreCase(reportRequested)) {
				msgReturned += "Source " +user.Income.get(i).getSource() + " Amount " +user.Income.get(i).getAmount();
			}
		}  
   }
   
   
   
   return"<html>" + msgReturned +"<html>";

		

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
		double spendingMonth = 0;
		double incomeMonth = 0;
		for (int i = 0; i < user.Spending.size(); i++) {
			spendingMonth += user.Spending.get(i).getAmount();
		}

		for (int i = 0; i < user.Income.size(); i++) {
			incomeMonth += (user.Income.get(i).getAmount() / 12);
		}

		user.monthlysavings = incomeMonth - spendingMonth;

	}

	public void updateBalance() {
		double spendingMonth = 0;
		double incomeYear = 0;
		try {
			for (int i = 0; i < user.Spending.size(); i++) {
				spendingMonth += (user.Spending.get(i).getAmount() * 12);
			}

			for (int i = 0; i < user.Income.size(); i++) {
				incomeYear += user.Income.get(i).getAmount();

			}
		} catch (Exception e) {
			System.out.println("Unable to update balance");
		}

		user.balance = (incomeYear - spendingMonth);
	}

	public void copyInfoToTextFiles() {

		try {
			fileStreamExpenses = new FileOutputStream("Expenses.txt");
			fileWriterExpenses = new PrintWriter(fileStreamExpenses);
			for (int i = 0; i < user.Spending.size(); i++) {
				fileWriterExpenses.println(user.Spending.get(i).getSource());
				fileWriterExpenses.println(user.Spending.get(i).getAmount());
				fileWriterExpenses.println(user.Spending.get(i).getYearlyfrequency());
			}

		} catch (FileNotFoundException e) {
			System.out.println("Did not work");
		}

		try {
			fileStreamIncome = new FileOutputStream("Income.txt");
			fileWriterIncome = new PrintWriter(fileStreamIncome);
			for (int i = 0; i < user.Income.size(); i++) {
				fileWriterIncome.println(user.Income.get(i).getSource());
				fileWriterIncome.println(user.Income.get(i).getAmount());
			}

		} catch (FileNotFoundException e) {
			System.out.println("Did not work");
		}

		fileWriterExpenses.close();
		fileWriterIncome.close();
	}

	public void copyInfoToArrayList() {
		try {
			fileReaderExpenses = new FileInputStream("Expenses.txt");
			readerExpenses = new Scanner(fileReaderExpenses);
			fileReaderIncome = new FileInputStream("Income.txt");
			readerIncome = new Scanner(fileReaderIncome);

			while (readerExpenses.hasNext()) {
				int e = 0;
				String source = readerExpenses.next();
				double amount = readerExpenses.nextDouble();
				int frequency = readerExpenses.nextInt();
				user.Spending.add(e, new Expense(source, amount, frequency));
				e++;
			}

			while (readerIncome.hasNext()) {
				int i = 0;
				String source = readerIncome.next();
				double amount = readerIncome.nextDouble();
				user.Income.add(i, new Wage(source, amount));
				i++;
			}

		} catch (FileNotFoundException e) {
			System.out.println("Unable to read file");

		}

	}

}
