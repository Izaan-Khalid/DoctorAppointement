import java.util.Scanner;
import java.util.regex.Pattern;

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
        this.patientName = patientName;
    }

    // Method to input and validate patient profile details (name, email, and phone)
    private void inputPatientProfile() {
        Scanner scanner = new Scanner(System.in);

        // Input Patient Name
        System.out.println("Enter your full name: ");
        patientName = scanner.nextLine();

        // Input Patient Email with basic validation
        while (true) {
            System.out.println("Enter your email: ");
            patientEmail = scanner.nextLine();
            if (isValidEmail(patientEmail)) {
                break;
            } else {
                System.out.println("Invalid email. Please enter a valid email address.");
            }
        }

        // Input Patient Phone Number with basic validation
        while (true) {
            System.out.println("Enter your phone number: ");
            patientPhone = scanner.nextLine();
            if (isValidPhoneNumber(patientPhone)) {
                break;
            } else {
                System.out.println("Invalid phone number. Please enter a valid phone number.");
            }
        }
    }

    // Method to check if the email is valid using regex
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    // Method to check if the phone number is valid (simple validation)
    private boolean isValidPhoneNumber(String phone) {
        String phoneRegex = "^[0-9]{10}$";  // Simple validation for 10 digits
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(phone).matches();
    }

    // Method to input appointment details
    public void fillForm() {
        Scanner scanner = new Scanner(System.in);

        // Input Patient Profile Details
        inputPatientProfile();

        // Input Doctor's Name
        System.out.print("Enter Doctor's Name: ");
        doctorName = scanner.nextLine();

        // Input Appointment Date with validation
        while (true) {
            System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
            appointmentDate = scanner.nextLine();
            if (isValidDate(appointmentDate)) {
                break;
            } else {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }

        // Input Appointment Time with validation
        while (true) {
            System.out.print("Enter Appointment Time (HH:MM): ");
            appointmentTime = scanner.nextLine();
            if (isValidTime(appointmentTime)) {
                break;
            } else {
                System.out.println("Invalid time format. Please use HH:MM.");
            }
        }

        // Input Appointment Reason
        System.out.print("Enter the reason for the appointment: ");
        appointmentReason = scanner.nextLine();

        // Choose Appointment Type (Virtual or In-Person)
        System.out.print("Would you like to have a Virtual Consultation? (yes/no): ");
        String consultationType = scanner.nextLine().trim().toLowerCase();
        if (consultationType.equals("yes")) {
            isVirtual = true;
        } else if (consultationType.equals("no")) {
            isVirtual = false;
        } else {
            System.out.println("Invalid input. Defaulting to In-Person.");
            isVirtual = false;
        }
    }

    // Method to validate the date format (YYYY-MM-DD)
    private boolean isValidDate(String date) {
        String dateRegex = "^\\d{4}-\\d{2}-\\d{2}$";  // YYYY-MM-DD format
        Pattern pattern = Pattern.compile(dateRegex);
        return pattern.matcher(date).matches();
    }

    // Method to validate time format (HH:MM)
    private boolean isValidTime(String time) {
        String timeRegex = "^([01]\\d|2[0-3]):([0-5]\\d)$";  // HH:MM format
        Pattern pattern = Pattern.compile(timeRegex);
        return pattern.matcher(time).matches();
    }

    // Method to display appointment details and submit
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

    // Method to cancel the appointment form
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

    // Main method to simulate filling and submitting an appointment form
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