import java.util.Scanner;

public class SimpleBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double balance = 10000;
        double dailyLimit = 20000;
        double totalWithdrawnToday = 0;

        System.out.print("Enter your PIN: ");
        String pin = sc.nextLine();

        if (!pin.equals("1234")) {
            System.out.println("Wrong PIN. Access denied.");
            return;
        }

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Current Balance: Rs. " + balance);

            } else if (choice == 2) {
                System.out.print("Enter amount to deposit: ");
                double amount = sc.nextDouble();

                if (amount > 0) {
                    balance += amount;
                    System.out.println("Successfully deposited!");
                    System.out.println("New Balance: Rs. " + balance);
                } else {
                    System.out.println("Invalid amount!");
                }

            } else if (choice == 3) {
                System.out.print("Enter amount to withdraw: ");
                double amount = sc.nextDouble();

                if (amount <= 0) {
                    System.out.println("Invalid amount!");
                } else if (totalWithdrawnToday + amount > dailyLimit) {
                    System.out.println("Daily withdrawal limit of Rs. 20000 reached!");
                } else if (amount <= balance) {
                    balance -= amount;
                    totalWithdrawnToday += amount;
                    System.out.println("Please collect your cash.");
                    System.out.println("Remaining Balance: Rs. " + balance);
                } else {
                    double extraNeeded = amount - balance;
                    if (extraNeeded <= 5000) {
                        System.out.println("Insufficient balance. Use Overdraft feature?");
                        System.out.println("Extra charge will be Rs. 250.");
                        System.out.print("Press 1 for Yes, 2 for No: ");
                        int odChoice = sc.nextInt();

                        if (odChoice == 1) {
                            balance = balance - amount - 250;
                            totalWithdrawnToday += amount;
                            System.out.println("Overdraft Approved!");
                            System.out.println("New Balance: Rs. " + balance);
                        } else {
                            System.out.println("Transaction cancelled.");
                        }
                    } else {
                        System.out.println("Amount exceeds regular balance and maximum overdraft limit.");
                    }
                }

            } else if (choice == 4) {
                System.out.println("Thank you for using our bank!");
                break;

            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
        
        sc.close();
    }
}