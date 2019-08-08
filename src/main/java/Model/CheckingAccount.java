package Model;

public class CheckingAccount extends Account {
	
	public CheckingAccount() {
		super(0);
	}

	@Override
	public String deposit(double num) {
		super.addBalance(num);
		// String date = 
		String des = "deposited " + num + " on " + date;
		Transaction.addRecord(this, desp, num, date);
		return "Success!";
	}
	
	public String toString() {
		return "Checking account 8432 \nbalance: "+ super.getBalance();
	}
}
