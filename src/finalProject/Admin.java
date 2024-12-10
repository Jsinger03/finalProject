package finalProject;
import java.util.*;


public class Admin extends User {
    public Admin() {
        super();
		this.setUserType("Admin");
    }
    public Admin(int userId, String username, String password, String userType) {
        super(userId, username, password, "Admin");
    }

	private Scanner sc = new Scanner(System.in);

	
	// global universe of stocks
	public static ArrayList<Stock> stocks;

	// add stock to universe
	public void add_stock() {
		System.out.println("Enter stock name: ");
		String name = sc.nextLine();
		System.out.println("Enter stock symbol: ");
		String symbol = sc.nextLine();
		System.out.println("Enter stock price: ");
		float price = sc.nextFloat();
		Stock new_stock = new Stock(name, symbol, price);
		stocks.add(new_stock);
	}
	
	// update stock price
	public void update_price(String name, float price) {
		Boolean found = false;
		for(int i = 0; i < stocks.size(); i++) {
			if(stocks.get(i).getName() == name) {
				stocks.get(i).setPrice(price);
				found = true;
			}
		}
		if(found == false) {
			System.out.println("Stock not found in universe.");
		}
	}
	
	// generate report for user
	public void generate_report(User user) {
		// search through users, then if found, print report of all positions, p&l, etc.
	}
	
}
