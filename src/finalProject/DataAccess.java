package finalProject;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class DataAccess {
    private File usersFile;
    private File stocksFile;
    private File transactionsFile;

    public DataAccess(String usersPath, String stocksPath, String transactionsPath) {
        this.usersFile = new File(usersPath);
        this.stocksFile = new File(stocksPath);
        this.transactionsFile = new File(transactionsPath);
    }

    // Users
    public User findUserByUsername(String username) {
        List<User> users = getAllUsers();
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    public void saveUser(User user) {
        List<User> users = getAllUsers();
        boolean found = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(user.getUsername())) {
                users.set(i, user);
                found = true;
                break;
            }
        }
        if (!found) {
            users.add(user);
        }
        writeUsers(users);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        List<String> lines = readLines(usersFile);
        for (String line : lines) {
            String[] parts = line.split(",");
            // Format: id, username, password, name, type, balance
            String id = parts[0];
            String uname = parts[1];
            String pass = parts[2];
            String name = parts[3];
            String type = parts[4];
            double balance = Double.parseDouble(parts[5]);
            if ("CUSTOMER".equals(type)) {
                users.add(new Customer(id, uname, pass, name, balance));
            } else {
                users.add(new Admin(id, uname, pass, name));
            }
        }
        return users;
    }

    // Stocks
    public Stock findStockBySymbol(String symbol) {
        for (Stock s : getAllStocks()) {
            if (s.getSymbol().equals(symbol)) return s;
        }
        return null;
    }

    public void saveStock(Stock stock) {
        List<Stock> stocks = getAllStocks();
        boolean updated = false;
        for (int i = 0; i < stocks.size(); i++) {
            if (stocks.get(i).getSymbol().equals(stock.getSymbol())) {
                stocks.set(i, stock);
                updated = true;
                break;
            }
        }
        if (!updated) {
            stocks.add(stock);
        }
        writeStocks(stocks);
    }

    public void deleteStockBySymbol(String symbol) {
        List<Stock> stocks = getAllStocks();
        stocks.removeIf(s -> s.getSymbol().equals(symbol));
        writeStocks(stocks);
    }

    public List<Stock> getAllStocks() {
        List<Stock> stocks = new ArrayList<>();
        List<String> lines = readLines(stocksFile);
        // Format: symbol, name, price
        for (String line : lines) {
            String[] parts = line.split(",");
            String sym = parts[0];
            String name = parts[1];
            double price = Double.parseDouble(parts[2]);
            stocks.add(new Stock(sym, name, price));
        }
        return stocks;
    }

    // Transactions
    public void saveTransaction(Transaction transaction) {
        // Format: id, userId, stockSymbol, quantity, price, datetime, type
        List<String> lines = readLines(transactionsFile);
        String record = transaction.getId() + "," + transaction.getUserId() + "," + transaction.getStockSymbol() + ","
                + transaction.getQuantity() + "," + transaction.getPrice() + "," + transaction.getDate().toString() + ","
                + transaction.getType().name();
        lines.add(record);
        writeLines(transactionsFile, lines);
    }

    public List<Transaction> findTransactionsByUserId(String userId) {
        List<Transaction> all = getAllTransactions();
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : all) {
            if (t.getUserId().equals(userId)) {
                result.add(t);
            }
        }
        return result;
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        List<String> lines = readLines(transactionsFile);
        // Format: id, userId, stockSymbol, quantity, price, datetime, type
        for (String line : lines) {
            String[] parts = line.split(",");
            String id = parts[0];
            String uId = parts[1];
            String symbol = parts[2];
            int qty = Integer.parseInt(parts[3]);
            double price = Double.parseDouble(parts[4]);
            LocalDateTime dt = LocalDateTime.parse(parts[5]);
            Transaction.TransactionType type = Transaction.TransactionType.valueOf(parts[6]);
            transactions.add(new Transaction(id, uId, symbol, qty, price, dt, type));
        }
        return transactions;
    }

    // Helper methods
    private List<String> readLines(File f) {
        List<String> lines = new ArrayList<>();
        if (!f.exists()) return lines;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String ln;
            while ((ln = br.readLine()) != null) {
                lines.add(ln);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private void writeLines(File f, List<String> lines) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(f))) {
            for (String l : lines) {
                pw.println(l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeUsers(List<User> users) {
        List<String> lines = new ArrayList<>();
        for (User u : users) {
            if (u instanceof Customer) {
                Customer c = (Customer) u;
                lines.add(c.getId()+","+c.getUsername()+","+c.getPassword()+","+c.getName()+",CUSTOMER,"+c.getBalance());
            } else {
                lines.add(u.getId()+","+u.getUsername()+","+u.getPassword()+","+u.getName()+",ADMIN,0");
            }
        }
        writeLines(usersFile, lines);
    }

    private void writeStocks(List<Stock> stocks) {
        List<String> lines = new ArrayList<>();
        for (Stock s : stocks) {
            lines.add(s.getSymbol()+","+s.getName()+","+s.getPrice());
        }
        writeLines(stocksFile, lines);
    }
}

