package Model;

import java.util.Date;
import java.util.Map;

public class Bond {
	
	private String id;
    private int period;
    private String buyDate;
    private double value;
    
    //value means interestp
    public Bond(String id, int period, String buyDate, double value) {
    	this.id = id;
    	this.period = period;
    	this.buyDate = buyDate;
    	this.value = value;
    }
    
    public void setValue(double value) {
    	this.value = value;
    }
    
    public double getValue() {
    	return value;
    }
    
    public String getBuyDate() {
    	return buyDate;
    }
    
    public String getID() {
    	return id;
    }
    
    public int getPeriod() {
    	return period;
    }
    
    public String toString() {
    	return "Bond id " + id + " period " + period + " bond buyDate " + buyDate + " bond value " + value;
    }

}
