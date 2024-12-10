package finalProject;

import java.util.Date;

public class Transaction {
    private int transactionId;
    private int userId;
    private int stockId;
    private int quantity;
    private double price;
    private Date date;
    private String[] transaction_types = {"buy", "sell"};
    private String type;

    public Transaction() {}

    public Transaction(int transactionId, int userId, int stockId, int quantity, double price, Date date, String type) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.stockId = stockId;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.type = type;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getTransactionValue() {
        return price * quantity;
    }