package javacollectionstreams.javagenerics;
import java.util.Scanner;   // Import Scanner for user input

/*
 * This program represents a Dynamic Online Marketplace.
 * A generic Product class is used to store different product categories safely.
 * A generic method is used to apply discounts dynamically.
 * User input is taken to enter product details and discount percentage.
 */

// Generic Product class
class Product<T> {

    String name;     // Variable to store product name
    double price;    // Variable to store product price
    T category;      // Generic variable to store product category

    // Constructor to initialize product details
    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Method to display product details
    void showProduct() {
        System.out.println("Product Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Final Price: " + price);
    }
}

// Main class
public class OnlineMarketplace {

    // Generic method to apply discount
    static <T> void applyDiscount(Product<T> product, double percent) {

        // Calculate discounted price
        product.price -= (product.price * percent / 100);
    }

    // Main method
    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Take product name from user
        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        // Take product price from user
        System.out.print("Enter product price: ");
        double price = sc.nextDouble();
        sc.nextLine(); // Consume leftover newline

        // Take product category from user
        System.out.print("Enter product category: ");
        String category = sc.nextLine();

        // Create Product object using generics
        Product<String> product = new Product<>(name, price, category);

        // Take discount percentage from user
        System.out.print("Enter discount percentage: ");
        double discount = sc.nextDouble();

        // Apply discount using generic method
        applyDiscount(product, discount);

        // Display final product details
        System.out.println("\n--- Product Details After Discount ---");
        product.showProduct();

        // Close scanner
        sc.close();
    }
}
