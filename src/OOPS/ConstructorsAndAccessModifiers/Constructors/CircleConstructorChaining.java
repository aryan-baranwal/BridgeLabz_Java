public class CircleConstructorChaining {

    // Circle class
    static class Circle {

        // Attribute of Circle
        double radius;

        // Default constructor
        Circle() {
            // Calling parameterized constructor with default value
            this(1.0);
        }

        // Parameterized constructor
        Circle(double radius) {
            this.radius = radius;
        }

        // Method to display radius
        void displayRadius() {
            System.out.println("Radius: " + radius);
        }
    }

    public static void main(String[] args) {

        // Object created using default constructor
        Circle circle1 = new Circle();
        System.out.println("Using default constructor:");
        circle1.displayRadius();

        System.out.println();

        // Object created using parameterized constructor
        Circle circle2 = new Circle(5.5);
        System.out.println("Using parameterized constructor:");
        circle2.displayRadius();
    }
}
