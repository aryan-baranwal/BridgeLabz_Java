import java.util.Scanner;

public class FirstNonRepeatingCharFinder {

    // Method to find the first non-repeating character using charAt()
    public static char findFirstNonRepeatingChar(String text) {

        // Array to store frequency of ASCII characters (0–255)
        int[] freq = new int[256];

        // First loop: count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Second loop: find the first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch; // First non-repeating character found
            }
        }

        // If no non-repeating character exists
        return '\0';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter the string: ");
        String text = sc.nextLine();

        // Find first non-repeating character
        char result = findFirstNonRepeatingChar(text);

        // Display result
        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        sc.close();
    }
}
