import java.util.Scanner;

public class VotingEligibilityTable {

    // Method to generate random 2-digit ages for n students
    public static int[] generateAges(int n) {
        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            // Random 2-digit age (10 to 99)
            ages[i] = 10 + (int) (Math.random() * 90);
        }
        return ages;
    }

    // Method to check voting eligibility and return 2D String array
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }

    // Method to display 2D array in tabular format
    public static void displayTable(String[][] table) {
        System.out.println("Age\tCan Vote");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberOfStudents = 10;

        // Generate random ages
        int[] ages = generateAges(numberOfStudents);

        // Check voting eligibility
        String[][] votingStatus = checkVotingEligibility(ages);

        // Display result
        displayTable(votingStatus);

        input.close();
    }
}
