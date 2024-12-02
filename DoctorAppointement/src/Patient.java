
/**
 * ================================================================
 * Code Artifact: Patient
 * Description:   Represents a Patient in the medical appointment system.
 *                Extends the User class with patient-specific attributes.
 *                Maintains patient's personal information including residential address.
 * Authors: Izaan Khalid
 * Date: November 22, 2024
 * ================================================================
 */

public class Patient extends User {
   // Residential address of the patient for medical records
   private String address;

   /**
    * Constructor to create a new Patient user
    * @param id Unique identifier for the patient
    * @param name Full name of the patient
    * @param email Contact email address
    * @param phoneNumber Contact phone number
    * @param address Residential address of the patient
    */
   public Patient(String id, String name, String email, String phoneNumber, String address) {
       super(id, name, email, phoneNumber, "patient");  // Initialize base User class
       this.address = address;
   }

   /**
    * Gets the patient's residential address
    * @return String representing patient's address
    */
   public String getAddress() {
       return address;
   }
}