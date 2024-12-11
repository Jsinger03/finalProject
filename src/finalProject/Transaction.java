package finalProject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Transaction {
    private Stock stock;
    private int quantity;
    private LocalDateTime date;
    private String type;
    public Transaction(Stock stock, int quantity, LocalDateTime date, String type) {
        this.stock = stock;
        this.quantity = quantity;
        this.date = date;
        this.type = type;
    }
    public String toString() {
        //transaction is stored as stock,quantity,price,date,type
        return stock.toString() + ":" + quantity + ":" + date.toString() + ":" + type + ";";
    }
    
    public static ArrayList<Transaction> fromString(String str) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        String[] entries = str.split(";");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        for (String transaction : entries) {
            String[] parts = transaction.split(":");
            if (parts.length == 4) {
                try {
                    Stock stock = Stock.fromString(parts[0]);
                    int quantity = Integer.parseInt(parts[1]);
                    LocalDateTime date = LocalDateTime.parse(parts[2], formatter);
                    String type = parts[3];
                    transactions.add(new Transaction(stock, quantity, date, type));
                } catch (DateTimeParseException e) {
                    System.err.println("Invalid date format: " + parts[2]);
                    e.printStackTrace();
                } catch (Exception e) {
                    System.err.println("Error parsing transaction: " + transaction);
                    e.printStackTrace();
                }
            } else {
                System.err.println("Invalid transaction format: " + transaction);
            }
        }
        return transactions;
    }
}
