import java.util.Scanner;

public class SplitTextWithoutSplit {

    // Method to find length without using length()
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
        int length = findLength(text);

        // Count words
        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (text.charAt(i) == ' ') {
                inWord = false;
            }
        }

        // Store words
        String[] words = new String[wordCount];
        int index = 0;
        int start = 0;

        for (int i = 0; i <= length; i++) {
            if (i == length || text.charAt(i) == ' ') {
                if (start < i) {
                    words[index++] = text.substring(start, i);
                }
                start = i + 1;
            }
        }

        return words;
    }

    // Method to compare two string arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String text = input.nextLine();

        // Custom split
        String[] customWords = customSplit(text);

        // Built-in split
        String[] builtInWords = text.split(" ");

        // Compare results
        boolean isSame = compareArrays(customWords, builtInWords);

        System.out.println("Words using custom split:");
        for (String word : customWords) {
            System.out.println(word);
        }

        System.out.println("Words using built-in split:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        System.out.println("Are both split results same? " + isSame);

        input.close();
    }
}
