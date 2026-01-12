import java.util.Scanner;

public class ShortestAndLongestWord {

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

    // Method to create 2D array of word and its length
    public static String[][] wordsWithLengths(String[] words) {
        String[][] table = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            int length = findLength(words[i]);
            table[i][0] = words[i];
            table[i][1] = String.valueOf(length);
        }
        return table;
    }

    // Method to find shortest and longest word indexes
    public static int[] findShortestAndLongest(String[][] table) {
        int shortestIndex = 0;
        int longestIndex = 0;

        int shortestLength = Integer.parseInt(table[0][1]);
        int longestLength = Integer.parseInt(table[0][1]);

        for (int i = 1; i < table.length; i++) {
            int length = Integer.parseInt(table[i][1]);

            if (length < shortestLength) {
                shortestLength = length;
                shortestIndex = i;
            }

            if (length > longestLength) {
                longestLength = length;
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String text = input.nextLine();

        String[] words = customSplit(text);
        String[][] table = wordsWithLengths(words);
        int[] result = findShortestAndLongest(table);

        System.out.println("Shortest word: " + table[result[0]][0]);
        System.out.println("Longest word: " + table[result[1]][0]);

        input.close();
    }
}
