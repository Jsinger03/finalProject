package finalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


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
}
