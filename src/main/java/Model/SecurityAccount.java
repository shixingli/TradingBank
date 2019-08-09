package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Helper.Tools;
import Helper.*;

public class SecurityAccount extends Account {

    private static final double MINIMUM_START_NUM = 5000;
    private static final double FEE = 0.15876;

    //private Map<Stock, Integer> ownedStocks;
    private Map<Stock, Map<String, ArrayList<Integer>>> ownedStocks;
    private Map<Bond, Double> ownedBonds;

    private double unrealizedProfit;
    private double realizedProfit;
    
    public SecurityAccount() {
    	super(MINIMUM_START_NUM);
    	
    	//ownedStocks = new HashMap<Stock, Integer>();
    	ownedStocks = new HashMap<Stock, Map<String, ArrayList<Integer>>>();
    	ownedBonds = new HashMap<Bond, Double>();
    			
    	unrealizedProfit = 0;
    	realizedProfit = 0;
    }
    
    //name of stock, number of shares to buy, buy date
    public String buyStock(String ticker, int num, String date) {
    	//check if enough money for buying the stock
        if(Manager.stockMap.get(ticker).getValue(date) * num + FEE> super.getBalance()) 
        	return "No enough money!";
        
        else {	
        	//withdraw the same amount money as money for purchasing
        	super.withDraw(Manager.stockMap.get(ticker).getValue(date) * num);
        	super.withDraw(FEE);
        	
        	//calculate the unrealizedProfit
			unrealizedProfit = 0;
			
			//calculate the realizedProfit
			realizedProfit = realizedProfit - (num * Manager.stockMap.get(ticker).getValue(date));
        	
        	//add the stock into the map
        	//num means the amount of shares of the stock, need to add the new amount and the old one togethers
        	if(ownedStocks.containsKey(Manager.stockMap.get(ticker))) {
        		if(ownedStocks.get(Manager.stockMap.get(ticker)).containsKey(date))
        			ownedStocks.get(Manager.stockMap.get(ticker)).get(date).add(num);
        		else
        		{
        			ArrayList<Integer> arrayList = new ArrayList<Integer>();
        		
        			arrayList.add(num);
        			
        			ownedStocks.get(Manager.stockMap.get(ticker)).put(date, arrayList);
        		}
        	}
        	else
        	{
        		Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        		ArrayList<Integer> arrayList = new ArrayList<Integer>();	
    			arrayList.add(num);
    			
        		map.put(date, arrayList);
        		
        		ownedStocks.put(Manager.stockMap.get(ticker), map);
			}
			super.setDescription("bought " + num + " " + ticker + " stock(s) ($" + (num*FEE + Manager.stockMap.get(ticker).getValue(date)) + ") in security account.");
        	return "Success!";
        }	
    }
    
    //name of stock, number of shares to buy, sell date
    public String sellStock(String ticker, int num, String date) {
    		//find the stock with the name
    		if(Manager.stockMap.containsKey(ticker) && ownedStocks.containsKey(Manager.stockMap.get(ticker))) {
    			//record the number of shares of a stock
    			int n = 0;
    		
    			for(int i = 0; i < ownedStocks.get(Manager.stockMap.get(ticker)).get(date).size(); i++)
    				n = n + ownedStocks.get(Manager.stockMap.get(ticker)).get(date).get(i);
    			
    			//check if enough shares of stock to sell
    			if(n >= num) {
	    			
	    			Stock stock = Manager.stockMap.get(ticker);
	    			
	    			//calculate the unrealizedProfit
	    			unrealizedProfit = num * stock.getValue(date);
	    			
	    			//calculate the realizedProfit
	    			realizedProfit = realizedProfit + (num * stock.getValue(date));
	    			
	    			//deposit the money of that stock into the account
	    			super.deposit(unrealizedProfit);
	    			super.withDraw(FEE);
	    			
	    			//then put a negative num into the arraylist indicating the sold shares of the stock
	    			ownedStocks.get(Manager.stockMap.get(ticker)).get(date).add(-num);
	    			super.setDescription("sold " + num + " " + ticker + " stock(s) ($" + (num*FEE + Manager.stockMap.get(ticker).getValue(date)) + ") in security account.");
	    			return "Success!";
    			}
    			else
    				return "No enough shares of that stock!";
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
	        	money = 1000;
	           break; 
	        case 30 :
	        	money = 1500;
	           break; 
	        case 90 :
	        	money = 3000;
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
            super.setDescription("bought " + period + " " + id + " bond(s) ($" + ((Manager.bondMap.get(bond.getPeriod())) * ownedBonds.get(bond)) + ") in security account.");
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
				//super.setDescription("sold " + id + " " + date + " bond(s) ($" + ((Manager.bondMap.get(bond.getPeriod())) * ownedBonds.get(bond)) + ") in security account.");
    			return "Success!";
    			}
    			// sell bond before the date of the bond
    			else {
					//deposit the money of that bond into the account
					super.deposit(1 * ownedBonds.get(bond));
					super.withDraw(FEE);

					//then delete the bond from the map
					ownedBonds.remove(bond);

					return "Sold before due date!";
				}
			}
    	}
    	
    	return "Bond not found!";
    }
    
    public String toString() {
    	return "Security account 1234 \nbalance: " + super.getBalance() + "\nunrealizedProfit: " + unrealizedProfit +"\nrealizedProfit: " + realizedProfit;
    }
    
    public Map<Stock, Map<String, ArrayList<Integer>>> getOwnedStocks(){
    	return ownedStocks;
    }
    
    //show the number of shares of a stock
    public ArrayList<String> showOwnedStocks(){
    	ArrayList<String> arr = new ArrayList<String>();
    	
    	arr.add("Ticker"+"  "+"Number");
    	
    	for(Stock stock : ownedStocks.keySet()) {
    		int num = 0;
    		
    		for(String date : ownedStocks.get(stock).keySet())
    			for(int i = 0; i < ownedStocks.get(stock).get(date).size(); i++)
    				num = num + ownedStocks.get(stock).get(date).get(i);
    		
    		arr.add(stock.getCompany().getTicker() + "  " + num);
    	}
    	
    	return arr;
    }
    
    public Map<Bond, Double> getOwnedBonds(){
    	return ownedBonds;
    }
}
