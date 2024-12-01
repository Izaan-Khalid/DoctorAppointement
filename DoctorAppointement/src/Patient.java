public class Patient extends User {
    private String address;

    public Patient(String id, String name, String email, String phoneNumber, String address) {
        super(id, name, email, phoneNumber, "patient");
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
}
