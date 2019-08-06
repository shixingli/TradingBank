package Model;

public abstract class Account {
	
	public Account(double balance) {
		this.balance = balance;
	}

    private double balance;

    public boolean deposit(double num) {
        this.balance += num;
        return true;
    }

    public boolean withDraw(double num) {
        if (this.balance - num < 0) {
            return false;
        } else {
            this.balance -= num;
            return true;
        }
    }

    public boolean transferTo(Account account, double num) {
        if (this.withDraw(num)) {
            account.deposit(num);
            return true;
        } else return false;
    }
}
