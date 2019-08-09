package Model;

public class SavingAccount extends Account {
	
	public SavingAccount() {
		super(0);
	}

	@Override
	public String deposit(double num) {
		super.setBalance(super.getBalance() + num);
		super.setDescription("deposited $" + num + " on " + 20180819 + " in saving account.");
		return "Success!";
	}
	

	public String withdraw(double num) {
		super.setBalance(super.getBalance() - num);
		super.setDescription("withdrawed $" + num + " on " + 20180819 + " in saving account.");
		return "Success!";
	}

	public String toString() {
		return "Saving account 6374 \nbalance: " + super.getBalance();
	}
}
