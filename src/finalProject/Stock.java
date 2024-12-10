package finalProject;

public class Stock {
    private int stockId;
    private String symbol;
    private String name;
    private double currentPrice;

    public Stock() {}

    public Stock(int stockId, String symbol, String name, double currentPrice) {
        this.stockId = stockId;
        this.symbol = symbol;
        this.name = name;
        this.currentPrice = currentPrice;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void updatePrice(double newPrice) {
        this.currentPrice = newPrice;
    }
}
