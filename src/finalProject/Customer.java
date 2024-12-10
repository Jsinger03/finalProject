package finalProject;
public class Customer extends User {
    private double balance;
    private Portfolio portfolio;
    private Watchlist watchlist;

    public Customer(String id, String username, String password, String name, double balance) {
        super(id, username, password, name);
        this.balance = balance;
        this.portfolio = new Portfolio();
        this.watchlist = new Watchlist();
    }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public Portfolio getPortfolio() { return portfolio; }
    public Watchlist getWatchlist() { return watchlist; }
}
