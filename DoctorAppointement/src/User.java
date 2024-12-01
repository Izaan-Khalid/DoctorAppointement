public abstract class User {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String userType;

    public User(String id, String name, String email, String phoneNumber, String userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.phoneNumber = phoneNumber;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
     public String getUserType() {
        return userType;
    }

}
