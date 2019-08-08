package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Manager extends Trader{
	public static String fileName = "C:/Users/Teddyzhang的PC/Desktop/customer.txt";
	
	public static String stockFile = "C:/Users/sunzhon/Desktop/CS591-OOB/TradingBank/src/main/java/Model/" + "/stock.txt"; 
	
	public static List<Customer> customerList = new ArrayList<>();
    
	public static List<Stock> stocks = new ArrayList<Stock>();
	
	public static List<Bond> bonds = new ArrayList<Bond>();
	
	public static Map<String, Stock> stockMap = new HashMap<String, Stock>();
	
	public static Map<Integer, Double> bondMap = new HashMap<Integer, Double>();
	
	public static Set<String> customerStringSet = new HashSet<String>();
    
	public static ArrayList<String> getStocks(String date){
    	ArrayList<String> arr = new ArrayList<String>();
    	arr.add("Ticker"+"  "+"Price");
    	
    	for(Stock stock : Manager.stocks)
    		arr.add(stock.getCompany().getTicker() + "  " + stock.getValue(date));
    	return arr;
    }
	
	public static void readCustomerList() {
		 File file = new File(fileName);
	     BufferedReader reader = null;
	        try {
	            reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            // read by one line
	            while ((tempString = reader.readLine()) != null) {
	                
	                //split the string
	                String[] strings = tempString.split(";");
	                
	                String firstName = strings[0];
	                String lastName= strings[1];
	                String id = strings[2];
	                String password = strings[3];
	                
	                Customer customer = new Customer(firstName, lastName, id, password);
	                
	                Manager.customerList.add(customer);
	                Manager.customerStringSet.add(id);
	            }
	            
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
	}

	public static void writeCustomerList() {
		FileWriter writer;
		
		try {
			writer = new FileWriter(fileName);
			
			BufferedWriter bw = new BufferedWriter(writer);
			
			for(Customer customer : Manager.customerList) {
				String s = customer.getFirstName()+";"+customer.getLastName()+";"+customer.getID()+";"+customer.getPassword();
				bw.write(s.toString()+ "\r\n");	
			}
		
			bw.close();
			writer.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void readStockList() {
		File file = new File(stockFile);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			// read by one line
			while ((tempString = reader.readLine()) != null) {
				
				//split the string
				String[] strings = tempString.split(";");
				
				String companyName = strings[0];
				String companyTicker= strings[1];
				
				Map<String, Double> priceInfo = new HashMap<String,Double>();
				for (int i=2; i<strings.length-1; i+=2) {
					priceInfo.put(strings[i], Double.parseDouble(strings[i+1]));
				}
				
				Stock stock = new Stock(new Company(companyName, companyTicker));
				stock.setPriceInfo(priceInfo);
				Manager.stocks.add(stock);
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
   }

	public static void writeStockList() {
		FileWriter writer; 
		try {
			writer = new FileWriter(stockFile);
			
			BufferedWriter bw = new BufferedWriter(writer);
			
			for(Stock stock : stocks) {
				String s = stock.getCompany().getName() 
					+ ";" + stock.getCompany().getTicker() + ";";
				for (Map.Entry<String, Double> entry : stock.getPriceInfo().entrySet()) {
					s  += entry.getKey() + ";" + entry.getValue() + ";";
				}
				s = s.substring(0, s.length()-1);
				bw.write(s.toString()+ "\r\n");

				stockMap.put(stock.getCompany().getTicker(), stock);
			}
		
			bw.close();
			writer.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

    public static void showCustomerList() {
    	for(Customer customer : customerList)
    		System.out.println(customer.toString());
    }
	
    public Manager(String firstName, String lastName, String id, String password) {
    	super(firstName, lastName, id, password);
    	
    	bondMap.put(7, 0.08);
    	bondMap.put(30, 0.1);
    	bondMap.put(90, 0.3);
    }	
    
    public static String updateStock(String ticker, String date, double newValue) {
    	
    	if(stockMap.containsKey(ticker)) {
    		stockMap.get(ticker).updateStock(date, newValue);
    		for(Stock stock : stocks)
    			if(stock.getCompany().getTicker().equals(ticker))
    				stock.updateStock(date,newValue);

    		return "Success!";
    	}
    	return "No such stock!";
    }
    
    public String updateBond(Integer i, double newValue) {
    	
    	if(bondMap.containsKey(i)) {
    		bondMap.put(i,newValue);
    		
    		return "Success!";
    	}
    	
    	return "No such Bond!";
    }
    
    public static void addStock(Stock stock) {
    	stocks.add(stock);
    	stockMap.put(stock.getCompany().getTicker(), stock);
    }
    
    public void addBond(Bond bond) {
    	
    	bonds.add(bond);
    	bondMap.put(bond.getPeriod(), bond.getValue());
    }
    
    public void addCustomer(Customer customer) {
    	customerList.add(customer);
    }
    
    public Stock getAStock(String ticker) {
    	return stockMap.get(ticker);
    }
}
