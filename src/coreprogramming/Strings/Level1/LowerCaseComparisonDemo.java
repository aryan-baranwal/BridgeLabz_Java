import java.util.Scanner;

public class LowerCaseComparisonDemo {

    // Method to convert text to lowercase using charAt() and ASCII logic
    public static String convertToLowerCaseManually(String text) {
        String result = "";

        // Traverse each character of the string
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Check if character is uppercase (A–Z)
            if (ch >= 'A' && ch <= 'Z') {
                // Convert to lowercase using ASCII difference (32)
                ch = (char) (ch + 32);
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

        // Compare characters one by one
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

        // Convert text to lowercase using user-defined method
        String manualLower = convertToLowerCaseManually(text);

        // Convert text to lowercase using built-in method
        String builtInLower = text.toLowerCase();

        // Compare both results using user-defined comparison method
        boolean result = compareStrings(manualLower, builtInLower);

        // Display results
        System.out.println("\nLowercase using charAt() logic: " + manualLower);
        System.out.println("Lowercase using toLowerCase(): " + builtInLower);
        System.out.println("Are both results equal? " + result);

        sc.close();
    }
}
