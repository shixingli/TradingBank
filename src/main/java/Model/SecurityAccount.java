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
    
    //name of stock, number of shares to buy, buy date
    public String buyStock(String name, int num, String date) {
        if(super.getBalance() < MINIMUM_START_NUM)
        	return false;
    }
    
    //name of stock, number of shares to buy, sell date
    public String sellStock(String name, int num, String date) {
        	return false;
    }
    
    //period of bonds, value to buy, bond id
    public String buyBond(int period, double value, String id) {
        	return false;
    }

    public String sellBond(String id) {
        	return false;
    }
}
