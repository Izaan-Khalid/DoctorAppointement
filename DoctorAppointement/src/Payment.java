import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * ================================================================
 * Code Artifact: Payment
 * Description: This class simulates the payment process for medical services. 
 *              It collects payment information, validates the input (such as 
 *              credit card number or insurance provider), and processes the 
 *              payment. It also handles various payment methods: credit card, 
 *              cash, and insurance.
 * Authors: Loveline Djamda
 * Date: November 25, 2024
 * ================================================================
 */

public class Payment {
    // Payment details fields
    private double amount;         // The total payment amount
    private String paymentMethod;  // The method used for payment (credit card, cash, insurance)
    private String paymentStatus;  // The status of the payment (Successful, Failed, Pending)
    private boolean isInsurance;   // True if insurance is used, false if patient pays directly

    // Constructor to initialize payment amount and default values
    public Payment(double amount) {
        this.amount = amount;       // Initialize the payment amount
        this.paymentStatus = "Pending";  // Default payment status is Pending
        this.isInsurance = false;   // Default is no insurance used
    }

    /**
     * Method to simulate the payment process. It handles different payment 
     * methods, validates inputs, and sets the payment status.
     */
    public void processPayment() {
        Scanner scanner = new Scanner(System.in);

        // Ask for payment method (credit card, cash, or insurance)
        System.out.println("Choose a payment method (credit card/cash/insurance): ");
        paymentMethod = scanner.nextLine().toLowerCase();  // Get user input and convert to lowercase

        // Validate payment method
        while (!paymentMethod.equals("credit card") && !paymentMethod.equals("cash") && !paymentMethod.equals("insurance")) {
            System.out.println("Invalid payment method. Please choose 'credit card', 'cash', or 'insurance'.");
            paymentMethod = scanner.nextLine().toLowerCase();  // Re-prompt if input is invalid
        }

        // Process payment based on the selected method
        if (paymentMethod.equals("credit card")) {
            // Processing payment via Credit Card
            System.out.println("Processing payment via Credit Card...");
            System.out.println("Please enter your credit card number: ");
            String cardNumber = scanner.nextLine();
            // Simulate card validation (in a real-world scenario, you'd interact with a payment gateway)
            if (isValidCreditCard(cardNumber)) {  // Check if the card number is valid
                paymentStatus = "Successful";  // Set status to Successful if card is valid
            } else {
                paymentStatus = "Failed";  // Set status to Failed if card is invalid
            }
        } else if (paymentMethod.equals("cash")) {
            // Processing payment via Cash
            System.out.println("Processing payment via Cash...");
            paymentStatus = "Successful";  // Cash payment is considered successful by default
        } else if (paymentMethod.equals("insurance")) {
            // Processing payment via Insurance
            System.out.println("Processing payment via Insurance...");
            System.out.println("Please enter your insurance provider: ");
            String insuranceProvider = scanner.nextLine();

            // Simulate insurance validation
            if (isValidInsurance(insuranceProvider)) {  // Validate the insurance provider
                paymentStatus = "Successful";
                isInsurance = true;  // Mark as insurance-based payment
                System.out.println("Insurance coverage applied. Payment processed through insurance.");
            } else {
                paymentStatus = "Failed";  // Set status to Failed if insurance is invalid
                System.out.println("Invalid insurance provider. Insurance payment failed.");
            }
        }

        // Display payment status
        System.out.println("Payment " + paymentStatus + " for amount: $" + amount);
    }

    /**
     * Method to validate credit card number using the simple Luhn algorithm.
     * This checks if the card number is valid.
     */
    private boolean isValidCreditCard(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        // Loop through each digit of the card number from right to left
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));  // Get the digit
            if (alternate) {
                n *= 2;  // Double every second digit
                if (n > 9) {
                    n -= 9;  // Subtract 9 from numbers over 9 (Luhn algorithm)
                }
            }
            sum += n;  // Add the digit to the total sum
            alternate = !alternate;  // Alternate between true and false for each digit
        }
        return (sum % 10 == 0);  // If the sum is divisible by 10, the card number is valid
    }

    /**
     * Method to validate insurance provider (for simplicity, only "Aetna" or "BlueCross" are valid).
     */
    private boolean isValidInsurance(String insuranceProvider) {
        // Check if the provided insurance provider matches "Aetna" or "BlueCross"
        return insuranceProvider.equalsIgnoreCase("Aetna") || insuranceProvider.equalsIgnoreCase("BlueCross");
    }

    /**
     * Method to confirm the payment status and display a message accordingly.
     */
    public void confirmPayment() {
        if (paymentStatus.equals("Successful")) {
            System.out.println("Payment confirmed. Thank you for your payment.");
        } else {
            System.out.println("Payment failed. Please try again.");
        }
    }

    /**
     * Getter method for payment status (optional, in case the payment status is needed elsewhere).
     */
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * Main method to simulate the payment process and confirm the payment.
     */
    public static void main(String[] args) {
        // Create a Payment object with a total amount of $100
        Payment payment = new Payment(100.0);

        // Process the payment
        payment.processPayment();

        // Confirm the payment status
        payment.confirmPayment();
    }
}