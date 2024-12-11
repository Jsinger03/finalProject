package finalProject;

import java.util.HashMap;
import java.util.ArrayList;
public class Customer extends User {
	HashMap<String, Stock> portfolio;
	ArrayList<Transaction> transactions;
	ArrayList<Stock> watchlist;
	

	public Customer(String id, String username, String password) {
		super(id, username, password);
		// TODO Auto-generated constructor stub
		this.type=0;
	}

}
