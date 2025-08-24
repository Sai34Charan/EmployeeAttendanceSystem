import java.util.Scanner;

/**
 * The main application class that provides a command-line interface
 * for the Employee Attendance System.
 */
public class App {

    public static void main(String[] args) {
        // Create an instance of our service class to use its methods
        AttendanceService service = new AttendanceService();
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // A flag to keep the application running until the user decides to exit
        boolean isRunning = true;

        // Main application loop
        while (isRunning) {
            // Print the menu options
            System.out.println("\n--- Employee Attendance System ---");
            System.out.println("1. Add New Employee");
            System.out.println("2. Employee Check-in");
            System.out.println("3. Employee Check-out");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");

            // Read the user's choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // This is important to consume the newline character left by nextInt()

            // Use a switch statement to perform an action based on the user's choice
            switch (choice) {
                case 1:
                    // Logic to add an employee
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    service.addEmployee(firstName, lastName, department);
                    break;
                case 2:
                    // Logic for employee check-in
                    System.out.print("Enter Employee ID to Check-in: ");
                    int checkInId = scanner.nextInt();
                    service.checkIn(checkInId);
                    break;
                case 3:
                    // Logic for employee check-out
                    System.out.print("Enter Employee ID to Check-out: ");
                    int checkOutId = scanner.nextInt();
                    service.checkOut(checkOutId);
                    break;
                case 4:
                    // Exit the application
                    isRunning = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    // Handle invalid input
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
