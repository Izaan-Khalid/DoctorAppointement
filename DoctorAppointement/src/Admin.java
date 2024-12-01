import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * ================================================================
 * Code Artifact: AdminDashboard
 * Description: This program simulates an admin dashboard for managing users and appointments. 
 *              It allows the admin to add, remove, and list users, add and cancel appointments, 
 *              and generate reports on users and appointments.
 * Authors: Loveline Djamda
 * Date: November 28, 2024
 * ================================================================
 */

// Entity Classes
/**
 * User class represents a user in the system with attributes: userID, name, and email.
 */
class User {
    private String userID;  // Unique identifier for the user
    private String name;    // Name of the user
    private String email;   // Email address of the user

    // Constructor to initialize User object
    public User(String userID, String name, String email) {
        this.userID = userID;
        this.name = name;
        this.email = email;
    }

    // Getters for user attributes
    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Override toString method to display user details
    @Override
    public String toString() {
        return "UserID: " + userID + ", Name: " + name + ", Email: " + email;
    }
}

/**
 * Appointment class represents an appointment with attributes: appointmentID, patientName, doctorName, date, and time.
 */
class Appointment {
    private String appointmentID;  // Unique identifier for the appointment
    private String patientName;    // Name of the patient
    private String doctorName;     // Name of the doctor
    private String date;           // Date of the appointment
    private String time;           // Time of the appointment

    // Constructor to initialize Appointment object
    public Appointment(String appointmentID, String patientName, String doctorName, String date, String time) {
        this.appointmentID = appointmentID;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
    }

    // Getters for appointment attributes
    public String getAppointmentID() {
        return appointmentID;
    }

    // Override toString method to display appointment details
    @Override
    public String toString() {
        return "AppointmentID: " + appointmentID + ", Patient: " + patientName + ", Doctor: " + doctorName
                + ", Date: " + date + ", Time: " + time;
    }
}

// Admin Dashboard Class
/**
 * AdminDashboard class handles all the admin functionalities for managing users and appointments.
 * It provides options for adding/removing users, managing appointments, and generating reports.
 */
public class AdminDashboard {
    private String adminID;  // Admin's unique identifier
    private HashMap<String, User> users;  // HashMap to store users by their userID
    private HashMap<String, Appointment> appointments;  // HashMap to store appointments by their appointmentID

    // Constructor to initialize AdminDashboard with admin ID and empty collections for users and appointments
    public AdminDashboard(String adminID) {
        this.adminID = adminID;  // Initialize admin ID
        this.users = new HashMap<>();  // Initialize empty user list
        this.appointments = new HashMap<>();  // Initialize empty appointment list
    }

    // Add a new user to the system
    public void addUser(User user) {
        if (users.containsKey(user.getUserID())) {  // Check if user already exists
            System.out.println("User already exists with ID: " + user.getUserID());
        } else {
            users.put(user.getUserID(), user);  // Add user to the system
            System.out.println("User added successfully: " + user);
        }
    }

    // Remove a user from the system
    public void removeUser(String userID) {
        if (users.containsKey(userID)) {
            users.remove(userID);  // Remove user from the system
            System.out.println("User removed successfully with ID: " + userID);
        } else {
            System.out.println("User not found with ID: " + userID);
        }
    }

    // List all users in the system
    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("List of Users:");
            users.values().forEach(System.out::println);  // Print details of all users
        }
    }

    // Add an appointment to the system
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentID())) {
            System.out.println("Appointment already exists with ID: " + appointment.getAppointmentID());
        } else {
            appointments.put(appointment.getAppointmentID(), appointment);  // Add appointment to the system
            System.out.println("Appointment added successfully: " + appointment);
        }
    }

    // Cancel an appointment from the system
    public void cancelAppointment(String appointmentID) {
        if (appointments.containsKey(appointmentID)) {
            appointments.remove(appointmentID);  // Remove appointment from the system
            System.out.println("Appointment canceled successfully with ID: " + appointmentID);
        } else {
            System.out.println("Appointment not found with ID: " + appointmentID);
        }
    }

    // List all appointments in the system
    public void listAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            System.out.println("List of Appointments:");
            appointments.values().forEach(System.out::println);  // Print details of all appointments
        }
    }

    // Generate a simple report on users and appointments
    public void generateReports() {
        System.out.println("===== Report =====");
        System.out.println("Total Users: " + users.size());  // Print total number of users
        System.out.println("Total Appointments: " + appointments.size());  // Print total number of appointments
        System.out.println("==================");
    }

    // Admin Menu: Displays options and performs actions based on user's choice
    public void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== Admin Dashboard =====");
            System.out.println("1. Add User");
            System.out.println("2. Remove User");
            System.out.println("3. List Users");
            System.out.println("4. Add Appointment");
            System.out.println("5. Cancel Appointment");
            System.out.println("6. List Appointments");
            System.out.println("7. Generate Reports");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    String userID = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    addUser(new User(userID, name, email));  // Add a new user
                    break;

                case 2:
                    System.out.print("Enter User ID to remove: ");
                    userID = scanner.nextLine();
                    removeUser(userID);  // Remove a user
                    break;

                case 3:
                    listUsers();  // List all users
                    break;

                case 4:
                    System.out.print("Enter Appointment ID: ");
                    String appointmentID = scanner.nextLine();
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter Doctor Name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter Time (HH:MM): ");
                    String time = scanner.nextLine();
                    addAppointment(new Appointment(appointmentID, patientName, doctorName, date, time));  // Add an appointment
                    break;

                case 5:
                    System.out.print("Enter Appointment ID to cancel: ");
                    appointmentID = scanner.nextLine();
                    cancelAppointment(appointmentID);  // Cancel an appointment
                    break;

                case 6:
                    listAppointments();  // List all appointments
                    break;

                case 7:
                    generateReports();  // Generate a report of users and appointments
                    break;

                case 8:
                    System.out.println("Exiting Admin Dashboard. Goodbye!");  // Exit the dashboard
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");  // Handle invalid input
            }
        } while (choice != 8);
        scanner.close();  // Close the scanner resource
    }

    // Main method to start the Admin Dashboard application
    public static void main(String[] args) {
        AdminDashboard admin = new AdminDashboard("admin123");  // Create an admin dashboard with admin ID
        admin.adminMenu();  // Display admin menu and start interaction
    }
}