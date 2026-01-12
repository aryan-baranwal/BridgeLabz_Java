import java.util.Scanner;

public class CharacterFrequencyCounter {

    // Method to find frequency of characters using charAt()
    // Returns a 2D array containing character and its frequency
    public static String[][] findCharacterFrequency(String text) {

        // Frequency array for 256 ASCII characters
        int[] freq = new int[256];

        // First loop: count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Count number of unique characters
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] > 0) {
                uniqueCount++;
                freq[text.charAt(i)] = -freq[text.charAt(i)]; // mark as counted
            }
        }

        // Reset frequency array for reuse
        for (int i = 0; i < 256; i++) {
            if (freq[i] < 0) {
                freq[i] = -freq[i];
            }
        }

        // Create 2D array to store character and frequency
        String[][] result = new String[uniqueCount][2];

        int index = 0;

        // Store characters and their frequencies
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] > 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                freq[ch] = 0; // mark as stored
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

        // Find character frequencies
        String[][] frequencyResult = findCharacterFrequency(text);

        // Display result
        System.out.println("\nCharacter\tFrequency");
        System.out.println("------------------------");

        for (int i = 0; i < frequencyResult.length; i++) {
            System.out.println(
                    frequencyResult[i][0] + "\t\t" + frequencyResult[i][1]
            );
        }

        sc.close();
    }
}
