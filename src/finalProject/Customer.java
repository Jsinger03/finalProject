package finalProject;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.File;
public class Customer extends User {
	HashMap<Stock, Integer> portfolio;
	ArrayList<Transaction> transactions;
    ArrayList<Stock> watchlist;
    double balance;
    File userFile;

	

	public Customer(String username, String password, String id) {
        super(username, password);
		this.type=0;
        this.id = id;
        this.portfolio = new HashMap<>();
        this.transactions = new ArrayList<>();
        this.watchlist = new ArrayList<>();
        this.balance = 5000;
        this.userFile = new File(id + ".txt");
        restore();
	}

    public void restore() {
        //check if file exists
        if (userFile.exists()) {
            //read file
            Scanner scanner = new Scanner(userFile);
            //parse file
            int i = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //update portfolio, transactions, watchlist, balance
                if (i == 0) {
                    this.balance = Double.parseDouble(line);
                } else if (i == 1) {
                    this.portfolio = Portfolio.fromString(line);
                } else if (i == 2) {
                    this.transactions = Transaction.fromString(line);
                } else if (i == 3) {
                    this.watchlist = Watchlist.fromString(line);
                }
            }
        }
    }
    //buy stock
    //sell stock
    //add to watchlist
    //deposit
    //withdraw
    //saveToFile

}
