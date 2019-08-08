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
    
    public static Customer customerLogin(String id, String password) {
    	for(Customer customer : Manager.customerList)
    		if(customer.getID().equals(id) && customer.getPassword().equals(password))
    			return customer;
    	
    	return null;
    }
    
    public static Customer customerRegister(String firstName,String lastName,String id,String password) {
    	//check if customer exists
    	if(Manager.customerStringSet.contains(id))
    		return null;
    	else {
    		Customer customer = new Customer(firstName, lastName, id, password);
    		Manager.customerStringSet.add(id);
    		Manager.customerList.add(customer);
    		
    		return customer;
    	}
    }
    
    public String toString() {
    	return "customer's last name: " + super.getLastName() + "\ncustomer's " + getCheckingAccount().toString() + "\ncustomer's " + getSavingAccount().toString() + "\ncustomer's " + getSecurityAccount().toString();
    }
}
