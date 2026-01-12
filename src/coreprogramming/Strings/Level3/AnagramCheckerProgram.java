import java.util.Scanner;

public class AnagramCheckerProgram {

    // Method to check if two texts are anagrams
    public static boolean areAnagrams(String text1, String text2) {

        // Step 1: If lengths are different, they cannot be anagrams
        if (text1.length() != text2.length()) {
            return false;
        }

        // Step 2: Frequency arrays for ASCII characters (0–255)
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        // Step 3: Count frequency of characters in first text
        for (int i = 0; i < text1.length(); i++) {
            freq1[text1.charAt(i)]++;
        }

        // Step 4: Count frequency of characters in second text
        for (int i = 0; i < text2.length(); i++) {
            freq2[text2.charAt(i)]++;
        }

        // Step 5: Compare frequency arrays
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        // All character frequencies match
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter first text: ");
        String text1 = sc.nextLine();

        System.out.print("Enter second text: ");
        String text2 = sc.nextLine();

        // Check if texts are anagrams
        boolean result = areAnagrams(text1, text2);

        // Display result
        if (result) {
            System.out.println("The given texts are ANAGRAMS.");
        } else {
            System.out.println("The given texts are NOT anagrams.");
        }

        sc.close();
    }
}
