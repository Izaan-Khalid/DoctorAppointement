import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

/**
 * ================================================================
 * Code Artifact: AppointmentSystem
 * Description:   Manages the entire appointment scheduling system for a medical facility.
 *                Handles registration and tracking of doctors, patients, and appointments.
 *                  Provides functionality for searching doctors and managing appointments.
 * Authors: Izaan Khalid
 * Date: November 22, 2024
 * ================================================================
 */


public class AppointmentSystem {
    // List to store all registered doctors in the system
    private List<Doctor> doctors;
    // List to store all registered patients in the system
    private List<Patient> patients;
    // List to store all appointments (past, present, and future)
    private List<Appointment> appointments;

    /**
     * Constructor initializes empty lists for doctors, patients, and appointments
     */
    public AppointmentSystem() {
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    /**
     * Registers a new doctor in the system
     * @param doctor The doctor to be added to the system
     */
    public void registerDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
    
    /**
     * Registers a new patient in the system
     * @param patient The patient to be added to the system
     */
    public void registerPatient(Patient patient) {
        patients.add(patient);
    }

    /* Adds an appointment to the system */
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public List<Appointment> getAppointments(String name) {
        return appointments.stream()
                .filter(a -> a.getDoctor().equalsIgnoreCase(name) || a.getPatient().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
    

    /**
     * Searches for doctors by their specialization
     * @param specialization The medical specialization to search for
     * @return List of doctors matching the specified specialization
     */
    public List<Doctor> searchDoctors(String specialization) {
        return doctors.stream()
                .filter(d -> d.getSpecialization().equalsIgnoreCase(specialization))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all appointments for a specific user (doctor or patient)
     * @param user The user (doctor or patient) whose appointments are to be retrieved
     * @return List of appointments associated with the user
     *         Returns empty list if user type is neither doctor nor patient
     */
    public List<Appointment> getAppointments(User user) {
        if (user instanceof Doctor) {
            // Filter appointments for the specified doctor
            return appointments.stream()
                    .filter(a -> a.getDoctor().equals(user))
                    .collect(Collectors.toList());
        } else if (user instanceof Patient) {
            // Filter appointments for the specified patient
            return appointments.stream()
                    .filter(a -> a.getPatient().equals(user))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();  // Return empty list for invalid user types
    }
}