package finalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.UUID;
public class AuthManager {
    private static final String USERS_FILE = "users.txt";

    public static User login(String username, String password) {
        File usersFile = new File(USERS_FILE);
        Scanner scanner;
		try {
			scanner = new Scanner(usersFile);
			while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] parts = line.split(",");
	            if (parts[0].equals(username) && parts[1].equals(password)) {
	                if (parts[3].toString().equals("1")) {
	                    return new Admin(parts[0], parts[1]);
	                } else {
	                    return new Customer(parts[0], parts[1], parts[2]);
	                }
	            }
	        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return null;
    }
    public static void register(String username, String password, int type) {
        System.out.println("Current working directory: " + new File(".").getAbsolutePath());
        File usersFile = new File(USERS_FILE);
        //make sure that username is not taken
        Scanner scanner;
		try {
			scanner = new Scanner(usersFile);
			while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] parts = line.split(",");
	            if (parts[0].equals(username)) {
	                return;
	            }
	        }
			scanner.close();
	        String id = UUID.randomUUID().toString();
	        PrintWriter writer = new PrintWriter(usersFile);
	        writer.println(username + "," + password + "," + id + "," + type);
	        writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

}
