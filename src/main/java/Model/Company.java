package Model;

public class Company {

    private String name;
    private String ticker;
    
    public Company(String name, String ticker) {
    	this.name = name;
    	this.ticker = ticker;
    }
    
    public String getName() {
    	return name;
    }
    
    public String toString() {
    	return "Company name " + name + "\nticker " + ticker;
    }

}
