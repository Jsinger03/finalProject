package finalProject;

import java.util.UUID;
public abstract class User {
    protected String id;
    protected String username;
    protected String password;
    protected int type;
    
    public User(String username, String password) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.type=-1;
    }
    
    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String pwd) { this.password = pwd; }

}