import java.util.Scanner;
import java.util.regex.Pattern;

public class Payment {

    // Payment details fields
    private double amount;
    private String paymentMethod;
    private String paymentStatus;
    private boolean isInsurance;  // True if insurance is used, false if patient pays

    // Constructor to initialize payment amount
    public Payment(double amount) {
        this.amount = amount;
        this.paymentStatus = "Pending";  // Default status
        this.isInsurance = false;
    }

    // Method to simulate payment process
    public void processPayment() {
        Scanner scanner = new Scanner(System.in);

        // Ask for payment method
        System.out.println("Choose a payment method (credit card/cash/insurance): ");
        paymentMethod = scanner.nextLine().toLowerCase();

        // Validate payment method
        while (!paymentMethod.equals("credit card") && !paymentMethod.equals("cash") && !paymentMethod.equals("insurance")) {
            System.out.println("Invalid payment method. Please choose 'credit card', 'cash', or 'insurance'.");
            paymentMethod = scanner.nextLine().toLowerCase();
        }

        // Process payment based on the selected method
        if (paymentMethod.equals("credit card")) {
            System.out.println("Processing payment via Credit Card...");
            // Simulate card payment (in a real-world scenario, you would interact with a payment gateway API)
            System.out.println("Please enter your credit card number: ");
            String cardNumber = scanner.nextLine();
            // Simulate card validation (in real world, this would involve more checks)
            if (isValidCreditCard(cardNumber)) {
                paymentStatus = "Successful";
            } else {
                paymentStatus = "Failed";
            }
        } else if (paymentMethod.equals("cash")) {
            System.out.println("Processing payment via Cash...");
            paymentStatus = "Successful";
        } else if (paymentMethod.equals("insurance")) {
            // If the user selects insurance, we check if the insurance is valid
            System.out.println("Processing payment via Insurance...");
            System.out.println("Please enter your insurance provider: ");
            String insuranceProvider = scanner.nextLine();

            // Simulate insurance validation (this can be expanded)
            if (isValidInsurance(insuranceProvider)) {
                paymentStatus = "Successful";
                isInsurance = true;
                System.out.println("Insurance coverage applied. Payment processed through insurance.");
            } else {
                paymentStatus = "Failed";
                System.out.println("Invalid insurance provider. Insurance payment failed.");
            }
        }

        // Display payment status
        System.out.println("Payment " + paymentStatus + " for amount: $" + amount);
    }

    // Method to validate credit card number (simple Luhn algorithm for card number validation)
    private boolean isValidCreditCard(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

    // Method to validate insurance provider (simplified for this example)
    private boolean isValidInsurance(String insuranceProvider) {
        // For simplicity, we assume "valid" insurance providers are "Aetna" or "BlueCross"
        return insuranceProvider.equalsIgnoreCase("Aetna") || insuranceProvider.equalsIgnoreCase("BlueCross");
    }

    // Method to confirm the payment
    public void confirmPayment() {
        if (paymentStatus.equals("Successful")) {
            System.out.println("Payment confirmed. Thank you for your payment.");
        } else {
            System.out.println("Payment failed. Please try again.");
        }
    }

    // Getter for payment status (optional, in case you need to access it later)
    public String getPaymentStatus() {
        return paymentStatus;
    }

    // Main method to test the Payment functionality
    public static void main(String[] args) {
        // Assume the appointment cost is $100
        Payment payment = new Payment(100.0);

        // Process the payment
        payment.processPayment();

        // Confirm the payment status
        payment.confirmPayment();
    }
}

