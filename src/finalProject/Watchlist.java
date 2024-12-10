package finalProject;

import java.util.ArrayList;
import java.util.List;

public class Watchlist {
    private List<Stock> stocks = new ArrayList<>();

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public List<Stock> getStocks() { return stocks; }
}