/*
 This program demonstrates multilevel inheritance.
 Order → ShippedOrder → DeliveredOrder shows order status progression.
*/

public class OnlineRetailOrderManagement {

    // Base class Order
    static class Order {
        int orderId;
        String orderDate;

        // Constructor to initialize order details
        Order(int orderId, String orderDate) {
            this.orderId = orderId;
            this.orderDate = orderDate;
        }

        // Method to get order status
        String getOrderStatus() {
            return "Order Placed";
        }
    }

    // Subclass ShippedOrder (extends Order)
    static class ShippedOrder extends Order {
        String trackingNumber;

        // Constructor
        ShippedOrder(int orderId, String orderDate, String trackingNumber) {
            super(orderId, orderDate);
            this.trackingNumber = trackingNumber;
        }

        // Overriding getOrderStatus()
        @Override
        String getOrderStatus() {
            return "Order Shipped";
        }
    }

    // Subclass DeliveredOrder (extends ShippedOrder)
    static class DeliveredOrder extends ShippedOrder {
        String deliveryDate;

        // Constructor
        DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
            super(orderId, orderDate, trackingNumber);
            this.deliveryDate = deliveryDate;
        }

        // Overriding getOrderStatus()
        @Override
        String getOrderStatus() {
            return "Order Delivered";
        }
    }

    public static void main(String[] args) {

        // Creating DeliveredOrder object (multilevel inheritance)
        Order order = new DeliveredOrder(
                101,
                "2024-09-15",
                "TRK12345",
                "2024-09-18"
        );

        // Polymorphic call to getOrderStatus()
        System.out.println("Order Status: " + order.getOrderStatus());
    }
}
