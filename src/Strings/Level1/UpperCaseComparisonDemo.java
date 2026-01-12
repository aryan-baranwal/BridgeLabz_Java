import java.util.Scanner;

public class UpperCaseComparisonDemo {

    // Method to convert text to uppercase using charAt() and ASCII logic
    public static String convertToUpperCaseManually(String text) {
        String result = "";

        // Traverse each character of the string
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Check if character is lowercase (a–z)
            if (ch >= 'a' && ch <= 'z') {
                // Convert to uppercase using ASCII difference (32)
                ch = (char) (ch - 32);
            }

            result += ch;
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {

        // If lengths differ, strings are not equal
        if (s1.length() != s2.length()) {
            return false;
        }

        // Compare each character
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true; // All characters matched
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take complete text input
        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        // Convert text to uppercase using user-defined method
        String manualUpper = convertToUpperCaseManually(text);

        // Convert text to uppercase using built-in method
        String builtInUpper = text.toUpperCase();

        // Compare both results using user-defined comparison method
        boolean result = compareStrings(manualUpper, builtInUpper);

        // Display results
        System.out.println("\nUppercase using charAt() logic: " + manualUpper);
        System.out.println("Uppercase using toUpperCase(): " + builtInUpper);
        System.out.println("Are both results equal? " + result);

        sc.close();
    }
}
