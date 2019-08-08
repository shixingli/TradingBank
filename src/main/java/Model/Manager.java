package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Manager extends Trader{
	
	public static List<Customer> customerList = new ArrayList<>();
    
	public static List<Stock> stocks = new ArrayList<Stock>();
	
	public static List<Bond> bonds = new ArrayList<Bond>();
	
	public static Map<String, Stock> stockMap = new HashMap<String, Stock>();
	
	public static Map<Integer, Double> bondMap = new HashMap<Integer, Double>();
	
	public static Set<String> customerStringSet = new HashSet<String>();
    
	public static ArrayList<String> getStocks(String date){
    	ArrayList<String> arr = new ArrayList<String>();
    	arr.add("Ticker"+"  "+"Price");
    	
    	for(Stock stock : Manager.stocks)
    		arr.add(stock.getCompany().getTicker() + "  " + stock.getValue(date));
    	return arr;
    }
	
    public Manager(String firstName, String lastName, String id, String password) {
    	super(firstName, lastName, id, password);
    	
    	bondMap.put(7, 0.08);
    	bondMap.put(30, 0.1);
    	bondMap.put(90, 0.3);
    }	
    
    public String updateStock(String name, String date, double newValue) {
    	
    	if(stockMap.containsKey(name)) {
    		stockMap.get(name).updateStock(date, newValue);
    		
    		return "Success!";
    	}
    	return "No such stock!";
    }
    
    public String updateBond(Integer i, double newValue) {
    	
    	if(bondMap.containsKey(i)) {
    		bondMap.put(i,newValue);
    		
    		return "Success!";
    	}
    	
    	return "No such Bond!";
    }
    
    public void addStock(Stock stock) {
    	
    	stocks.add(stock);
    	stockMap.put(stock.getCompany().getName(), stock);
    }
    
    public void addBond(Bond bond) {
    	
    	bonds.add(bond);
    	bondMap.put(bond.getPeriod(), bond.getValue());
    }
    
    public void addCustomer(Customer customer) {
    	customerList.add(customer);
    }
    
    public Stock getAStock(String name) {
    	return stockMap.get(name);
    }
}
