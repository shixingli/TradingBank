package Model;

public class main {

	public static void main(String[] args) {
		Manager manager = new Manager("Bruce", "Zhang", "U45687bedf", "123");
		
		Customer customer = new Customer("Shi", "Zhen", "Usdjhfsid123", "456");
		manager.addCustomer(customer);
		
		Company company = new Company("Apple", "LASD123");
		Stock stock = new Stock(company);
		manager.addStock(stock);
		manager.updateStock(company.getName(), "20180804", 123.3);
		
		System.out.println(stock.toString());
		System.out.println(customer.toString());
		
		customer.getCheckingAccount().deposit();
	}

}
