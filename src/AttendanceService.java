import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Handles all business logic related to employee attendance,
 * such as adding employees, checking in, and checking out.
 */
public class AttendanceService {

    // A formatter for consistently handling date and time strings.
    private static final DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private static final DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE;

    /**
     * Adds a new employee to the database.
     * @param firstName The employee's first name.
     * @param lastName The employee's last name.
     * @param department The employee's department.
     */
    public void addEmployee(String firstName, String lastName, String department) {
        String sql = "INSERT INTO employees(first_name, last_name, department) VALUES(?,?,?)";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, department);
            pstmt.executeUpdate();
            System.out.println("Successfully added new employee: " + firstName + " " + lastName);

        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    /**
     * Records a check-in for a given employee ID.
     * @param employeeId The ID of the employee checking in.
     */
    public void checkIn(int employeeId) {
        String sql = "INSERT INTO attendance_records(employee_id, check_in_time, date) VALUES(?,?,?)";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            LocalDateTime now = LocalDateTime.now();
            pstmt.setInt(1, employeeId);
            pstmt.setString(2, now.format(dtf)); // Store current time as a string
            pstmt.setString(3, now.format(df));  // Store current date as a string

            pstmt.executeUpdate();
            System.out.println("Employee " + employeeId + " checked in at " + now);

        } catch (SQLException e) {
            System.out.println("Error during check-in: " + e.getMessage());
        }
    }

    /**
     * Records a check-out for a given employee ID.
     * It finds the most recent check-in for that day without a check-out time and updates it.
     * @param employeeId The ID of the employee checking out.
     */
    public void checkOut(int employeeId) {
        // We need to find the last check-in record for this employee on this date that hasn't been checked out yet.
        String sql = "UPDATE attendance_records SET check_out_time = ? "
                + "WHERE employee_id = ? AND date = ? AND check_out_time IS NULL "
                + "ORDER BY check_in_time DESC LIMIT 1";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            LocalDateTime now = LocalDateTime.now();
            pstmt.setString(1, now.format(dtf));
            pstmt.setInt(2, employeeId);
            pstmt.setString(3, LocalDate.now().format(df));

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee " + employeeId + " checked out at " + now);
            } else {
                System.out.println("Could not find an open check-in for employee " + employeeId + " today.");
            }

        } catch (SQLException e) {
            System.out.println("Error during check-out: " + e.getMessage());
        }
    }
}
