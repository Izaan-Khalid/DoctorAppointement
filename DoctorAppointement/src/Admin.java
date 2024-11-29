import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// Entity Classes
class User {
    private String userID;
    private String name;
    private String email;

    public User(String userID, String name, String email) {
        this.userID = userID;
        this.name = name;
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserID: " + userID + ", Name: " + name + ", Email: " + email;
    }
}

class Appointment {
    private String appointmentID;
    private String patientName;
    private String doctorName;
    private String date;
    private String time;

    public Appointment(String appointmentID, String patientName, String doctorName, String date, String time) {
        this.appointmentID = appointmentID;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    @Override
    public String toString() {
        return "AppointmentID: " + appointmentID + ", Patient: " + patientName + ", Doctor: " + doctorName
                + ", Date: " + date + ", Time: " + time;
    }
}

// Admin Dashboard Class
public class AdminDashboard {
    private String adminID;
    private HashMap<String, User> users;
    private HashMap<String, Appointment> appointments;

    public AdminDashboard(String adminID) {
        this.adminID = adminID;
        this.users = new HashMap<>();
        this.appointments = new HashMap<>();
    }

    // Add a new user
    public void addUser(User user) {
        if (users.containsKey(user.getUserID())) {
            System.out.println("User already exists with ID: " + user.getUserID());
        } else {
            users.put(user.getUserID(), user);
            System.out.println("User added successfully: " + user);
        }
    }

    // Remove a user
    public void removeUser(String userID) {
        if (users.containsKey(userID)) {
            users.remove(userID);
            System.out.println("User removed successfully with ID: " + userID);
        } else {
            System.out.println("User not found with ID: " + userID);
        }
    }

    // List all users
    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("List of Users:");
            users.values().forEach(System.out::println);
        }
    }

    // Add an appointment
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentID())) {
            System.out.println("Appointment already exists with ID: " + appointment.getAppointmentID());
        } else {
            appointments.put(appointment.getAppointmentID(), appointment);
            System.out.println("Appointment added successfully: " + appointment);
        }
    }

    // Cancel an appointment
    public void cancelAppointment(String appointmentID) {
        if (appointments.containsKey(appointmentID)) {
            appointments.remove(appointmentID);
            System.out.println("Appointment canceled successfully with ID: " + appointmentID);
        } else {
            System.out.println("Appointment not found with ID: " + appointmentID);
        }
    }

    // List all appointments
    public void listAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            System.out.println("List of Appointments:");
            appointments.values().forEach(System.out::println);
        }
    }

    // Generate reports
    public void generateReports() {
        System.out.println("===== Report =====");
        System.out.println("Total Users: " + users.size());
        System.out.println("Total Appointments: " + appointments.size());
        System.out.println("==================");
    }

    // Admin Menu
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
                    addUser(new User(userID, name, email));
                    break;

                case 2:
                    System.out.print("Enter User ID to remove: ");
                    userID = scanner.nextLine();
                    removeUser(userID);
                    break;

                case 3:
                    listUsers();
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
                    addAppointment(new Appointment(appointmentID, patientName, doctorName, date, time));
                    break;

                case 5:
                    System.out.print("Enter Appointment ID to cancel: ");
                    appointmentID = scanner.nextLine();
                    cancelAppointment(appointmentID);
                    break;

                case 6:
                    listAppointments();
                    break;

                case 7:
                    generateReports();
                    break;

                case 8:
                    System.out.println("Exiting Admin Dashboard. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
        scanner.close();
    }

    public static void main(String[] args) {
        AdminDashboard admin = new AdminDashboard("admin123");
        admin.adminMenu();
    }
}
