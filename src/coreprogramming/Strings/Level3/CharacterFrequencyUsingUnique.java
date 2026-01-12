import java.util.Scanner;

public class CharacterFrequencyUsingUnique {

    // Method to find unique characters using charAt() and nested loops
    public static char[] findUniqueCharacters(String text) {

        int length = text.length();

        // Temporary array to store unique characters
        char[] temp = new char[length];
        int uniqueCount = 0;

        // Outer loop to pick each character
        for (int i = 0; i < length; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            // Inner loop to check if character already appeared
            for (int j = 0; j < i; j++) {
                if (current == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            // Store character if it is unique
            if (isUnique) {
                temp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Create array of exact size
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = temp[i];
        }

        return uniqueChars;
    }

    // Method to find frequency using unique characters
    // Returns 2D String array of character and frequency
    public static String[][] findFrequencyUsingUnique(String text) {

        // Frequency array for ASCII characters
        int[] freq = new int[256];

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        // Get unique characters
        char[] uniqueChars = findUniqueCharacters(text);

        // Create 2D array to store character and frequency
        String[][] result = new String[uniqueChars.length][2];

        // Store character and its frequency
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }

        return result;
    }

    // Method to find frequency using nested loops only
    public static void findFrequencyUsingNestedLoops(String text) {

        int length = text.length();

        System.out.println("\nCharacter\tFrequency");
        System.out.println("------------------------");

        for (int i = 0; i < length; i++) {
            char current = text.charAt(i);
            int count = 1;
            boolean alreadyCounted = false;

            // Check if character appeared before
            for (int j = 0; j < i; j++) {
                if (current == text.charAt(j)) {
                    alreadyCounted = true;
                    break;
                }
            }

            if (alreadyCounted) {
                continue;
            }

            // Count frequency
            for (int j = i + 1; j < length; j++) {
                if (current == text.charAt(j)) {
                    count++;
                }
            }

            System.out.println(current + "\t\t" + count);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter the string: ");
        String text = sc.nextLine();

        // Frequency using unique characters + ASCII array
        String[][] frequencyResult = findFrequencyUsingUnique(text);

        System.out.println("\nFrequency using unique characters:");
        System.out.println("Character\tFrequency");
        System.out.println("------------------------");

        for (int i = 0; i < frequencyResult.length; i++) {
            System.out.println(
                    frequencyResult[i][0] + "\t\t" + frequencyResult[i][1]
            );
        }

        // Frequency using nested loops
        System.out.println("\nFrequency using nested loops:");
        findFrequencyUsingNestedLoops(text);

        sc.close();
    }
}
