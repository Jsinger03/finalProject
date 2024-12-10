package finalProject;
public class Customer extends User {
    private double balance;
    private int portfolioId;

    public Customer() {
        super();
        this.balance = 5000.0;
		this.setUserType("Customer");
    }

    public Customer(int userId, String username, String password, double balance, int portfolioId) {
        super(userId, username, password, "Customer");
        this.balance = balance;
        this.portfolioId = portfolioId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
	public void withdraw(double amount) {
		this.balance -= amount;
	}
}
