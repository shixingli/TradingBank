package Model;

public abstract class Account {

    private double balance;

    public boolean deposit(double num) {
        this.balance += sum;
        return true;
    }

    public boolean withDraw(double num) {
        if (this.balance - sum < 0) {
            return false;
        } else {
            this.balance -= sum;
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
