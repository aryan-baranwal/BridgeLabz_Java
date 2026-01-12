public class CircleAreaCircumference {

    // Circle class
    static class Circle {

        // Attribute of Circle
        double radius;

        // Constructor to initialize radius
        Circle(double radius) {
            this.radius = radius;
        }

        // Method to calculate area of the circle
        double calculateArea() {
            return Math.PI * radius * radius;
        }

        // Method to calculate circumference of the circle
        double calculateCircumference() {
            return 2 * Math.PI * radius;
        }

        // Method to display area and circumference
        void displayDetails() {
            System.out.println("Radius          : " + radius);
            System.out.println("Area            : " + calculateArea());
            System.out.println("Circumference   : " + calculateCircumference());
        }
    }

    public static void main(String[] args) {

        // Creating a Circle object
        Circle circle = new Circle(7);

        // Displaying area and circumference
        circle.displayDetails();
    }
}
