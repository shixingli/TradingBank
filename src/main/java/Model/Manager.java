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
	
	public static Map<String, Stock> stockMap = new HashMap<String, Stock>();
	
	public static Map<Integer, Double> bondMap = new HashMap<Integer, Double>();
	
	public static Set<String> customerStringSet = new HashSet<String>();
    
    public Manager(String firstName, String lastName, String id, String password) {
    	super(firstName, lastName, id, password);
    	bondMap.put(7, 0.08);
    	bondMap.put(30, 0.1);
    	bondMap.put(90, 0.3);
    }	
    
    public void updateStock(String name, String date, double newValue) {
    	stockMap.get(name).updateStock(date, newValue);
    }
    
    public void updateBond(Integer i, double newValue) {
    	bondMap.put(i,newValue);
    }
    
    public void addStock(Stock stock) {
    	
    	stocks.add(stock);
    	stockMap.put(stock.getCompany().getName(), stock);
    }
    
    public void addCustomer(Customer customer) {
    	customerList.add(customer);
    }
    
    public Stock getAStock(String name) {
    	return stockMap.get(name);
    }

}
