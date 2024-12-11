package finalProject;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Customer extends User {
	HashMap<String, Stock> portfolio;
	ArrayList<Transaction> transactions;
	ArrayList<Stock> watchlist;
	double balance;
	

	public Customer(String id, String username, String password) {
		super(id, username, password);
		// TODO Auto-generated constructor stub
		this.type=0;
        this.setup();
	}
	public void setup() {
		//check if id.txt exists
		//if yes, read from it and fill in the portfolio, transactions, and watchlist
		//if no, make those objects new and create id.txt
        this.portfolio = new HashMap<>();
        this.transactions = new ArrayList<>();
        this.watchlist = new ArrayList<>();
        File idFile = new File(id + ".txt");
        if (idFile.exists()) {
            Scanner scanner = new Scanner(idFile);
            this.balance = scanner.nextDouble();
            int tracker = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (tracker == 0) {
                    portfolio= Portfolio.fromString(line);
                } else if (tracker == 1) {
                    transactions= Transaction.fromString(line);
                } else if (tracker == 2) {
                    watchlist= Watchlist.fromString(line);
                }
                tracker++;
            }
            scanner.close();
        } else {
            this.balance = 5000;
            FileWriter writer = new FileWriter(idFile);
            PrintWriter pw = new PrintWriter(writer);
            pw.println(this.balance);
            pw.println(this.portfolio.toString());
            pw.println(this.transactions.toString());
            pw.println(this.watchlist.toString());
            pw.close();
        }
		
	}
	public void deposit(double amt) {
		this.balance+=amt;
	}
	public void withdraw(double amt) {
		if (amt < this.balance) {
			this.balance -= amt;
		}
	}

}
