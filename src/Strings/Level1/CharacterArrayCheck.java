import java.util.Scanner;

public class CharacterArrayCheck {

    // Method to return characters of a string without using toCharArray()
    public static char[] getCharactersManually(String text) {

        // Create a character array of same length as string
        char[] chars = new char[text.length()];

        // Store each character using charAt()
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }

        return chars;
    }

    // Method to compare two character arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {

        // If lengths are different, arrays are not equal
        if (arr1.length != arr2.length) {
            return false;
        }

        // Compare each character
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true; // All characters matched
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take string input
        System.out.print("Enter the string: ");
        String text = sc.next();

        // Get character array using user-defined method
        char[] manualArray = getCharactersManually(text);

        // Get character array using built-in method
        char[] builtInArray = text.toCharArray();

        // Compare both arrays
        boolean result = compareCharArrays(manualArray, builtInArray);

        // Display result
        System.out.println("\nCharacters using user-defined method:");
        for (char c : manualArray) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nCharacters using toCharArray():");
        for (char c : builtInArray) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nAre both character arrays equal? " + result);

        sc.close();
    }
}
