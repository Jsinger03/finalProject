package finalProject;


public class Stock {
    private String symbol;
    private String name;
    private double price;

    public Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }
    public String getSymbol() { return symbol; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String toString() {
        //stock is stored as symbol,name,price
        return symbol + "," + name + "," + price;
    }
    public static Stock fromString(String str) {
        String[] parts = str.split(",");
        return new Stock(parts[0], parts[1], Double.parseDouble(parts[2]));
    }
}