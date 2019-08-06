package Model;

import java.util.Date;
import java.util.Map;

public class Bond {

    private String name;
    private int period;
    private String buyDate;
    private double value;
    
    public void setValue(double value) {
    	this.value = value;
    }
    
    public double getValue() {
    	return value;
    }
    
    public String getBuyDate() {
    	return buyDate;
    }
    
    public int getPeriod() {
    	return period;
    }

}
