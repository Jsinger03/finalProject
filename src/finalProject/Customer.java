package finalProject;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Customer extends User {
	Portfolio portfolio;
	ArrayList<Transaction> transactions;
	Watchlist watchlist;
	double balance;
	

	public Customer(String id, String username, String password) {
		super(id, username, password);
		// TODO Auto-generated constructor stub
		this.type=0;
        this.setup();
	}
    public static Customer fromString(String id, String username, String password) {
        return new Customer(id, username, password);
    }
    public void setup() {
        this.portfolio = new Portfolio();
        this.transactions = new ArrayList<>();
        this.watchlist = new Watchlist();
        File idFile = new File(id + ".txt");
        if (idFile.exists()) {
            try (Scanner scanner = new Scanner(idFile)) {
                if (scanner.hasNextDouble()) {
                    this.balance = scanner.nextDouble();
                    scanner.nextLine(); // Move to the next line after reading balance
                }
                int tracker = 0;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim(); // Trim whitespace
                    if (!line.isEmpty()) { // Check if the line is not empty
                        if (tracker == 0) {
                            portfolio = Portfolio.fromString(line);
                        } else if (tracker == 1 && !line.equals("[]")) { // Check for empty transactions
                            transactions = Transaction.fromString(line);
                        } else if (tracker == 2) {
                            watchlist = Watchlist.fromString(line);
                        }
                    }
                    tracker++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            this.balance = 5000;
            try (FileWriter writer = new FileWriter(idFile);
                 PrintWriter pw = new PrintWriter(writer)) {
                pw.println(this.balance);
                pw.println(this.portfolio.toString());
                pw.println(this.transactions.toString());
                pw.println(this.watchlist.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void save() {
        try (FileWriter writer = new FileWriter(id + ".txt");
            PrintWriter pw = new PrintWriter(writer)) {
            pw.println(this.balance);
            pw.println(this.portfolio.toString());
            pw.println(this.transactions.toString());
            pw.println(this.watchlist.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public void deposit(double amt) {
		this.balance+=amt;
        save();
	}
	public void withdraw(double amt) {
		if (amt < this.balance) {
			this.balance -= amt;
		}
        save();
	}
    public double getBalance() {
        return this.balance;
    }
    public Portfolio getPortfolio() {
        return this.portfolio;
    }

}
