package Model;

public class Customer extends Trader{

    private CheckingAccount checkingAccount;
    private SavingAccount savingAccount;
    private SecurityAccount securityAccount;
    private Transaction transaction;

    public Customer(String firstName, String lastName, String id, String password) {
    	super(firstName, lastName, id, password);
    	
    	transaction = new Transaction();
    	
    	checkingAccount = new CheckingAccount();
    	savingAccount = new SavingAccount();
    	securityAccount = new SecurityAccount();
    }
    
    public Transaction getTransaction() {
    	return transaction;
    }
    
    public CheckingAccount getCheckingAccount() {
    	return checkingAccount;
    }
    
    public SavingAccount getSavingAccount() {
    	return savingAccount;
    }
    
    public SecurityAccount getSecurityAccount() {
    	return securityAccount;
    }
}
