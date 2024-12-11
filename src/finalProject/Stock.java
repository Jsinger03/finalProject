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
    @Override
    public String toString() {
        //stock is stored as symbol,name,price
        return symbol + "," + name + "," + price;
    }
    public static Stock fromString(String str) {
        String[] parts = str.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid stock string: " + str);
        }
        return new Stock(parts[0], parts[1], Double.parseDouble(parts[2]));
    }

    //override to allow buying and selling to find the stock in a portfolio
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Stock stock = (Stock) obj;
        return symbol.equals(stock.symbol); // Assuming symbol uniquely identifies a stock
    }

    @Override
    public int hashCode() {
        return symbol.hashCode();
    }
}
