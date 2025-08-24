/**
 * Represents an Employee. This is a simple data class (also known as a model or POJO).
 * It holds the data for a single employee.
 */
public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;

    // Constructor to create a new Employee object
    public Employee(int employeeId, String firstName, String lastName, String department) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    // --- Getter methods to access the private fields ---

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    // We can add setter methods if we need to modify employee data later.
    // For now, getters are sufficient.

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + firstName + " " + lastName + ", Department: " + department;
    }
}
