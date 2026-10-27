import java.util.Scanner;

public class ShoppingBill {

    public static double calculateElectronicsGST(double a, double b) {
        double subtotal = a + b;
        return subtotal + (subtotal * 0.18);
    }

    public static double calculateFashionGST(double c, double d) {
        double subtotal = c + d;
        return subtotal + (subtotal * 0.13);
    }

    public static double calculateFoodGST(double e) {
        return e + (e * 0.07);
    }

    public static double totalBill(double a, double b, double c, double d, double e) {
        double electronicsTotal = calculateElectronicsGST(a, b);
        double fashionTotal = calculateFashionGST(c, d);
        double foodTotal = calculateFoodGST(e);
        return electronicsTotal + fashionTotal + foodTotal;
    }

    public static double calculateDiscountedBill(double a, double b, double c, double d, double e) {
        double total = totalBill(a, b, c, d, e);
        double discount = total * 0.20;
        double finalAmount = total - discount;

        System.out.println("Total after GST = Rs. " + total);
        System.out.println("Discount = Rs. " + discount);
        System.out.println("Final payable amount = Rs. " + finalAmount);

        return finalAmount;
    }

    public static void main(String[] args) {
        double a = 100, b = 100, c = 100, d = 100, e = 100;
        calculateDiscountedBill(a, b, c, d, e);
    }
}