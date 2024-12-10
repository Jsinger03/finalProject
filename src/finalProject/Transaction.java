package finalProject;

import java.time.LocalDateTime;

public class Transaction {
    public enum TransactionType { BUY, SELL }

    private String id;
    private String userId;
    private String stockSymbol;
    private int quantity;
    private double price;
    private LocalDateTime date;
    private TransactionType type;

    public Transaction(String id, String userId, String stockSymbol, int quantity, double price, LocalDateTime date, TransactionType type) {
        this.id = id;
        this.userId = userId;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.type = type;
    }
}