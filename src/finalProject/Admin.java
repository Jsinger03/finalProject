package finalProject;


public class Admin extends User {
	private AuthManager authManager;
	public Admin(String username, String password) {
		super(username, password);
		this.type = 1;
	}

}
