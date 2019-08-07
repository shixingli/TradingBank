package Model;

import java.io.*;
import java.nio.*;
import java.util.*;
import java.nio.file.Files;
import java.io.*;


public class Transaction implements java.io.Serializable {
	private static String DIR = "C:\\Users\\sunzhon\\Desktop\\CS591-OOB\\TradingBank\\src\\main\\java\\Model";
	private FileOutputStream writer;
	private FileReader reader;

	public Transaction() {
		// writer = new FileOutputStream(DIR + "hello.txt");
	}

	public static void main(String[] args) throws IOException {
		HashMap<Integer, Customer> c = new HashMap<Integer, Customer>();
		c.put(1, new Customer("f", "l", "id", "p"));

		FileOutputStream writer = new FileOutputStream(DIR + "hello.txt");
		ObjectOutputStream out = new ObjectOutputStream(writer);
		out.writeObject(c);
		out.flush();
		out.close();
		// writer.write(out);
		writer.close();


		FileInputStream fileInputStream = new FileInputStream(DIR + "hello.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		 p2 =  objectInputStream.readObject();
		objectInputStream.close();
	}
}
