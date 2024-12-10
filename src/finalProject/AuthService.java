package finalProject;

import java.util.UUID;

public class AuthService {
    private DataAccess dataAccess;

    public AuthService(DataAccess da) {
        this.dataAccess = da;
    }

    public User login(String username, String password) {
        User user = dataAccess.findUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void registerCustomer(String username, String password, String name) {
        String id = UUID.randomUUID().toString();
        Customer c = new Customer(id, username, password, name, 5000.0);
        dataAccess.saveUser(c);
    }

    public void registerAdmin(String username, String password, String name) {
        String id = UUID.randomUUID().toString();
        Admin a = new Admin(id, username, password, name);
        dataAccess.saveUser(a);
    }
}
