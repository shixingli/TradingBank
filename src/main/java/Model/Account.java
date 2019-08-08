package Model;

import java.io.*;

public abstract class Account implements java.io.Serializable {
    private double balance;
    private final int CHECKING = 0;
    private final int SAVING = 1;
    private final int SECURITY = 2;
	
    public double getBalance() {
    	return balance;
    }
    
    public void addBalance(double num) {
        this.balance += num;
    }

	public Account(double balance) {
		this.balance = balance;
    }
    
    public String deposit(double num) {
        this.addBalance(num);
        return "Success!";
    }

    public String withDraw(double num) {
        if (this.balance - num < 0) {
        	return "No enough money!";
        } else {
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
