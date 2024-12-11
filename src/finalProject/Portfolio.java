package finalProject;
import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<Stock, Integer> holdings = new HashMap<Stock, Integer>();
    public Portfolio() {
        holdings = new HashMap<Stock, Integer>();
    }

    public Map<Stock, Integer> getHoldings() {
        return holdings;
    }

    public void addStock(Stock stock, int quantity) {
        holdings.put(stock, holdings.getOrDefault(stock, 0) + quantity);
    }

    public void removeStock(Stock stock, int quantity) {
        if (holdings.containsKey(stock)) {
            int current = holdings.get(stock);
            int newQty = current - quantity;
            if (newQty <= 0) {
                holdings.remove(stock);
            } else {
                holdings.put(stock, newQty);
            }
        }
    }
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Map.Entry<Stock, Integer> entry : holdings.entrySet()) {
            out.append(entry.getKey().toString())
               .append(":")
               .append(entry.getValue())
               .append(";");
        }
        //remove the last semicolon
        if (out.length() > 0) {
            out.setLength(out.length() - 1);
        }
        return out.toString();
    }
    
    public static Portfolio fromString(String str) {
        Portfolio portfolio = new Portfolio();
        String[] entries = str.split(";");
        for (String entry : entries) {
            String[] parts = entry.split(":");
            if (parts.length == 2) {
                Stock stock = Stock.fromString(parts[0]);
                int quantity = Integer.parseInt(parts[1]);
                portfolio.addStock(stock, quantity);
            }
        }
        return portfolio;
    }
}
