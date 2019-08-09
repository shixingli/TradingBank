package Model;


public class CheckingAccount extends Account {
	
	public CheckingAccount() {
		super(0);
	}

	@Override
	public String deposit(double num) {
		super.setBalance(super.getBalance() + num);
		super.setDescription("deposited $" + num + " on " + 20180819 + " in checking account.");
		return "Success!";
	}

	public String withdraw(double num) {
		super.setBalance(super.getBalance() - num);
		super.setDescription("withdrawed $" + num + " on " + 20180819 + " in checking account.");
		return "Success!";
	}

	public String toString() {
		return "Checking account 8432 \nbalance: "+ super.getBalance();
	}
}
