# Employee Attendance System

## 📝 Description

This is a simple, command-line-based Employee Attendance System built with Java. It addresses the challenge of accurately and efficiently tracking employee attendance by automating the process of check-ins and check-outs. The system stores all data in a local SQLite database, making it lightweight and easy to set up.

The primary goal of this project is to provide a reliable alternative to manual attendance tracking, minimizing errors and saving time for management.

---

## ✨ Features

* **Employee Management:** Add new employees to the system with their name and department.
* **Check-in/Check-out:** Record employee arrival and departure times with a simple ID-based system.
* **Database Storage:** All employee and attendance data is persistently stored in an SQLite database.
* **Command-Line Interface:** A straightforward and easy-to-navigate menu for interacting with the system.
* **Attendance Reporting (Coming Soon):** Functionality to generate and view attendance summaries.

---

## 💻 Tech Stack

* **Language:** Java
* **Database:** SQLite
* **Build Tool:** A standard IDE (like IntelliJ IDEA or Eclipse) with direct JDK compilation.
* **Driver:** SQLite JDBC Driver for database connectivity.

---

## 🚀 Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

* Java Development Kit (JDK) 11 or higher installed.
* An IDE like [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Eclipse](https://www.eclipse.org/downloads/).
* The [SQLite JDBC Driver](https://github.com/xerial/sqlite-jdbc/releases) JAR file.

### Installation & Setup

1.  **Clone the repository:**
    ```sh
    git clone [https://github.com/Sai34Charan/EmployeeAttendanceSystem.git](https://github.com/Sai34Charan/EmployeeAttendanceSystem.git)
    ```
2.  **Open the project in your IDE.**
3.  **Add the SQLite JDBC Driver to your project's build path/dependencies.**
    * **IntelliJ:** Go to `File` -> `Project Structure` -> `Modules` -> `Dependencies` -> `+` -> `JARs or directories...` and select the downloaded driver file.
    * **Eclipse:** Right-click your project -> `Build Path` -> `Configure Build Path` -> `Libraries` -> `Add External JARs...` and select the file.
4.  **Initialize the Database:**
    * Run the `main` method in the `DatabaseManager.java` file. This will create an `attendance.db` file in your project's root directory with the necessary tables.

---

## Usage
To run the application, execute the `main` method in the `App.java` file.
This will start the command-line interface, where you will be presented with a menu:
--- Employee Attendance System ---

1. Add New Employee

2. Employee Check-in

3. Employee Check-out

4. Exit
Please select an option:


Follow the on-screen prompts to manage employees and their attendance. When adding a new employee, the system will automatically assign them a unique ID, which you can then use for check-ins and check-outs.
