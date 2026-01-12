public class NullPointerDemo {

    // Method that generates NullPointerException
    public static void generateException() {

        // String variable initialized to null
        String text = null;

        // This line will generate NullPointerException
        System.out.println(text.length());
    }

    // Method that handles NullPointerException using try-catch
    public static void handleException() {

        // String variable initialized to null
        String text = null;

        try {
            // This line may throw NullPointerException
            System.out.println(text.length());
        } catch (NullPointerException e) {
            // Handling the exception
            System.out.println("NullPointerException caught and handled.");
        }
    }

    public static void main(String[] args) {

        // Calling method that generates exception
        // Uncomment this to see the exception
        // generateException();

        // Calling method that handles the exception
        handleException();
    }
}
