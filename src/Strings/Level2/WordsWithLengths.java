import java.util.Scanner;

public class WordsWithLengths {

    // Method to find string length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    // Method to split text into words without using split()
    public static String[] customSplit(String text) {
        int len = findLength(text);

        // Count words
        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (text.charAt(i) == ' ') {
                inWord = false;
            }
        }

        // Extract words
        String[] words = new String[wordCount];
        int index = 0;
        int start = 0;

        for (int i = 0; i <= len; i++) {
            if (i == len || text.charAt(i) == ' ') {
                if (start < i) {
                    words[index++] = text.substring(start, i);
                }
                start = i + 1;
            }
        }
        return words;
    }

    // Method to create 2D array of word and its length (as String)
    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            int length = findLength(words[i]);
            result[i][0] = words[i];
            result[i][1] = String.valueOf(length);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String text = input.nextLine();

        String[] words = customSplit(text);
        String[][] table = wordsWithLengths(words);

        // Display in tabular format
        System.out.println("Word\tLength");
        for (int i = 0; i < table.length; i++) {
            int length = Integer.parseInt(table[i][1]);
            System.out.println(table[i][0] + "\t" + length);
        }

        input.close();
    }
}
