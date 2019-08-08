package Model;

public abstract class Account {
    private double balance;
	
    public double getBalance() {
    	return balance;
    }
    
	public Account(double balance) {
		this.balance = balance;
	}

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
