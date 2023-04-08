public class User {
    private String username;
    private String password;
    private String role; // admin atau customer
    private String alamat;

    public User(String username, String password, String role, String alamat) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.alamat = alamat;
    }

    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getRole() {
        return role;
    }
    
    public String getAlamat() {
        return alamat;
    }

    
}
