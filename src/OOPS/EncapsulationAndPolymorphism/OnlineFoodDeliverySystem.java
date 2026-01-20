/*
 This program demonstrates abstraction, interfaces, encapsulation, and polymorphism.
 Different food items calculate total price differently in an online food delivery system.
*/

import java.util.ArrayList;

public class OnlineFoodDeliverySystem {

    // Interface for discount-related behavior
    interface Discountable {
        double applyDiscount();
        String getDiscountDetails();
    }

    // Abstract class FoodItem
    static abstract class FoodItem {

        // Encapsulated fields
        private String itemName;
        private double price;
        private int quantity;

        // Constructor to initialize food item details
        FoodItem(String itemName, double price, int quantity) {
            this.itemName = itemName;
            this.price = price;
            this.quantity = quantity;
        }

        // Getter methods (encapsulation)
        public String getItemName() {
            return itemName;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        // Abstract method to calculate total price
        abstract double calculateTotalPrice();

        // Concrete method to display item details
        void getItemDetails() {
            System.out.println("Item Name : " + itemName);
            System.out.println("Price     : " + price);
            System.out.println("Quantity  : " + quantity);
        }
    }

    // VegItem class
    static class VegItem extends FoodItem implements Discountable {

        VegItem(String name, double price, int quantity) {
            super(name, price, quantity);
        }

        // Total price calculation for veg item
        @Override
        double calculateTotalPrice() {
            return getPrice() * getQuantity();
        }

        // Discount for veg items
        @Override
        public double applyDiscount() {
            return calculateTotalPrice() * 0.10; // 10% discount
        }

        @Override
        public String getDiscountDetails() {
            return "Veg Item Discount: 10%";
        }
    }

    // NonVegItem class
    static class NonVegItem extends FoodItem implements Discountable {

        private static final double NON_VEG_CHARGE = 50; // extra charge per item

        NonVegItem(String name, double price, int quantity) {
            super(name, price, quantity);
        }

        // Total price calculation with extra non-veg charges
        @Override
        double calculateTotalPrice() {
            return (getPrice() * getQuantity()) + (NON_VEG_CHARGE * getQuantity());
        }

        // Discount for non-veg items
        @Override
        public double applyDiscount() {
            return calculateTotalPrice() * 0.05; // 5% discount
        }

        @Override
        public String getDiscountDetails() {
            return "Non-Veg Item Discount: 5%";
        }
    }

    // Polymorphic order processing method
    static void processOrder(ArrayList<FoodItem> items) {

        for (FoodItem item : items) {

            item.getItemDetails();

            double discount = 0;

            // Applying discount using interface
            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                System.out.println(d.getDiscountDetails());
                discount = d.applyDiscount();
            }

            double totalPrice = item.calculateTotalPrice() - discount;

            System.out.println("Discount    : " + discount);
            System.out.println("Final Price : " + totalPrice);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Creating food items
        ArrayList<FoodItem> orderItems = new ArrayList<>();

        orderItems.add(new VegItem("Paneer Butter Masala", 250, 2));
        orderItems.add(new NonVegItem("Chicken Biryani", 300, 1));

        // Processing order polymorphically
        processOrder(orderItems);
    }
}
