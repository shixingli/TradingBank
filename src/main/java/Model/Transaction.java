package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transaction {
	private static String recordPath = "C:/Users/sunzhon/Desktop/CS591-OOB/TradingBank/src/main/java/Model/transaction.txt";
	public static Map<String, ArrayList<String>> record;

	public Transaction() {
		record = new HashMap<String, ArrayList<String>>();
		record.put("Checking", new ArrayList<>());
		record.put("Saving", new ArrayList<>());
		record.put("Security", new ArrayList<>());
		record.put("All", new ArrayList<>());
	}

	public void addNewTransaction(Account acc) {
		if (acc instanceof CheckingAccount) {
			record.get("Checking").add(acc.getDescription());
			record.get("All").add(acc.getDescription());
		} else if (acc instanceof SavingAccount) {
			record.get("Saving").add(acc.getDescription());
			record.get("All").add(acc.getDescription());
		} else if (acc instanceof SecurityAccount) {
			record.get("Security").add(acc.getDescription());
			record.get("All").add(acc.getDescription());
		}
	}

	public String getAll() {
		String ret = "";
		for (Object s : record.get("All")) {
			ret += s.toString() + "\n";
		}
		return ret;
	}

	public String getCheckingTransaction() {
		System.out.println("enter");
		String ret = "";
		for (Object s : record.get("Checking")) {
			System.out.println("????????????????~~~~~~~~~~~~~~");
			ret += s.toString() + "\n";
		}
		return ret;
	}

	public String getSavingTransaction() {
		String ret = "";
		for (Object s : record.get("Saving")) {
			ret += s.toString() + "\n";
		}
		return ret;
	}

	public String getSecurityTransaction() {
		String ret = "";
		for (Object s : record.get("Security")) {
			ret += s.toString() + "\n";
		}
		return ret;
	}
}
