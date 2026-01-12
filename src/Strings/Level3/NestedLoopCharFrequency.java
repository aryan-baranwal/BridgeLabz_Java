import java.util.Scanner;

public class NestedLoopCharFrequency {

    // Method to find character frequency using nested loops
    // Returns a 1D String array containing "character : frequency"
    public static String[] findFrequency(String text) {

        // Convert string to character array
        char[] chars = text.toCharArray();
        int length = chars.length;

        // Frequency array
        int[] freq = new int[length];

        // Initialize frequency of each character to 1
        for (int i = 0; i < length; i++) {
            freq[i] = 1;
        }

        // Nested loops to count frequency
        for (int i = 0; i < length; i++) {

            // Skip already counted characters
            if (chars[i] == '0') {
                continue;
            }

            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate to avoid recounting
                }
            }
        }

        // Count number of unique characters
        int uniqueCount = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') {
                uniqueCount++;
            }
        }

        // Create result array
        String[] result = new String[uniqueCount];
        int index = 0;

        // Store character and frequency in result array
        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " : " + freq[i];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter the string: ");
        String text = sc.nextLine();

        // Find frequency using nested loops
        String[] frequencyResult = findFrequency(text);

        // Display result
        System.out.println("\nCharacter Frequency:");
        for (String s : frequencyResult) {
            System.out.println(s);
        }

        sc.close();
    }
}
