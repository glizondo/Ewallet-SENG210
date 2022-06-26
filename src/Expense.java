
public class Expense {
	String source;
	double amount;
	int yearlyfrequency; // 1 for 1 time or once a year, 12 for monthly or or 24 for biweekly
	// should add contructor(s)

	Expense(String expenseSource, double value, int freq) {
		source = expenseSource;
		amount = value;
		yearlyfrequency = freq;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getYearlyfrequency() {
		return yearlyfrequency;
	}

	public void setYearlyfrequency(int yearlyfrequency) {
		this.yearlyfrequency = yearlyfrequency;
	}

}
