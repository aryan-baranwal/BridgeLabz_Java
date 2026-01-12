import java.util.Scanner;

public class StringLengthWithoutMethod {

    // Method to find string length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String text = input.next(); // take input using next()

        int customLength = findLength(text);
        int builtInLength = text.length();

        System.out.println("Length using custom method: " + customLength);
        System.out.println("Length using built-in method: " + builtInLength);

        input.close();
    }
}
