package finalProject;

import java.util.ArrayList;
import java.util.List;

public class Watchlist {
    private List<Stock> stocks = new ArrayList<>();

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public List<Stock> getStocks() { return stocks; }
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Stock stock : stocks) {
            out.append(stock.toString()).append(";");
        }
        return out.toString();
    }
    public static Watchlist fromString(String str) {
        Watchlist watchlist = new Watchlist();
        String[] entries = str.split(";");
        for (String entry : entries) {
            watchlist.addStock(Stock.fromString(entry));
        }
        return watchlist;
    }
}