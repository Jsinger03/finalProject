package finalProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
public class Customer extends User {
	private Portfolio portfolio;
	private String transactions;
	private String watchlist;
	private double balance;
	

	public Customer(String id, String username, String password) {
		super(id, username, password);
		this.type=0;
        this.setup();
	}
    public static Customer fromString(String id, String username, String password) {
        return new Customer(id, username, password);
    }
    public void setup() {
        this.portfolio = new Portfolio();
        this.transactions = "";
        this.watchlist = "";
        File idFile = new File(id + ".txt");
        if (idFile.exists()) {
            try (Scanner scanner = new Scanner(idFile)) {
                if (scanner.hasNextDouble()) {
                    this.balance = scanner.nextDouble();
                    scanner.nextLine();
                }
                int tracker = 0;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (!line.isEmpty()) {
                        if (tracker == 0) {
                            portfolio = Portfolio.fromString(line);
                        } else if (tracker == 1) {
                            transactions = line;
                        } else if (tracker == 2) {
                            watchlist = line;
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
                pw.println(this.transactions);
                pw.println(this.watchlist);
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
            pw.println(this.transactions);
            pw.println(this.watchlist);
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
        Portfolio updatedPortfolio = new Portfolio();
        StocksManager stocksManager = new StocksManager();
        for (Map.Entry<Stock, Integer> entry : this.portfolio.getHoldings().entrySet()) {
            Stock stock = entry.getKey();
            int quantity = entry.getValue();
    
            //find the current stock from the StocksManager
            Stock currentStock = stocksManager.getStock(stock.getSymbol());
    
            if (currentStock != null) {
                //create a new Stock object with the updated price
                Stock updatedStock = new Stock(stock.getSymbol(), stock.getName(), currentStock.getPrice());
                //add the stock to the updated portfolio
                updatedPortfolio.addStock(updatedStock, quantity);
            }
        }
        this.portfolio = updatedPortfolio; //update the customer's portfolio
        return this.portfolio;
    }
    public void buyStock(Stock stock, int quantity) {
        if (this.balance >= stock.getPrice() * quantity) {
            this.balance -= stock.getPrice() * quantity;
            this.portfolio.addStock(stock, quantity);
            appendTransaction(stock, quantity, LocalDateTime.now(), "buy");
            save();
        } else {
            System.out.println("Insufficient balance to buy stock");
        }
    }
    public void sellStock(Stock stock, int held, int quantity) {
        if (held >= quantity) {
            this.balance += stock.getPrice() * quantity;
            this.portfolio.removeStock(stock, quantity);
            appendTransaction(stock, quantity, LocalDateTime.now(), "sell");
            save();
        } else {
            System.out.println("Insufficient quantity to sell stock");
        }
    }
    private void appendTransaction(Stock stock, int quantity, LocalDateTime date, String type) {
        String transaction = stock.toString() + "`" + quantity + "`" + date + "`" + type + ";";
        this.transactions += transaction;
    }
    public String[][] getTransactions() {
        String[] entries = this.transactions.split(";");
        String[][] data = new String[entries.length][4];
        for (int i = 0; i < entries.length; i++) {
            if (!entries[i].trim().isEmpty()) {
                String[] fields = entries[i].split("`");
                data[i][0] = fields[3]; //Type (buy/sell)
                data[i][1] = fields[0]; //Stock
                data[i][2] = fields[1]; //Quantity
                data[i][3] = fields[2]; //Date
            }
        }
        return data;
    }
    public String getWatchlist() {
        return this.watchlist;
    }
    public void addToWatchlist(String stock) {
        this.watchlist += stock + ";";
        save();
    }
    public double getPL() {
        double val = balance;
        for (Map.Entry<Stock, Integer> entry : this.portfolio.getHoldings().entrySet()) {
            Stock stock = entry.getKey();
            int quantity = entry.getValue();
            val += stock.getPrice() * quantity;
        }
        return val - 5000; 
    }

}
