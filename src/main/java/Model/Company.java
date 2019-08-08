package Model;

public class Company {

    private String name;
    private String ticker;

    public Company(String companyName) {
        this.name = companyName;
        this.ticker = companyName.toLowerCase();
    } 
    
    public Company(String name, String ticker) {
    	this.name = name;
    	this.ticker = ticker;
    }
    
    public String getName() {
    	return this.name;
    }

    public String getTicker() {
        return this.ticker;
    }
    
    public String getTicker() {
    	return ticker;
    }
    
    public String toString() {
    	return "Company name " + name + "\nticker " + ticker;
    }

    public void setCompanyName(String newName) {
        this.name = newName;
        this.ticker = newName.toLowerCase();
    }
}
