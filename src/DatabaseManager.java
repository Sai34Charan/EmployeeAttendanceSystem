import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Manages the connection to the SQLite database and initializes the necessary tables.
 */
public class DatabaseManager {

    // The database file name. It will be created in the project's root directory.
    private static final String DB_URL = "jdbc:sqlite:attendance.db";

    /**
     * Establishes a connection to the database.
     * @return A Connection object to the database.
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            // The DriverManager will handle finding the correct driver for the SQLite URL.
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
        return conn;
    }

    /**
     * Creates the required tables in the database if they do not already exist.
     */
    public static void initializeDatabase() {
        // SQL statement for creating the employees table
        String createEmployeesTableSQL = "CREATE TABLE IF NOT EXISTS employees ("
                + " employee_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " first_name TEXT NOT NULL,"
                + " last_name TEXT NOT NULL,"
                + " department TEXT"
                + ");";

        // SQL statement for creating the attendance_records table
        String createAttendanceRecordsTableSQL = "CREATE TABLE IF NOT EXISTS attendance_records ("
                + " record_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " employee_id INTEGER NOT NULL,"
                + " check_in_time TEXT NOT NULL,"
                + " check_out_time TEXT,"
                + " date TEXT NOT NULL,"
                + " FOREIGN KEY (employee_id) REFERENCES employees (employee_id)"
                + ");";

        // Use a try-with-resources statement to ensure the connection and statement are closed automatically.
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            // Execute the SQL statements to create the tables
            stmt.execute(createEmployeesTableSQL);
            stmt.execute(createAttendanceRecordsTableSQL);
            System.out.println("Database tables have been created or already exist.");

        } catch (SQLException e) {
            System.out.println("Error initializing the database: " + e.getMessage());
        }
    }

    /**
     * The main method to run the database initialization.
     */
    public static void main(String[] args) {
        initializeDatabase();
    }
}
