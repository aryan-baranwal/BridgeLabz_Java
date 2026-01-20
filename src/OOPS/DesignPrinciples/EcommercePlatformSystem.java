/*
 This program demonstrates Association and Aggregation.
 A Customer places Orders, and each Order aggregates multiple Products.
*/

import java.util.ArrayList;

public class EcommercePlatformSystem {

    // Product class (independent entity)
    static class Product {
        String name;
        double price;

        // Constructor to initialize product details
        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    // Order class (aggregates Product objects)
    static class Order {
        int orderId;
        ArrayList<Product> products = new ArrayList<>();

        // Constructor to initialize order ID
        Order(int orderId) {
            this.orderId = orderId;
        }

        // Method to add product to order
        void addProduct(Product product) {
            products.add(product);
        }

        // Method to display order details
        void displayOrderDetails() {
            System.out.println("Order ID: " + orderId);
            double total = 0;

            for (Product p : products) {
                System.out.println("Product: " + p.name + " | Price: " + p.price);
                total += p.price;
            }

            System.out.println("Total Amount: " + total);
        }
    }

    // Customer class (associated with Order)
    static class Customer {
        String name;
        ArrayList<Order> orders = new ArrayList<>();

        // Constructor to initialize customer name
        Customer(String name) {
            this.name = name;
        }

        // Method to place an order (communication)
        void placeOrder(Order order) {
            orders.add(order);
            System.out.println(name + " placed Order ID " + order.orderId);
        }

        // Method to view all orders
        void viewOrders() {
            System.out.println("\nCustomer: " + name);
            for (Order o : orders) {
                o.displayOrderDetails();
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        // Creating products
        Product p1 = new Product("Laptop", 60000);
        Product p2 = new Product("Mouse", 800);
        Product p3 = new Product("Keyboard", 1500);

        // Creating customer
        Customer customer = new Customer("Aryan");

        // Creating order
        Order order1 = new Order(101);

        // Adding products to order (aggregation)
        order1.addProduct(p1);
        order1.addProduct(p2);
        order1.addProduct(p3);

        // Customer placing order (association + communication)
        customer.placeOrder(order1);

        // Customer viewing orders
        customer.viewOrders();
    }
}
