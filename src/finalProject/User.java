package finalProject;

public class User {
    private int userId;
    private String username;
    private String password;
	private String userType;//Customer or Admin

    public User() {}

    public User(int userId, String username, String password, String userType) {
        this.userId = userId;
        this.username = username;
        this.password = password;
		this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void updateProfile(String username, String newPassword) {
        this.username = username;
        this.password = newPassword;
    }
}

}
