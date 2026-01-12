import java.util.Scanner;

public class SubstringComparison {

    // Method to create substring using charAt()
    public static String createSubstringUsingCharAt(String text, int start, int end) {
        String result = "";

        // Build substring character by character
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStringsUsingCharAt(String s1, String s2) {

        // If lengths are different, strings are not equal
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

        // Take string input
        System.out.print("Enter the string: ");
        String text = sc.next();

        // Take start and end index
        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        // Substring using charAt()
        String substringCharAt = createSubstringUsingCharAt(text, start, end);

        // Substring using built-in substring() method
        String substringBuiltIn = text.substring(start, end);

        // Compare both substrings using charAt()
        boolean comparisonResult = compareStringsUsingCharAt(substringCharAt, substringBuiltIn);

        // Display results
        System.out.println("\nSubstring using charAt(): " + substringCharAt);
        System.out.println("Substring using substring(): " + substringBuiltIn);
        System.out.println("Are both substrings equal? " + comparisonResult);

        sc.close();
    }
}
