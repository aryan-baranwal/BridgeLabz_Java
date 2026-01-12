import java.util.Scanner;

public class StringIndexBoundsDemo {

    // Method to generate StringIndexOutOfBoundsException
    public static void generateException(String text) {

        // Accessing index beyond string length
        // This will throw StringIndexOutOfBoundsException
        System.out.println(text.charAt(text.length()));
    }

    // Method to handle StringIndexOutOfBoundsException using try-catch
    public static void handleException(String text) {

        try {
            // Accessing invalid index
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            // Handling the exception
            System.out.println("StringIndexOutOfBoundsException caught and handled.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take string input from user
        System.out.print("Enter a string: ");
        String text = sc.next();

        // Calling method that generates exception
        // Uncomment the line below to see abrupt program termination
        // generateException(text);

        // Calling method that handles the exception safely
        handleException(text);

        sc.close();
    }
}
