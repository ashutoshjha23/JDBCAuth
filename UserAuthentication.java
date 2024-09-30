import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserAuthentication {

    // Method to validate user login
    public static boolean validateLogin(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            
            return rs.next(); // if a record is found, the credentials are valid
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }

    // Method to register a new user
    public static boolean registerUser(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            int rowsInserted = stmt.executeUpdate();
            
            return rowsInserted > 0;
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) { // Duplicate entry error for unique constraints
                System.out.println("Username already exists!");
            } else {
                e.printStackTrace();
            }
        }
        
        return false;
    }

    // Main method to handle user interaction
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username or password cannot be empty!");
        } else {
            if (choice == 1) {
                if (validateLogin(username, password)) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Invalid username or password!");
                }
            } else if (choice == 2) {
                if (registerUser(username, password)) {
                    System.out.println("User registered successfully!");
                } else {
                    System.out.println("Registration failed!");
                }
            }
        }

        scanner.close();
        DatabaseConnection.closeConnection(); // Close the connection at the end
    }
}
