package Model;

import java.io.*;
import java.nio.*;
import java.util.*;
import java.nio.file.Files;
import java.io.*;


public class Transaction implements Serializable {
	private static String PATH = "C:\\Users\\sunzhon\\Desktop\\CS591-OOB\\TradingBank\\src\\main\\java\\Model" + "transaction.data";
	private static File trans = new File(PATH);
	private static FileOutputStream read = new FileOutputStream(trans);
	private static ObjectOutputStream reader = new ObjectOutputStream(read);
	private static FileInputStream write = new FileInputStream(trans);
	private static ObjectInputStream writer = new ObjectInputStream(write);

	public static void addRecord(Account acc, String desp, double num, Date date) {
		
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

	public static void main(String[] args) throws IOException {
		Transaction t = new Transaction("wolala");
		HashMap<Integer, Customer> c = new HashMap<Integer, Customer>();
		c.put(1, new Customer("f", "l", "id", "p"));
		
		

		
		

		// System.out.println(mapInFile);
	}
}
