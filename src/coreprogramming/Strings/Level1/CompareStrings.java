import java.util.Scanner;

public class CompareStrings {

    // Method to compare two strings using charAt()
    public static boolean compareUsingCharAt(String s1, String s2) {

        // If lengths are different, strings cannot be equal
        if (s1.length() != s2.length()) {
            return false;
        }

        // Compare each character of both strings
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false; // Characters do not match
            }
        }

        return true; // All characters matched
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input for two strings
        System.out.print("Enter first string: ");
        String str1 = sc.next();

        System.out.print("Enter second string: ");
        String str2 = sc.next();

        // Compare strings using charAt() method
        boolean charAtResult = compareUsingCharAt(str1, str2);

        // Compare strings using built-in equals() method
        boolean equalsResult = str1.equals(str2);

        // Display results
        System.out.println("\nComparison using charAt(): " + charAtResult);
        System.out.println("Comparison using equals(): " + equalsResult);

        // Check if both results are same
        if (charAtResult == equalsResult) {
            System.out.println("Result: Both methods give the SAME result.");
        } else {
            System.out.println("Result: Both methods give DIFFERENT results.");
        }

        sc.close();
    }
}
