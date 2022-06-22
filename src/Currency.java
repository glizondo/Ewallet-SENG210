
public class Currency {
	public double rate;
	public String name;

	public Currency(double rate, String name) {
		super();
		this.rate = rate;
		this.name = name;
	}

	public Currency(String name) {
		super();
		this.name = name;
	}

	public Currency() {
		super();
	}

	public double dollarToEuros(double amountDollars) {
		double euro = amountDollars * 0.95;
		return euro;
	}

	public double euroToDollars(double amountEuros) {
		double dollar = amountEuros * 1.0526315789473684210526315789474;
		return dollar;
	}

}
