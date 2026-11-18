import java.util.Scanner;

public class SmartRestaurantOrder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Constants
        final double DRINK_PRICE = 15.50;
        final double STUDENT_DISCOUNT = 0.10;
        final double SENIOR_DISCOUNT = 0.05;
        final double TIP_RATE = 0.10;

        // Customer information
        System.out.print("Enter customer name: ");
        String customerName = input.nextLine();

        System.out.print("Enter customer age: ");
        int age = input.nextInt();

        System.out.print("Enter meal price: $");
        double mealPrice = input.nextDouble();

        System.out.print("Enter number of drinks: ");
        int drinkCount = input.nextInt();

        System.out.print("Is the customer a student? (true/false): ");
        boolean isStudent = input.nextBoolean();

        System.out.print("Enter service rating (1-5): ");
        int rating = input.nextInt();

        // Validate the service rating
        if (rating < 1 || rating > 5) {
            System.out.println("Error: Service rating must be between 1 and 5.");
        } else if (mealPrice < 0 || drinkCount < 0 || age < 0) {
            System.out.println("Error: Age, meal price, and drink count cannot be negative.");
        } else {
            // Calculate the costs
            double drinksCost = drinkCount * DRINK_PRICE;
            double subtotal = mealPrice + drinksCost;

            // Apply only one discount: the larger eligible discount
            double discountRate;
            if (isStudent && age >= 60) {
                discountRate = STUDENT_DISCOUNT;
            } else if (isStudent) {
                discountRate = STUDENT_DISCOUNT;
            } else if (age >= 60) {
                discountRate = SENIOR_DISCOUNT;
            } else {
                discountRate = 0.0;
            }

            double discountAmount = subtotal * discountRate;
            double discountedTotal = subtotal - discountAmount;

            // Add a 10% tip for ratings of 4 or 5
            double tipAmount;
            if (rating == 4 || rating == 5) {
                tipAmount = discountedTotal * TIP_RATE;
            } else {
                tipAmount = 0.0;
            }

            double finalBill = discountedTotal + tipAmount;
            int wholeAmount = (int) finalBill; // Removes the decimal part

            // Print the receipt
            System.out.println();
            System.out.println("========== SMART RESTAURANT ==========");
            System.out.println("Customer: " + customerName);
            System.out.printf("Meal: $%.2f%n", mealPrice);
            System.out.printf("Drinks: $%.2f%n", drinksCost);
            System.out.printf("Discount: $%.2f%n", discountAmount);
            System.out.printf("Tip: $%.2f%n", tipAmount);
            System.out.printf("Final bill: $%.2f%n", finalBill);
            System.out.println("Whole amount: $" + wholeAmount);
            System.out.println("======================================");
        }

        input.close();
    }
}
