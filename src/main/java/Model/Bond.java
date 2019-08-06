package Model;

import java.util.Date;
import java.util.Map;

public class Bond {
	
	private String id;
    private String name;
    private int period;
    private String buyDate;
    private double value;
    
    public Bond(String id, String name, int period, String buyDate, double value) {
    	this.id = id;
    	this.name = name;
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
    	return "Bond id " + id + " bond name " + name + " period " + period + " bond buyDate " + buyDate + " bond value " + value;
    }

}
