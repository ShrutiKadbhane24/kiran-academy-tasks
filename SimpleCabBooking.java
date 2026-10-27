import java.util.Scanner;
import java.util.Random;

public class SimpleCabBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] routes = {"Pune Station to Shivajinagar", "Swargate to Kothrud", "Hinjawadi to Wakad"};
        int[] distances = {5, 8, 10};

        while (true) {
            System.out.println("\n--- CAB BOOKING ---");
            System.out.println("1. Book a Ride");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            
            int mainChoice = sc.nextInt();

            if (mainChoice == 2) {
                System.out.println("Thank you! Visit again.");
                break;
            }

            if (mainChoice != 1) {
                System.out.println("Invalid choice!");
                continue;
            }

            System.out.println("\nSelect Cab Type:");
            System.out.println("1. Auto (Rs. 12/km)");
            System.out.println("2. Sedan (Rs. 18/km)");
            System.out.println("3. SUV (Rs. 25/km)");
            System.out.print("Enter cab choice: ");
            int cabChoice = sc.nextInt();

            int rate = 0;
            String cabType = "";

            if (cabChoice == 1) {
                cabType = "Auto";
                rate = 12;
            } else if (cabChoice == 2) {
                cabType = "Sedan";
                rate = 18;
            } else if (cabChoice == 3) {
                cabType = "SUV";
                rate = 25;
            } else {
                System.out.println("Invalid cab type selected.");
                continue;
            }

            System.out.println("\nSelect Route:");
            System.out.println("1. Pune Station to Shivajinagar (5 km)");
            System.out.println("2. Swargate to Kothrud (8 km)");
            System.out.println("3. Hinjawadi to Wakad (10 km)");
            System.out.print("Enter route choice: ");
            int routeChoice = sc.nextInt();

            if (routeChoice < 1 || routeChoice > 3) {
                System.out.println("Invalid route selected.");
                continue;
            }

            int index = routeChoice - 1;
            int totalFare = distances[index] * rate;

            System.out.println("\n--- RIDE SUMMARY ---");
            System.out.println("Cab: " + cabType);
            System.out.println("Route: " + routes[index]);
            System.out.println("Distance: " + distances[index] + " km");
            System.out.println("Total Fare: Rs. " + totalFare);

            System.out.println("\nConfirm Ride?");
            System.out.println("1. Yes, Confirm");
            System.out.println("2. Cancel");
            System.out.print("Enter choice: ");
            int confirm = sc.nextInt();

            if (confirm == 1) {
                int otp = 1000 + rand.nextInt(9000);
                System.out.println("\nBooking Confirmed!");
                System.out.println("Your OTP is: " + otp);
            } else {
                System.out.println("Ride cancelled.");
            }
        }

        sc.close();
    }
}