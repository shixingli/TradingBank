package Model;

public class main {

	public static void main(String[] args) {
		Manager manager = new Manager("Bruce", "Zhang", "U45687bedf", "123");
		
		Customer customer = new Customer("Shi", "Zhen", "Usdjhfsid123", "456");
		manager.addCustomer(customer);
		
		Company company = new Company("Apple", "LASD123");
		Company c = new Company("Google", "HJAK567");
		Stock stock = new Stock(company);
		manager.addStock(stock);
		Stock sa = new Stock(c);
		manager.addStock(sa);
//		manager.updateStock(company.getName(), "20180804", 123.3);
		
//		for(Stock s : Manager.stocks)
//			System.out.println(s.toString());
			
//		System.out.print(customer.getSecurityAccount().buyStock("Apple", 10, "20180804"));
//		
//		System.out.println(customer.getSecurityAccount().getOwnedStocks().get(stock).toString());
//		
//		System.out.println(customer.getSecurityAccount().toString());
		
//		System.out.println(customer.getSecurityAccount().toString());
//		
//		System.out.println(customer.getSecurityAccount().buyBond(90, 5000, "ASD123", "20190605"));
//		
//		System.out.println(customer.getSecurityAccount().toString());
//		
//		System.out.println(customer.getSecurityAccount().sellBond("ASD123"));
//		
//		System.out.println(customer.getSecurityAccount().toString());
		
//      customer.getSecurityAccount().buyBond(7, 100, "LASD123");
	}

}
