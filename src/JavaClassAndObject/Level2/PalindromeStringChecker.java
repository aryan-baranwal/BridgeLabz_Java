public class PalindromeStringChecker {

    // Attribute to store the text
    String text;

    // Constructor to initialize the text
    PalindromeStringChecker(String text) {
        this.text = text;
    }

    // Method to check if the text is a palindrome
    boolean isPalindrome() {

        int start = 0;
        int end = text.length() - 1;

        // Compare characters from start and end
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    // Method to display the result
    void displayResult() {
        if (isPalindrome()) {
            System.out.println("The text \"" + text + "\" is a PALINDROME.");
        } else {
            System.out.println("The text \"" + text + "\" is NOT a palindrome.");
        }
    }

    public static void main(String[] args) {

        // Creating PalindromeChecker object
        PalindromeStringChecker checker = new PalindromeStringChecker("madam");

        // Displaying the result
        checker.displayResult();
    }
}
