import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * ================================================================
 * Code Artifact: AppointmentForm
 * Description: This program simulates an appointment form for patients. 
 *              It collects patient information, validates the input (such as 
 *              email, phone number, date, and time), and allows for virtual 
 *              or in-person consultations. The program then displays the 
 *              appointment details or cancels the appointment.
 * Authors: Loveline Djamda
 * Date: November 28, 2024
 * ================================================================
 */

public class AppointmentForm {
    // Appointment details fields
    private String patientName;
    private String doctorName;
    private String appointmentDate;
    private String appointmentTime;
    private String appointmentReason;
    private boolean isVirtual;  // True for Virtual, false for In-Person
    private String patientEmail;
    private String patientPhone;

    // Constructor to initialize patient name
    public AppointmentForm(String patientName) {
        this.patientName = patientName;  // Initializes the patient's name
    }

    /**
     * Method to input and validate patient profile details (name, email, and phone)
     */
    private void inputPatientProfile() {
        Scanner scanner = new Scanner(System.in);

        // Input Patient Name
        System.out.println("Enter your full name: ");
        patientName = scanner.nextLine();  // Read the patient's name from user input

        // Input Patient Email with basic validation
        while (true) {
            System.out.println("Enter your email: ");
            patientEmail = scanner.nextLine();
            if (isValidEmail(patientEmail)) {  // Check if the email is valid
                break;
            } else {
                System.out.println("Invalid email. Please enter a valid email address.");
            }
        }

        // Input Patient Phone Number with basic validation
        while (true) {
            System.out.println("Enter your phone number: ");
            patientPhone = scanner.nextLine();
            if (isValidPhoneNumber(patientPhone)) {  // Validate phone number format
                break;
            } else {
                System.out.println("Invalid phone number. Please enter a valid phone number.");
            }
        }
        scanner.close();
    }

    /**
     * Method to check if the email is valid using regex
     */
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);  // Regex pattern for email validation
        return pattern.matcher(email).matches();  // Return true if email matches the pattern
    }

    /**
     * Method to check if the phone number is valid (simple validation)
     */
    private boolean isValidPhoneNumber(String phone) {
        String phoneRegex = "^[0-9]{10}$";  // Simple validation for 10 digits
        Pattern pattern = Pattern.compile(phoneRegex);  // Regex pattern for phone number validation
        return pattern.matcher(phone).matches();  // Return true if phone number matches the pattern
    }

    /**
     * Method to input appointment details
     */
    public void fillForm() {
        Scanner scanner = new Scanner(System.in);

        // Input Patient Profile Details
        inputPatientProfile();  // Collect patient details (name, email, phone)

        // Input Doctor's Name
        System.out.print("Enter Doctor's Name: ");
        doctorName = scanner.nextLine();  // Read doctor's name from input

        // Input Appointment Date with validation
        while (true) {
            System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
            appointmentDate = scanner.nextLine();
            if (isValidDate(appointmentDate)) {  // Validate the date format
                break;
            } else {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }

        // Input Appointment Time with validation
        while (true) {
            System.out.print("Enter Appointment Time (HH:MM): ");
            appointmentTime = scanner.nextLine();
            if (isValidTime(appointmentTime)) {  // Validate the time format
                break;
            } else {
                System.out.println("Invalid time format. Please use HH:MM.");
            }
        }

        // Input Appointment Reason
        System.out.print("Enter the reason for the appointment: ");
        appointmentReason = scanner.nextLine();  // Get the reason for the appointment

        // Choose Appointment Type (Virtual or In-Person)
        System.out.print("Would you like to have a Virtual Consultation? (yes/no): ");
        String consultationType = scanner.nextLine().trim().toLowerCase();
        if (consultationType.equals("yes")) {
            isVirtual = true;  // Set virtual consultation flag
        } else if (consultationType.equals("no")) {
            isVirtual = false;  // Set in-person consultation flag
        } else {
            System.out.println("Invalid input. Defaulting to In-Person.");
            isVirtual = false;  // Default to in-person if input is invalid
        }
        scanner.close();
    }

    /**
     * Method to validate the date format (YYYY-MM-DD)
     */
    private boolean isValidDate(String date) {
        String dateRegex = "^\\d{4}-\\d{2}-\\d{2}$";  // YYYY-MM-DD format
        Pattern pattern = Pattern.compile(dateRegex);  // Regex for date format
        return pattern.matcher(date).matches();  // Check if date matches the pattern
    }

    /**
     * Method to validate time format (HH:MM)
     */
    private boolean isValidTime(String time) {
        String timeRegex = "^([01]\\d|2[0-3]):([0-5]\\d)$";  // HH:MM format
        Pattern pattern = Pattern.compile(timeRegex);  // Regex for time format
        return pattern.matcher(time).matches();  // Check if time matches the pattern
    }

    /**
     * Method to display appointment details and submit
     */
    public void submitForm() {
        // Simulate form submission (e.g., save to database or display confirmation)
        System.out.println("\nAppointment Submitted Successfully!");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Email: " + patientEmail);
        System.out.println("Phone: " + patientPhone);
        System.out.println("Doctor: " + doctorName);
        System.out.println("Appointment Date: " + appointmentDate);
        System.out.println("Appointment Time: " + appointmentTime);
        System.out.println("Reason for Appointment: " + appointmentReason);
        System.out.println("Consultation Type: " + (isVirtual ? "Virtual" : "In-Person"));
    }

    /**
     * Method to cancel the appointment form
     */
    public void cancelForm() {
        System.out.println("\nAppointment Form Canceled.");
    }

    // Getters for the fields (optional, in case you want to access them later)
    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public String getAppointmentReason() {
        return appointmentReason;
    }

    public boolean isVirtual() {
        return isVirtual;
    }

    /**
     * Main method to simulate filling and submitting an appointment form
     */
    public static void main(String[] args) {
        // Create an appointment form for a patient
        AppointmentForm appointment = new AppointmentForm("John Doe");

        // Fill the form
        appointment.fillForm();

        // Submit the form
        appointment.submitForm();

        // Alternatively, to cancel the form:
        // appointment.cancelForm();
    }
}
