import java.util.List;
import java.util.Scanner;

/**
 * ================================================================
 * Code Artifact: MainUI.java
 * Description: This program serves as the User Interface For DoctorAppointment System and can perform the following tasks:
 * - Register doctors and patients in the system.
 * - Search for doctors by their specialization.
 * - Schedule Appointments between patients and doctors.
 * - Search for existing appointments already scheduled.
 * 
 * Author: Mohamed Ismail
 * Date: 11/30/24
 * ================================================================
 */

public class MainUI {

    // Instance of AppointmentSystem for backend
    private static AppointmentSystem appointmentSystem = new AppointmentSystem();
    // Scanner object for user Input
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        // Accepts user input and Displays The Main Menu Options
        do {
            System.out.println("\n---- Appointment System ----");
            System.out.println(" 1. Register A Doctor ");
            System.out.println(" 2. Register A Patient ");
            System.out.println(" 3. Search For A Doctor ");
            System.out.println(" 4. Schedule An Appointment ");
            System.out.println(" 5. Check For Appointments ");
            System.out.println(" 6. Exit Program ");
            System.out.print(" Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            // Handles Menu Choices using Switch statement calling Methods
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
                    scheduleAppointment();
                    break;
                case 5:
                    checkAppointments();
                    break;
                case 6:
                    System.out.println(" Exit Program ");
                    break;
                default:
                    System.out.println(" Invalid choice, please try again. ");
            }
        } while (choice != 6);

        scanner.close();
    }

    // Register a new doctor into the system and sends them to AppointmentSystem
    private static void registerDoctor() {
        System.out.println("\n---- Register a Doctor ----");
        System.out.print(" Enter ID: ");
        String id = scanner.nextLine();
        System.out.print(" Enter Name: ");
        String name = scanner.nextLine();
        System.out.print(" Enter Email: ");
        String email = scanner.nextLine();
        System.out.print(" Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print(" Enter Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print(" Enter License Number: ");
        String licenseNumber = scanner.nextLine();

        // Creates Doctor Object
        Doctor doctor = new Doctor(id, name, email, phoneNumber, specialization, licenseNumber);
        appointmentSystem.registerDoctor(doctor);
        System.out.println(" Doctor Registration Is Successfull! ");
    }
    // Register a new patient into the system and sends them to AppointmentSystem
    private static void registerPatient() {
        System.out.println("\n---- Register a Patient ----");
        System.out.print(" Enter ID: ");
        String id = scanner.nextLine();
        System.out.print(" Enter Name: ");
        String name = scanner.nextLine();
        System.out.print(" Enter Email: ");
        String email = scanner.nextLine();
        System.out.print(" Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print(" Enter Address: ");
        String address = scanner.nextLine();

        //Creates Patient Object
        Patient patient = new Patient(id, name, email, phoneNumber, address);
        appointmentSystem.registerPatient(patient);
        System.out.println(" Patient Registration Is Sucessfull! ");
    }
    // Searches for doctors by their specialization and displays the result
    private static void searchDoctor() {
        System.out.println("\n---- Search For A Doctor ----");
        System.out.print(" Enter Doctor Specialization to search: ");
        String specialization = scanner.nextLine();

        // Gets a list of doctors matching the specialization inputed
        List<Doctor> doctors = appointmentSystem.searchDoctors(specialization);
        if (doctors.isEmpty()) {
            System.out.println(" No Doctors Found With Searched Specialization: " + specialization);
        } else {
            System.out.println("\n---- Doctors Found -----");
            for (Doctor doctor : doctors) {
                System.out.println(" Name: " + doctor.getName() + ", Specialization: " + doctor.getSpecialization() +
                                   ", License Number: " + doctor.getLicenseNumber());
            }
        }
    }
    // Schedules a new appointment and sends to AppointmentSystem
    private static void scheduleAppointment() {
        System.out.println("\n---- Schedule Appointment ----");
        System.out.print(" Enter The Appointment ID: ");
        String appointmentID = scanner.nextLine();
        System.out.print(" Enter The Patient Name: ");
        String patientName = scanner.nextLine();
        System.out.print(" Enter The Doctor Name: ");
        String doctorName = scanner.nextLine();
        System.out.print(" Enter The Appointment Date in (YYYY-MM-DD) format: ");
        String date = scanner.nextLine();
        System.out.print(" Enter The Appointment Time in (HH:MM) format: ");
        String time = scanner.nextLine();
        System.out.print(" Enter The Reason For Appointment: ");
        String reason = scanner.nextLine();

        // Creates Appointment Object
        Appointment appointment = new Appointment(appointmentID, doctorName, patientName, date, time, reason);
        appointmentSystem.addAppointment(appointment);
        System.out.println("Appointment has been scheduled successfully!");
    }
    // Checks for Appointments related to a specific doctor or patient and displays the result
    private static void checkAppointments() {
        System.out.println("\n---- Check Appointments ----");
        System.out.print(" Enter Patient or Doctor Name: ");
        String name = scanner.nextLine();

        List<Appointment> appointments = appointmentSystem.getAppointments(name);
        if (appointments.isEmpty()) {
            System.out.println(" No appointments found for " + name);
        } else {
            System.out.println("\n---- Appointments ----");
            for (Appointment appointment : appointments) {
                System.out.println("ID: " + appointment.getAppointmentID() +
                                   ", Doctor: " + appointment.getDoctor() +
                                   ", Patient: " + appointment.getPatient() +
                                   ", Date: " + appointment.getDate() +
                                   ", Time: " + appointment.getTime() +
                                   ", Reason: " + appointment.getReason());
            }
        }
    }
}