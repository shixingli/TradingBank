package Model;

import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {

    private Company company;
    private Map<String, Double> priceInfo;
    
    public Stock(Company company) {
    	this.company = company;
    	
    	priceInfo = new HashMap<String, Double>();
    	
    }
    
    public Company getCompany() {
    	return company;
    }
    
    public Double getValue(String date) {
    	return priceInfo.get(date);
    }
    
    public void updateStock(String date, Double value) {
    	if(priceInfo.containsKey(date))
    		priceInfo.put(date, value);
    }

    public void setPriceInfo(Map<String, Double> prices) {
        this.priceInfo = prices;
    }
    
    public Map<String, Double> getPriceInfo() {
    	return priceInfo;
    }
    
    public String toString() {
    	return company.toString();
    }

}
