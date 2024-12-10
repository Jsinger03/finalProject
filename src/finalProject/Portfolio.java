package finalProject;
import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<Stock, Integer> holdings = new HashMap<>();

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
}