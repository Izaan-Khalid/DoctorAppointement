import java.util.ArrayList;
import java.util.List;
public class Patient extends User {
    private String medicalHistory;
    private String address;
    private String insuranceDetails;
    private List<Appointment> appointments;

    public Patient(String name, String email, String password, String phoneNumber, String medicalHistory, String address, String insuranceDetails) {
        super(name, email, password, phoneNumber, "patient");
        this.medicalHistory = medicalHistory;
        this.address = address;
        this.insuranceDetails = insuranceDetails;
        this.appointments = new ArrayList<>();
    }
    public String getMedicalHistory() {
        return medicalHistory;
    }
    public String getAddress() {
        return address;
    }
    public String getInsuranceDetails() {
        return insuranceDetails;
    }

    public Appointment bookAppointment(Doctor doctor, TimeSlot slot) {
        if (slot.checkAvailability()) {
            Appointment appointment = new Appointment(doctor, this, slot);
            appointments.add(appointment);
            return appointment;
        }
        return null;
    }
}
