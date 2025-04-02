import java.util.Scanner;

public class ATMSim{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 1000;  // Initial balance
        boolean exit = false;

        while (!exit) {
            try {
                
                System.out.println("\nATM Menu:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Select an option (1-4): ");
                int choice = scanner.nextInt();

                
                try {
                    switch (choice) {
                        case 1:
                            System.out.print("Enter deposit amount: ");
                            double depositAmount = scanner.nextDouble();
                            if (depositAmount <= 0) {
                                throw new IllegalArgumentException("Amount must be positive.");
                            }
                            balance += depositAmount;
                            System.out.println("Deposit successful! Current balance: $" + balance);
                            break;
                        case 2:
                            System.out.print("Enter withdrawal amount: ");
                            double withdrawAmount = scanner.nextDouble();
                            if (withdrawAmount <= 0) {
                                throw new IllegalArgumentException("Amount must be positive.");
                            }
                            if (withdrawAmount > balance) {
                                throw new IllegalArgumentException("Insufficient funds.");
                            }
                            balance -= withdrawAmount;
                            System.out.println("Withdrawal successful! Current balance: $" + balance);
                            break;
                        case 3:
                            System.out.println("Current balance: $" + balance);
                            break;
                        case 4:
                            System.out.println("Thank you for using the ATM. Goodbye!");
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid option. Please select between 1 and 4.");
                            break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } catch (Exception e) {
            
                System.out.println("Invalid input! Please enter a number between 1 and 4.");
                scanner.nextLine();  
            }
        }

        scanner.close();
    }
}
