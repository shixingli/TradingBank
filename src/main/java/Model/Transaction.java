package Model;

import java.io.*;
import java.nio.*;
import java.util.*;
import java.nio.file.Files;
import java.io.*;


public class Transaction implements Serializable {
	private static String PATH = "C:\\Users\\sunzhon\\Desktop\\CS591-OOB\\TradingBank\\src\\main\\java\\Model\\";

	private static String STOCK = PATH + "stock.data";

	// private static File trans = new File(PATH);
	// private static FileOutputStream read = new FileOutputStream(trans);
	// private static ObjectOutputStream reader = new ObjectOutputStream(read);
	// private static FileInputStream write = new FileInputStream(trans);
	// private static ObjectInputStream writer = new ObjectInputStream(write);

	public static void addRecord(Account acc, String desp, double num, String date) {
		
		out.writeObject(c);
		out.close();
		writer.close();
	}

	public static String retrieve() {
		try {
			Map<Integer, Customer> mapInFile= (HashMap<Integer, Customer>) ois.readObject();
			System.out.println(mapInFile);
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return "";
	}

	public static ArrayList<Stock> getAllStock() {
		ArrayList<Stock> ret = new ArrayList<Stock>();

		try {
			FileInputStream fis = new FileInputStream(STOCK);
			ObjectInputStream out = new ObjectInputStream(fis);
			ret = (ArrayList<Stock>) out.readObject();
			System.out.println(ret);
			out.close();
			fis.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException ca) {
            System.out.println("Class not found");
            ca.printStackTrace();
        }

		return ret;
	}

	public static void updateStock(String cName, String date, double price) {
		ArrayList<Stock> ret = getAllStock();
		Stock stockToUpdate = ret.findStock(cName);
		stockToUpdate.updateStock(date, price);
		try {
			FileOutputStream fos = new FileOutputStream(STOCK);
			ObjectOutputStream IN = new ObjectOutputStream(fos);
			IN.writeObject(ret);
			IN.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void addStock(String companyName) {
		ArrayList<Stock> ret = getAllStock();
		ret.add(new Stock(new Company(companyName)));

		try {
			FileOutputStream fos = new FileOutputStream(STOCK);
			ObjectOutputStream IN = new ObjectOutputStream(fos);
			IN.writeObject(ret);
			IN.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		// Transaction t = new Transaction();
		// HashMap<Integer, Customer> c = new HashMap<Integer, Customer>();
		// c.put(1, new Customer("f", "l", "id", "p"));

		// System.out.println(getAllStock());
		// getAllStock();
		Company a = new Company("Apple");
		Company m = new Company("Microsoft");
		Company t = new Company("Twitter");
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		stocks.add(new Stock(a));
		stocks.add(new Stock(m));
		stocks.add(new Stock(t));

		// FileWriter writer = new FileWriter(STOCK); 
		// for(Stock str: stocks) {
		// 	writer.write(str + System.lineSeparator());
		// }
		// writer.close();

		try {
			FileOutputStream fos = new FileOutputStream(STOCK);
			ObjectOutputStream IN = new ObjectOutputStream(fos);
			IN.writeObject(stocks);
			IN.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		try {
			FileInputStream fis = new FileInputStream(STOCK);
			ObjectInputStream out = new ObjectInputStream(fis);
			ArrayList<Stock> ret = (ArrayList<Stock>) out.readObject();
			out.close();
			fis.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException ca) {
            // System.out.println("Class not found");
            ca.printStackTrace();
        }
	}
}
