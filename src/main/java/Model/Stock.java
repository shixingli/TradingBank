package Model;

import java.io.Serializable;
import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock implements Serializable {

    private Company company;
    private Map<String, Double> priceInfo;
    
    public Stock(Company company) {
    	this.company = company;
    	
    	priceInfo = new HashMap<String, Double>();
    	priceInfo.put("20180804", 12.12);
    	priceInfo.put("20180810", 45.45);
    	priceInfo.put("20180815", 56.56);
    	
    }
    
    public Company getCompany() {
    	return company;
    }
    
    public Double getValue(String date) {
    	return priceInfo.get(date);
    }

    public String getName() {return this.company.getName();}
    
    public void updateStock(String date, Double value) {
    	if(priceInfo.containsKey(date))
    		priceInfo.put(date, value);
    }
    
    public Map getPriceInfo() {
    	return priceInfo;
    }
    
    public Stock findStock(String cName, ArrayList<Stock> stocks) {
        for(Stock stock : stocks) {
            if(stock.getName().equals(cName)) {
                return stock;
            }
        }
        return null;
    }


    public String toString() {
    	return company.toString();
    }

}
