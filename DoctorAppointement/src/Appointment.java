public class Appointment {
    private int appointmentID;
    private Doctor doctor;
    private Patient patient;
    private TimeSlot slot;
    private String status;
    private String reason;

    public Appointment(Doctor doctor, Patient patient, TimeSlot slot) {
        this.doctor = doctor;
        this.patient = patient;
        this.slot = slot;
        this.status = "pending";
        this.reason = "";
    }

    public void cancelAppointment() {
        this.status = "cancelled";
        this.slot.cancel();
    }

    public void confirmAppointment() {
        this.status = "confirmed";
        this.slot.book();
    }

    public int getAppointmentID() {
        return appointmentID;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public Patient getPatient() {
        return patient;
    }
    public TimeSlot getSlot() {
        return slot;
    }
    public String getStatus() {
        return status;
    }
    public String getReason() {
        return reason;
    }
}
