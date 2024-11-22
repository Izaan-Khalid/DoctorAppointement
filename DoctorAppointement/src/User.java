public abstract class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String userType;
    private static int idCounter = 0;

    public User(String name, String email, String password, String phoneNumber, String userType) {
        this.id = ++idCounter;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.phoneNumber = phoneNumber;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
     public String getUserType() {
        return userType;
    }

}
