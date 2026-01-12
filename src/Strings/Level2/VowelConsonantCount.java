import java.util.Scanner;

public class VowelConsonantCount {

    // Method to check character type: Vowel, Consonant, or Not a Letter
    public static String checkCharacter(char ch) {

        // Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if alphabet
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Method to find count of vowels and consonants
    public static int[] findVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; ; i++) {
            try {
                char ch = text.charAt(i);
                String result = checkCharacter(ch);

                if (result.equals("Vowel")) {
                    vowels++;
                } else if (result.equals("Consonant")) {
                    consonants++;
                }
            } catch (Exception e) {
                break; // end of string reached
            }
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String text = input.nextLine();

        int[] result = findVowelsAndConsonants(text);

        System.out.println("Number of Vowels: " + result[0]);
        System.out.println("Number of Consonants: " + result[1]);

        input.close();
    }
}
