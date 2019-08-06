package Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecurityAccount extends Account {

    private static final double MINIMUM_START_NUM = 5000;
    private static final double FEE = 0.15876;

    private Map<Stock, Integer> ownedStocks;
    private Map<Bond, Double> ownedBonds;

    private double unrealizedProfit;
    private double realizedProfit;
    
    public SecurityAccount() {
    	super(MINIMUM_START_NUM);
    	
    	ownedStocks = new HashMap<Stock, Integer>();
    	ownedBonds = new HashMap<Bond, Double>();
    			
    	unrealizedProfit = 0;
    	realizedProfit = 0;
    }
    
    //name of stock, number of shares to buy, buy date
    public String buyStock(String name, int num, String date) {
    	//check if enough money for buying the stock
        if(Manager.stockMap.get(name).getValue(date) * num > super.getBalance())    	
        	return "No enough money!";
        
        else {	
        	//withdraw the same amount money as money for purchasing
        	super.withDraw(Manager.stockMap.get(name).getValue(date) * num);
        	super.withDraw(FEE);
        	
        	//add the stock into the map
        	//num means the amount of shares of the stock, need to add the new amount and the old one togethers
        	ownedStocks.put(Manager.stockMap.get(name), ownedStocks.get(Manager.stockMap.get(name))+ num);
        	
        	return "Success!";
        }	
    }
    
    //name of stock, number of shares to buy, sell date
    public String sellStock(String name, int num, String date) {
        	return "success!";
    }
    
    //period of bonds, value to buy, bond id
    public String buyBond(int period, double value, String id) {
    	//check if enough money for buying the bond
        if(value > super.getBalance())    	
        	return "No enough money!";
        
        else {
        	//go through the whole arraylist for every bond
        	for(Bond bond : Manager.bonds) {
        		//find the one has the passed id
        		if(bond.getID().equals(id)) {
        			//then add the bond into the map
        			ownedBonds.put(bond, ownedBonds.get(bond)+ value);
        			
                	//withdraw the same amount money as money for purchasing
                	super.withDraw(value);
                	super.withDraw(FEE);
                	
        			return "Success!";
        		}      
        	}	
    		return "Bond not found!";
        }
    }

    public String sellBond(String id) {
    	//find the one has the passed id
    	for(Bond bond : Manager.bonds) {
    		if(bond.getID().equals(id)) {
    			//then delete the bond from the map
    			ownedBonds.remove(bond);
    			
    			//and deposit the money of that bond into the account
    			super.deposit(bond.getValue());
    			super.withDraw(FEE);
    			
    			return "Success!";
    		}
    	}
    	
    	return "Bond not found!";
    }
    
    public String toString() {
    	return "Security account 1234 balance: " + super.getBalance() + " unrealizedProfit: " + unrealizedProfit +" realizedProfit: " + realizedProfit;
    }
}
