package finalProject;
import java.io.File;

public class UserDBManager {
	private File customerDB;
	private File adminDB;

	public UserDBManager() {
		customerDB = new File("db/customerDB.csv");
		adminDB = new File("db/adminDB.csv");
	}
    public Customer loginCustomer(String username, String password) {
        //search customerDB for matching username
        //if found, check if password matches
        //if matches, return customer object
        //if not found or password does not match, return null
        return null;
    }

    public Admin loginAdmin(String username, String password) {
        //search adminDB for matching username
        //if found, check if password matches
        //if matches, return admin object
        //if not found or password does not match, return null
        return null;
    }
}

