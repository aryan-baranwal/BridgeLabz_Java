import java.util.Scanner;

public class PalindromeCheckerAllWays {

    // LOGIC 1: Iterative method using start and end indexes
    public static boolean isPalindromeIterative(String text) {

        int start = 0;
        int end = text.length() - 1;

        // Compare characters from start and end
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // LOGIC 2: Recursive method
    public static boolean isPalindromeRecursive(String text, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        // If characters do not match
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Helper method to reverse a string using charAt()
    public static char[] reverseString(String text) {

        int length = text.length();
        char[] reverse = new char[length];

        int index = 0;
        for (int i = length - 1; i >= 0; i--) {
            reverse[index] = text.charAt(i);
            index++;
        }

        return reverse;
    }

    // LOGIC 3: Using character arrays
    public static boolean isPalindromeUsingArrays(String text) {

        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        // Compare original and reverse arrays
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        // Logic 1 result
        boolean result1 = isPalindromeIterative(text);

        // Logic 2 result
        boolean result2 = isPalindromeRecursive(text, 0, text.length() - 1);

        // Logic 3 result
        boolean result3 = isPalindromeUsingArrays(text);

        // Display results
        System.out.println("\nPalindrome Check Results:");
        System.out.println("Logic 1 (Iterative): " + result1);
        System.out.println("Logic 2 (Recursive): " + result2);
        System.out.println("Logic 3 (Using Arrays): " + result3);

        sc.close();
    }
}
