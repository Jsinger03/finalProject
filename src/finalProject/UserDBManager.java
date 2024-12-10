package finalProject;
import java.io.File;

public class UserDBManager {
	private File customerDB = new File("db/customerDB.csv");
	private File adminDB = new File("db/adminDB.csv");

	public UserDBManager() {
	}
    public Customer loginCustomer(String username, String password) {
        //search customerDB for matching username
        //if found, check if password matches
        //if matches, return customer object
        //if not found or password does not match, return null
        try {
            Scanner scanner = new Scanner(customerDB);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data[0].equals(username) && data[1].equals(password)) {
                    return new Customer(data[0], data[1]);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Customer database not found");
        }

        return null;
    }

    public Admin loginAdmin(String username, String password) {
        //search adminDB for matching username
        //if found, check if password matches
        //if matches, return admin object
        //if not found or password does not match, return null
        try {
            Scanner scanner = new Scanner(adminDB);
            boolean found = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data[0].equals(username) && data[1].equals(password)) {
                    return new Admin(data[0], data[1]);
                }
            }
            scanner.close();
        }
        return null;
    }
    public void registerCustomer(Customer customer) {
        //add customer to customerDB
        //if customer already exists, return false
        //if customer does not exist, add customer to customerDB and return true
        //if customerDB is not found, return false
        //if customerDB is not found, return false
    }
    //try gibving users a unique ID in this db, and have a separate db for actual customer objects which you can match the login db ID to to get the correct customer object
}

