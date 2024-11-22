public class Patient extends User {
    private String medicalHistory;
    private String address;
    private String insuranceDetails;

    public Patient(String name, String email, String password, String phoneNumber, String medicalHistory, String address, String insuranceDetails) {
        super(name, email, password, phoneNumber, "patient");
        this.medicalHistory = medicalHistory;
        this.address = address;
        this.insuranceDetails = insuranceDetails;
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
}
