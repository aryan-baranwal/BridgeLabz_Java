import java.util.Scanner;

public class TrimStringWithoutTrim {

    // Method to find start and end index after trimming spaces
    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = 0;

        // Find string length without using length()
        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (Exception e) {
            // end of string
        }

        // Trim leading spaces
        while (start < length && text.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        end = length - 1;
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // Method to create substring using charAt()
    public static String createSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {

        // Find length of both strings
        int len1 = 0, len2 = 0;

        try {
            while (true) {
                s1.charAt(len1);
                len1++;
            }
        } catch (Exception e) {}

        try {
            while (true) {
                s2.charAt(len2);
                len2++;
            }
        } catch (Exception e) {}

        if (len1 != len2) {
            return false;
        }

        for (int i = 0; i < len1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String text = input.nextLine();

        // Custom trim
        int[] indexes = findTrimIndexes(text);
        String customTrimmed = createSubstring(text, indexes[0], indexes[1]);

        // Built-in trim
        String builtInTrimmed = text.trim();

        // Compare results
        boolean isSame = compareStrings(customTrimmed, builtInTrimmed);

        System.out.println("Custom Trimmed String: [" + customTrimmed + "]");
        System.out.println("Built-in Trimmed String: [" + builtInTrimmed + "]");
        System.out.println("Are both strings equal? " + isSame);

        input.close();
    }
}
