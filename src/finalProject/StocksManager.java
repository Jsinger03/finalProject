package finalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class StocksManager {
    private ArrayList<Stock> stocks;
    private final String filename = "stocks.txt";

    public StocksManager() {
        this.stocks = new ArrayList<>();
        this.loadStocks();
    }

    private void loadStocks() {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                stocks.add(new Stock(parts[0], parts[1], Double.parseDouble(parts[2])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }
    public ArrayList<Stock> searchStocks(String searchTerm) {
        ArrayList<Stock> results = new ArrayList<>();
        for (Stock stock : stocks) {
            if (stock.getName().contains(searchTerm) || stock.getSymbol().contains(searchTerm)) {
                results.add(stock);
            }
        }
        return results;
    }
    public void addStock(Stock stock) {
        stocks.add(stock);
        saveStocks();
    }
    public void deleteStock(Stock stock) {
        stocks.remove(stock);
        saveStocks();
    }
    public void changePrice(Stock stock, double newPrice) {
        stocks.remove(stock);
        stock.setPrice(newPrice);
        stocks.add(stock);
        saveStocks();
    }
    public void saveStocks() {
        File file = new File(filename);
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Stock stock : stocks) {
                writer.println(stock.getSymbol() + "," + stock.getName() + "," + stock.getPrice());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Stock getStock(String symbol) {
        for (Stock stock : stocks) {
            if (stock.getSymbol().equals(symbol)) {
                return stock;
            }
        }
        return null;//stock not found
    }
}
