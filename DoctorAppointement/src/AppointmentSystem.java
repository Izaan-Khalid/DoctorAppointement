import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class AppointmentSystem {
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Appointment> appointments;

    public AppointmentSystem() {
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public void registerDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
    
    public void registerPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Doctor> searchDoctors(String specialization) {
        return doctors.stream()
                .filter(d -> d.getSpecialization().equalsIgnoreCase(specialization))
                .collect(Collectors.toList());
    }

    public List<Appointment> getAppointments(User user) {
        if (user instanceof Doctor) {
            return appointments.stream()
                    .filter(a -> a.getDoctor().equals(user))
                    .collect(Collectors.toList());
        } else if (user instanceof Patient) {
            return appointments.stream()
                    .filter(a -> a.getPatient().equals(user))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
