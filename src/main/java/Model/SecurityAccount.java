package Model;

import java.util.List;
import java.util.Map;

public class SecurityAccount extends Account {

    private static final double MINIMUM_START_NUM = 5000;

    private Map<Stock, Integer> ownedStocks;
    private Map<Bond, Double> ownedBonds;

    private double unrealizedProfit;
    private double realizedProfit;
    
    public SecurityAccount() {
    	super(5000);
    }

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
