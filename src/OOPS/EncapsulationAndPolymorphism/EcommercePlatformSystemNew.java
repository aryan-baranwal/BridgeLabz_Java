/*
 This program demonstrates abstraction, interfaces, encapsulation, and polymorphism.
 Different product types calculate discount and tax differently in an e-commerce system.
*/

import java.util.ArrayList;

public class EcommercePlatformSystemNew {

    // Interface for taxable products
    interface Taxable {
        double calculateTax();
        String getTaxDetails();
    }

    // Abstract class Product
    static abstract class Product {

        // Encapsulated fields
        private int productId;
        private String name;
        private double price;

        // Constructor
        Product(int productId, String name, double price) {
            this.productId = productId;
            this.name = name;
            this.price = price;
        }

        // Getter methods
        public int getProductId() {
            return productId;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        // Setter to update price safely
        public void setPrice(double price) {
            if (price > 0) {
                this.price = price;
            }
        }

        // Abstract method for discount calculation
        abstract double calculateDiscount();
    }

    // Electronics product
    static class Electronics extends Product implements Taxable {

        Electronics(int id, String name, double price) {
            super(id, name, price);
        }

        // Discount for electronics
        @Override
        double calculateDiscount() {
            return getPrice() * 0.10; // 10% discount
        }

        // Tax for electronics
        @Override
        public double calculateTax() {
            return getPrice() * 0.18; // 18% GST
        }

        @Override
        public String getTaxDetails() {
            return "Electronics Tax: 18%";
        }
    }

    // Clothing product
    static class Clothing extends Product implements Taxable {

        Clothing(int id, String name, double price) {
            super(id, name, price);
        }

        // Discount for clothing
        @Override
        double calculateDiscount() {
            return getPrice() * 0.20; // 20% discount
        }

        // Tax for clothing
        @Override
        public double calculateTax() {
            return getPrice() * 0.12; // 12% GST
        }

        @Override
        public String getTaxDetails() {
            return "Clothing Tax: 12%";
        }
    }

    // Groceries product (no tax)
    static class Groceries extends Product {

        Groceries(int id, String name, double price) {
            super(id, name, price);
        }

        // Discount for groceries
        @Override
        double calculateDiscount() {
            return getPrice() * 0.05; // 5% discount
        }
    }

    // Polymorphic method to print final price
    static void printFinalPrice(Product product) {

        double tax = 0;

        // Check if product is taxable
        if (product instanceof Taxable) {
            tax = ((Taxable) product).calculateTax();
            System.out.println(((Taxable) product).getTaxDetails());
        }

        double discount = product.calculateDiscount();
        double finalPrice = product.getPrice() + tax - discount;

        System.out.println("Product : " + product.getName());
        System.out.println("Base Price : " + product.getPrice());
        System.out.println("Discount   : " + discount);
        System.out.println("Final Price: " + finalPrice);
        System.out.println();
    }

    public static void main(String[] args) {

        // Creating product list
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Electronics(1, "Laptop", 60000));
        products.add(new Clothing(2, "Jacket", 4000));
        products.add(new Groceries(3, "Rice Bag", 1200));

        // Processing products polymorphically
        for (Product p : products) {
            printFinalPrice(p);
        }
    }
}
