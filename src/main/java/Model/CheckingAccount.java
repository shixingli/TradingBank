package Model;

public class CheckingAccount extends Account {
	
	public CheckingAccount() {
		super(0);
	}

	@Override
	public String deposit(double num) {
		//super.deposit(num);

		return "Success!";
	}
	
	public String toString() {
		return "Checking account 8432 \nbalance: "+ super.getBalance();
	}
}
