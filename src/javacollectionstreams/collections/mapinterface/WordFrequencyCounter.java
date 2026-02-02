package javacollectionstreams.collections.mapinterface;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Reads a text file
         * 2. Counts frequency of each word
         * 3. Ignores case and punctuation
         */

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String filePath = sc.nextLine();

        // HashMap to store word frequency
        Map<String, Integer> wordFreq = new HashMap<>();

        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                // Remove punctuation and convert to lower case
                line = line.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();

                // Split words
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.isEmpty()) continue;

                    // Update frequency in HashMap
                    wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
                }
            }

            fileScanner.close();

            // Display word frequencies
            System.out.println("\nWord Frequencies:");
            for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
}
