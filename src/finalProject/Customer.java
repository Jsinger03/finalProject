package finalProject;
public class Customer extends User{
	
	// for constructors, do we invoke super constructor? or normal one?
	public Customer(String usern, String pwd) {
		super(usern, pwd);
	}

	// extra data fields
	float balance = 0;
	
	// extra methods
	public void deposit_money(float amount) {
		balance += amount;
	}
	
	public void withdraw_money(float amount) {
		balance -= amount;
	}
	
}
