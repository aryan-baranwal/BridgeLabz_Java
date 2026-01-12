import java.util.Scanner;

public class NumberFormatExceptionDemo {

    // Method to generate NumberFormatException
    public static void generateException(String text) {

        // Trying to convert non-numeric text to integer
        // This will generate NumberFormatException and stop the program
        int number = Integer.parseInt(text);
        System.out.println("Number: " + number);
    }

    // Method to handle NumberFormatException using try-catch
    public static void handleException(String text) {

        try {
            // Attempt to convert text to integer
            int number = Integer.parseInt(text);
            System.out.println("Converted Number: " + number);
        } catch (NumberFormatException e) {
            // Handling NumberFormatException
            System.out.println("NumberFormatException caught and handled.");
        } catch (RuntimeException e) {
            // Handling any other runtime exception
            System.out.println("Generic RuntimeException caught and handled.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input as String
        System.out.print("Enter a value: ");
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
