package finalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
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
	                    return new Customer(parts[2], parts[0], parts[1]);
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
            //needs to write to end, not overwrite
	        FileWriter writer;
			try {
				writer = new FileWriter(usersFile, true);
				PrintWriter pw = new PrintWriter(writer);
		        pw.println(username + "," + password + "," + id + "," + type);
		        pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    public static void updateUsername(Customer customer, String newUsername) {
        File usersFile = new File(USERS_FILE);
        StringBuilder fileContent = new StringBuilder();

        try (Scanner scanner = new Scanner(usersFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(customer.getUsername())) {
                    line = newUsername + "," + parts[1] + "," + parts[2] + "," + parts[3];
                }
                fileContent.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(usersFile)) {
            writer.write(fileContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updatePassword(Customer customer, String newPassword) {
        File usersFile = new File(USERS_FILE);
        StringBuilder fileContent = new StringBuilder();

        try (Scanner scanner = new Scanner(usersFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(customer.getUsername())) {
                    line = parts[0] + "," + newPassword + "," + parts[2] + "," + parts[3];
                }
                fileContent.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(usersFile)) {
            writer.write(fileContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

