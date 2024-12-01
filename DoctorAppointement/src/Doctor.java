import java.util.List;
import java.util.ArrayList;

/**
* Represents a Doctor in the medical appointment system.
* Extends the User class with additional doctor-specific attributes and functionalities.
* Manages doctor's specialization, license, available time slots, and appointments.
*/
public class Doctor extends User {
   // Medical specialization of the doctor (e.g., Cardiology, Pediatrics)
   private String specilization;
   // Doctor's medical license/registration number
   private String licenseNumber;
   // List of all appointments (scheduled, completed, cancelled) for this doctor
   private List<Appointment> appointments;

   /**
    * Constructor to create a new Doctor user
    * @param id Unique identifier for the doctor
    * @param name Full name of the doctor
    * @param email Contact email address
    * @param phoneNumber Contact phone number
    * @param specilization Medical specialization
    * @param licenseNumber Medical license number
    */
   public Doctor(String id, String name, String email, String phoneNumber, String specilization, String licenseNumber) {
       super(id, name, email, phoneNumber, "doctor");  // Initialize base User class
       this.specilization = specilization;
       this.licenseNumber = licenseNumber;
       this.appointments = new ArrayList<>();          // Initialize empty list of appointments
   }
   
   /**
    * Returns a copy of doctor's appointments list
    * Returns a new ArrayList to prevent external modification of appointments
    * @return List of all appointments for this doctor
    */
   public List<Appointment> viewAppointments() {
       return new ArrayList<>(appointments);  // Return defensive copy
   }

   /**
    * Gets the doctor's medical specialization
    * @return String representing doctor's area of specialization
    */
   public String getSpecialization() {
       return specilization;
   }

   /**
    * Gets the doctor's medical license number
    * @return String representing doctor's license number
    */
   public String getLicenseNumber() {
       return licenseNumber;
   }
}
