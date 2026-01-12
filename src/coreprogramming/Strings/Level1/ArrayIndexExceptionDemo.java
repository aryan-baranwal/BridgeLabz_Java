import java.util.Scanner;

public class ArrayIndexExceptionDemo {

    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names) {

        // Accessing index greater than array length
        // This will throw ArrayIndexOutOfBoundsException
        System.out.println(names[names.length]);
    }

    // Method to handle ArrayIndexOutOfBoundsException using try-catch
    public static void handleException(String[] names) {

        try {
            // Accessing invalid index
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handling specific exception
            System.out.println("ArrayIndexOutOfBoundsException caught and handled.");
        } catch (RuntimeException e) {
            // Handling any other runtime exception
            System.out.println("Generic RuntimeException caught and handled.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take number of names from user
        System.out.print("Enter number of names: ");
        int n = sc.nextInt();

        String[] names = new String[n];

        // Take names input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.next();
        }

        // First call: generate the exception
        try {
            generateException(names);
        } catch (RuntimeException e) {
            System.out.println("Exception generated in generateException() method.");
        }

        // Second call: handle the exception safely
        handleException(names);

        sc.close();
    }
}
