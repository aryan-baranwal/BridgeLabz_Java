package javacollectionstreams.javagenerics;
import java.util.ArrayList;   // Import ArrayList
import java.util.List;        // Import List
import java.util.Scanner;     // Import Scanner for user input

/*
 * This program demonstrates a Smart Warehouse Management System using Java Generics.
 * The user can add Electronics or Grocery items to the warehouse at runtime.
 * A generic Storage class ensures type safety using bounded generics.
 * A wildcard method is used to display all stored warehouse items.
 */

// Abstract parent class
abstract class WarehouseItem {

    String name;   // Variable to store item name

    // Constructor to initialize item name
    WarehouseItem(String name) {
        this.name = name;
    }

    // Abstract method to display item details
    abstract void showDetails();
}

// Electronics class
class Electronics extends WarehouseItem {

    // Constructor
    Electronics(String name) {
        super(name);
    }

    // Method implementation
    public void showDetails() {
        System.out.println("Electronics Item: " + name);
    }
}

// Groceries class
class Groceries extends WarehouseItem {

    // Constructor
    Groceries(String name) {
        super(name);
    }

    // Method implementation
    public void showDetails() {
        System.out.println("Grocery Item: " + name);
    }
}

// Generic Storage class with bounded type
class Storage<T extends WarehouseItem> {

    // List to store items
    List<T> items = new ArrayList<>();

    // Method to add items
    void addItem(T item) {
        items.add(item);
    }

    // Method to return all items
    List<T> getItems() {
        return items;
    }
}

// Main class
public class SmartWarehouse {

    // Wildcard method to display any warehouse item
    static void displayItems(List<? extends WarehouseItem> list) {

        // Loop through list and show item details
        for (WarehouseItem item : list) {
            item.showDetails();
        }
    }

    // Main method
    public static void main(String[] args) {

        // Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Create storage objects
        Storage<Electronics> electronicsStore = new Storage<>();
        Storage<Groceries> groceriesStore = new Storage<>();

        // Ask user how many items to add
        System.out.print("Enter number of items to add: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        // Loop to take item details
        for (int i = 0; i < n; i++) {

            // Ask user to choose item type
            System.out.print("Enter item type (1-Electronics, 2-Groceries): ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            // Ask for item name
            System.out.print("Enter item name: ");
            String name = sc.nextLine();

            // Add item based on user choice
            if (choice == 1) {
                electronicsStore.addItem(new Electronics(name));
            } else if (choice == 2) {
                groceriesStore.addItem(new Groceries(name));
            } else {
                System.out.println("Invalid choice!");
            }
        }

        // Display stored Electronics items
        displayItems(electronicsStore.getItems());

        // Display stored Grocery items
        displayItems(groceriesStore.getItems());

        // Close scanner
        sc.close();
    }
}

