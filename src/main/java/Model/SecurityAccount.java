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
        	if(ownedStocks.containsKey(name))
        		ownedStocks.put(Manager.stockMap.get(name), ownedStocks.get(Manager.stockMap.get(name))+ num);
        	else
        		ownedStocks.put(Manager.stockMap.get(name), num);
        	return "Success!";
        }	
    }
    
    //name of stock, number of shares to buy, sell date
    public String sellStock(String name, int num, String date) {
        	return "success!";
    }
    
    //period of bonds, amount of money to buy bond, bond id
    public String buyBond(int period, double money, String id, String buyDate) {
    	//check if enough money for buying the bond
        if(money > super.getBalance())    	
        	return "No enough money!";
        
        else {
        	//create a bond instance
        	Bond bond = new Bond(id, period, buyDate, Manager.bondMap.get(period));
        	Manager.bonds.add(bond);
        	//then add the bond into the map
        	if(ownedBonds.containsKey(bond))
        		ownedBonds.put(bond, ownedBonds.get(bond)+ money);
        	else
        		ownedBonds.put(bond, money);
            
        	//withdraw the same amount money as money for purchasing
            super.withDraw(money);
            super.withDraw(FEE);
                	
        	return "Success!";
        }      	
    }

    public String sellBond(String id) {
    	//find the one has the passed id
    	for(Bond bond : Manager.bonds) {
    		if(bond.getID().equals(id) && ownedBonds.containsKey(bond)) {	
    			
    			//deposit the money of that bond into the account
    			super.deposit((1+Manager.bondMap.get(bond.getPeriod())) * ownedBonds.get(bond));
    			super.withDraw(FEE);
    			
    			//then delete the bond from the map
    			ownedBonds.remove(bond);
    			
    			return "Success!";
    		}
    	}
    	
    	return "Bond not found!";
    }
    
    public String toString() {
    	return "Security account 1234 balance: " + super.getBalance() + " unrealizedProfit: " + unrealizedProfit +" realizedProfit: " + realizedProfit;
    }
    
    public Map<Stock, Integer> getOwnedStocks(){
    	return ownedStocks;
    }
    
    public Map<Bond, Double> getOwnedBonds(){
    	return ownedBonds;
    }
}
