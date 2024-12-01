/**
 * Represents a medical appointment in a healthcare system.
 * This class manages the relationship between doctors, patients, and scheduled time slots.
 * 
 * Key features:
 * - Tracks appointment status (pending, confirmed, cancelled)
 * - Manages booking and cancellation of time slots
 * - Stores appointment details including doctor, patient, and reason
 * - Provides unique identification for each appointment
 * 
 * Status workflow:
 * 1. Created as "pending"
 * 2. Can be updated to "confirmed" when approved
 * 3. Can be "cancelled" at any time
 */
public class Appointment {
    // Unique identifier for each appointment
    private String appointmentID;
    // Reference to the doctor conducting the appointment
    private String doctor;
    // Reference to the patient attending the appointment
    private String patient;
    // Time slot allocated for this appointment
    private String date;
    private String time;
    // Current status of the appointment (pending, confirmed, cancelled)
    private String status;
    // Reason or description for the appointment
    private String reason;

    /**
     * Constructor to create a new appointment
     * Initializes with pending status and empty reason
     */
    public Appointment(String id, String doctor, String patient, String date, String time, String reason) {
        this.appointmentID = id;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.time = time;
        this.status = "pending";  // Default status for new appointments
        this.reason = reason;
    }
    // Getter methods to access appointment details
    public String getAppointmentID() {
        return appointmentID;
    }
    public String getDoctor() {
        return doctor;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public String getPatient() {
        return patient;
    }
    public String getStatus() {
        return status;
    }
    public String getReason() {
        return reason;
    }
}