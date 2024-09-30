import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    private static final String URL = "jdbc:mysql://localhost:3306/user";
    private static final String USER = "user";
    private static final String PASSWORD = "your_password";

    // Private constructor to prevent instantiation
    private DatabaseConnection() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Explicitly load the MySQL JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("MySQL Driver not found! Include the connector JAR in the classpath.");
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Method to close the connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
