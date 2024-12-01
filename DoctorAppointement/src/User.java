/**
* Abstract base class representing a user in the medical appointment system.
* Provides common attributes and functionality for both doctors and patients.
* Cannot be instantiated directly - must be extended by concrete classes.
*/
public abstract class User {
   // Unique identifier for each user in the system
   private String id;
   // Full name of the user
   private String name;
   // Contact email address
   private String email;
   // Contact phone number
   private String phoneNumber;
   // Type of user ("doctor" or "patient")
   private String userType;

   /**
    * Constructor for creating a new user
    * @param id Unique identifier for the user
    * @param name Full name of the user
    * @param email Contact email address
    * @param phoneNumber Contact phone number
    * @param userType Type of user ("doctor" or "patient")
    */
   public User(String id, String name, String email, String phoneNumber, String userType) {
       this.id = id;
       this.name = name;
       this.email = email;
       this.userType = userType;
       this.phoneNumber = phoneNumber;
   }

   /**
    * Gets the user's unique identifier
    * @return String representing user's ID
    */
   public String getId() {
       return id;
   }

   /**
    * Gets the user's full name
    * @return String representing user's name
    */
   public String getName() {
       return name;
   }

   /**
    * Gets the user's email address
    * @return String representing user's email
    */
   public String getEmail() {
       return email;
   }

   /**
    * Gets the user's phone number
    * @return String representing user's phone number
    */
   public String getPhoneNumber() {
       return phoneNumber;
   }

   /**
    * Gets the type of user
    * @return String indicating whether user is a "doctor" or "patient"
    */
   public String getUserType() {
       return userType;
   }
}