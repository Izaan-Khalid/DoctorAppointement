import java.util.List;
import java.util.Scanner;

public class MainUI {
    private static AppointmentSystem appointmentSystem = new AppointmentSystem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Appointment System ===");
            System.out.println("1. Register Doctor");
            System.out.println("2. Register Patient");
            System.out.println("3. Search Doctor");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    registerDoctor();
                    break;
                case 2:
                    registerPatient();
                    break;
                case 3:
                    searchDoctor();
                    break;
                case 4:
                    System.out.println("Exiting. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void registerDoctor() {
        System.out.println("\n=== Register Doctor ===");
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter License Number: ");
        String licenseNumber = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, email, phoneNumber, specialization, licenseNumber);
        appointmentSystem.registerDoctor(doctor);
        System.out.println("Doctor registered successfully!");
    }

    private static void registerPatient() {
        System.out.println("\n=== Register Patient ===");
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        Patient patient = new Patient(id, name, email, phoneNumber, address);
        appointmentSystem.registerPatient(patient);
        System.out.println("Patient registered successfully!");
    }

    private static void searchDoctor() {
        System.out.println("\n=== Search Doctor ===");
        System.out.print("Enter Specialization to search: ");
        String specialization = scanner.nextLine();

        List<Doctor> doctors = appointmentSystem.searchDoctors(specialization);
        if (doctors.isEmpty()) {
            System.out.println("No doctors found with specialization: " + specialization);
        } else {
            System.out.println("\n=== Doctors Found ===");
            for (Doctor doctor : doctors) {
                System.out.println("Name: " + doctor.getName() + ", Specialization: " + doctor.getSpecialization() +
                                   ", License Number: " + doctor.getLicenseNumber());
            }
        }
    }

  
}
