package Model;

import java.util.List;

public class SecurityAccount extends Account {

    private static final double MINIMUM_START_NUM = 5000;

    private List<Stock> stocks;
    private List<Bond> bonds;

    private double unrealizedProfit;
    private double realizedProfit;

    public boolean buyStock(Stock stock, int num) {
        return false;
    }

    public boolean sellStock(Stock stock, int num) {
        return false;
    }

    public boolean buyBond(Bond bond, int num) {
        return false;
    }

    public boolean sellBond(Bond bond, int num) {
        return false;
    }
}
