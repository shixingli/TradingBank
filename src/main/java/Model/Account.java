package Model;

public abstract class Account {

    private double balance;

    public boolean deposit(double num) {
        return false;
    }

    public boolean withDraw(double num) {
        return false;
    }

    public boolean transferTo(Account account, double num) { return false;}
}
