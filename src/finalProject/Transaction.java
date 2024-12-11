package finalProject;

import java.time.LocalDateTime;

public class Transaction {
    private Stock stock;
    private int quantity;
    private double price;
    private LocalDateTime date;
    private String type;
    public Transaction(Stock stock, int quantity, double price, LocalDateTime date, String type) {
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.type = type;
    }
    public String toString() {
        //transaction is stored as stock,quantity,price,date,type
        return stock.toString() + ":" + quantity + ":" + price + ":" + date.toString() + ":" + type;
    }
    public static Transaction fromString(String str) {
        String[] parts = str.split(":");
        return new Transaction(Stock.fromString(parts[0]), Integer.parseInt(parts[1]), Double.parseDouble(parts[2]), LocalDateTime.parse(parts[3]), parts[4]);
    }
}