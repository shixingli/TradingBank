package Model;

public abstract class Account {
    private double balance;
    private String descrip;
    
	public Account(double balance) {
        this.balance = balance;
        this.descrip = "";
	}
	
    public double getBalance() {
    	return balance;
    }

    public void setBalance(double num) {
        this.balance = num;
    }
    
    public void setDescription(String descip) {
		this.descrip = descip;
    }

    public String getDescription() {return this.descrip;}
    
    public String deposit(double num) {
        this.balance += num;
        	return "Success!";
    }

    public String withDraw(double num) {
        if (this.balance - num < 0) {
        	return "No enough money!";
        } 
        else {
            this.balance -= num;
            return "Success!";
        }
    }

    public String transferTo(Account account, double num) {
        if (this.withDraw(num).equals("Success!")) {
            account.deposit(num);
            return "Success!";
        } 
        else return "No enough money!";
    }
}
