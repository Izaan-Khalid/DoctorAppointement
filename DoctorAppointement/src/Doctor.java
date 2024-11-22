import java.util.List;
import java.util.ArrayList;

public class Doctor extends User {
    private String specilization;
    private String licenseNumber;
    private List<TimeSlot> availableSlots;
    private List<Appointment> appointments;

    public Doctor(String name, String email, String password, String phoneNumber, String specilization, String licenseNumber) {
        super(name, email, password, phoneNumber, "doctor");
        this.specilization = specilization;
        this.licenseNumber = licenseNumber;
        this.availableSlots = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public void addAvailableSlot(TimeSlot slot) {
        availableSlots.add(slot);
    }

    public void removeAvailableSlot(TimeSlot slot) {
        availableSlots.remove(slot);
    }

    public List<Appointment> viewAppointments() {
        return new ArrayList<>(appointments);
    }

    public String getSpecialization() {
        return specilization;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
}
