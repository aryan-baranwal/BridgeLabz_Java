import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    // Method to generate IllegalArgumentException
    public static void generateException(String text) {

        // Start index is greater than end index
        // This will generate a runtime exception and stop the program
        System.out.println(text.substring(5, 2));
    }

    // Method to handle IllegalArgumentException using try-catch
    public static void handleException(String text) {

        try {
            // Invalid substring range
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            // Handling IllegalArgumentException
            System.out.println("IllegalArgumentException caught and handled.");
        } catch (RuntimeException e) {
            // Handling any other runtime exception
            System.out.println("Generic RuntimeException caught and handled.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take string input from user
        System.out.print("Enter a string: ");
        String text = sc.next();

        // First call: generate the exception
        try {
            generateException(text);
        } catch (RuntimeException e) {
            System.out.println("Exception generated in generateException() method.");
        }

        // Second call: handle the exception safely
        handleException(text);

        sc.close();
    }
}
