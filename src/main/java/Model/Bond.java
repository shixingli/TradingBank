package Model;

import java.util.Date;
import java.util.Map;

public class Bond {

    private String name;
    private int period;
    private String buyDate;
    private double value;
    
    public void updateBond(double value) {
    	this.value = value;
    }
    
    public int getPeriod() {
    	return period;
    }

}
