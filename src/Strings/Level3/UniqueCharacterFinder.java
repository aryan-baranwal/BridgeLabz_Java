import java.util.Scanner;

public class UniqueCharacterFinder {

    // Method to find length of the string without using length()
    public static int findLength(String text) {
        int count = 0;

        // Count characters until charAt throws exception
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Reached end of string
        }

        return count;
    }

    // Method to find unique characters using charAt()
    public static char[] findUniqueCharacters(String text) {

        int length = findLength(text);

        // Temporary array to store unique characters
        char[] temp = new char[length];
        int uniqueCount = 0;

        // Outer loop to pick each character
        for (int i = 0; i < length; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            // Inner loop to check if character appeared before
            for (int j = 0; j < i; j++) {
                if (current == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            // If unique, store it
            if (isUnique) {
                temp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Create final array of exact size
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter the string: ");
        String text = sc.nextLine();

        // Find unique characters
        char[] uniqueChars = findUniqueCharacters(text);

        // Display result
        System.out.print("Unique characters: ");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }

        sc.close();
    }
}
