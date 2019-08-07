package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Helper.Tools;
import Helper.*;

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
        if(Manager.stockMap.get(name).getValue(date) * num + FEE> super.getBalance())    	
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
    		//find the stock with the name
    		if(Manager.stockMap.containsKey(name) && ownedStocks.containsValue(Manager.stockMap.get(name))) {
    			Stock stock = Manager.stockMap.get(name);
    			
    			//calculate the unrealizedProfit
    			unrealizedProfit = ownedStocks.get(stock) * stock.getValue(date);
    			
    			//calculate the realizedProfit
    			realizedProfit = num * 123;
    			
    			//deposit the money of that stock into the account
    			super.deposit(realizedProfit);
    			super.withDraw(FEE);
    			
    			//then delete the stock from the map
    			ownedStocks.remove(stock);
    			
    			return "Success!";
    		}
    		else 
    			return "No such Stock!";
    }
    
    //period of bonds, bond id
    	public String buyBond(int period, String id, String buyDate) {
    	//get the amount of money corresponding to period
    		double money = 0;
    	
	    	switch(period){
	        case 7 :
	        	money = 1369.23;
	           break; 
	        case 30 :
	        	money = 2862.74;
	           break; 
	        case 90 :
	        	money = 3362.08;
	            break; 
    	}	
    	
    	//check if enough money for buying the bond
        if(money + FEE > super.getBalance())    	
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

    public String sellBond(String id, String date) {
    	//find the one has the passed id
    	for(Bond bond : Manager.bonds) {
    		if(bond.getID().equals(id) && ownedBonds.containsKey(bond)) {	
    			//check if the customer sells the bond before the period
    			if(Tools.getDateDifference(bond.getBuyDate(), date) >= bond.getPeriod()) {
    			//deposit the money of that bond and the interest into the account
    			super.deposit((1+Manager.bondMap.get(bond.getPeriod())) * ownedBonds.get(bond));
    			super.withDraw(FEE);
    			
    			//then delete the bond from the map
    			ownedBonds.remove(bond);
    			}
    			// sell bond before the date of the bond
    			else {
    				//deposit the money of that bond into the account
        			super.deposit(1 * ownedBonds.get(bond));
        			super.withDraw(FEE);
        			
        			//then delete the bond from the map
        			ownedBonds.remove(bond);
        			}
    			
    			return "Success!";
			}
    	}
    	
    	return "Bond not found!";
    }
    
    public String toString() {
    	return "Security account 1234 \nbalance: " + super.getBalance() + "\nunrealizedProfit: " + unrealizedProfit +"\nrealizedProfit: " + realizedProfit;
    }
    
    public Map<Stock, Integer> getOwnedStocks(){
    	return ownedStocks;
    }
    
    public ArrayList<String> getStocks(String date){
    	ArrayList<String> arr = new ArrayList<String>();
    	arr.add("Ticker"+"  "+"Price");
    	
    	for(Stock stock : Manager.stocks)
    		arr.add(stock.getCompany().getTicker() + "  " + Manager.stockMap.get(date).getValue(date));
    	return arr;
    }
    
    public Map<Bond, Double> getOwnedBonds(){
    	return ownedBonds;
    }
}
