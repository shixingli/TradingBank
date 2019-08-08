package Model;

public class CheckingAccount extends Account {
	
	public CheckingAccount() {
		super(0);
	}
	
	public String toString() {
		return "Checking account 8432 \nbalance: "+ super.getBalance();
	}
}
