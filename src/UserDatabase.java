import java.util.*;

public class UserDatabase {
    private ArrayList<User> users = new ArrayList<>();
    
    public UserDatabase() {
        // Menambahkan data admin dan customer ke database
        users.add(new User("admin", "admin123", "admin", ""));
        users.add(new User("customer", "customer123", "customer", "Jalan Sudirman No. 123"));
    }
    
    public User getUser(String username) {
        // Mencari user dengan username tertentu pada database
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
