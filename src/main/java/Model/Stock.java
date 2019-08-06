package Model;

import java.io.ObjectInputStream.GetField;
import java.util.List;
import java.util.Map;

public class Stock {

    private Company company;
    private Map<String, Double> priceInfo;
    
    public Company getCompany() {
    	return company;
    }
    
    public Double getValue() {
    	return priceInfo.get(company.getName());
    }
    
    public void updateStock(String date, Double value) {
    	if(priceInfo.containsKey(date))
    		priceInfo.put(date, value);
    }

}
