package Model;

public class SavingAccount extends Account {
	
	public SavingAccount() {
		super(0);
	}
	
	public String toString() {
		return "Saving account 6374 balance: " + super.getBalance();
	}
}
