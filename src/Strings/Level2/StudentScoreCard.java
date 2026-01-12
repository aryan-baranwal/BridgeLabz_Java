public class StudentScoreCard {

    // a. Generate random 2-digit PCM scores for students
    public static int[][] generateScores(int numberOfStudents) {
        int[][] scores = new int[numberOfStudents][3]; // P, C, M

        for (int i = 0; i < numberOfStudents; i++) {
            scores[i][0] = 10 + (int) (Math.random() * 90); // Physics
            scores[i][1] = 10 + (int) (Math.random() * 90); // Chemistry
            scores[i][2] = 10 + (int) (Math.random() * 90); // Maths
        }
        return scores;
    }

    // b. Calculate total, average, percentage (rounded to 2 digits)
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3]; // Total, Avg, %

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Round to 2 digits
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
        }
        return results;
    }

    // c. Calculate grade based on percentage
    public static String[] calculateGrades(double[][] results) {
        String[] grades = new String[results.length];

        for (int i = 0; i < results.length; i++) {
            double percentage = results[i][2];

            if (percentage >= 80) {
                grades[i] = "A";
            } else if (percentage >= 70) {
                grades[i] = "B";
            } else if (percentage >= 60) {
                grades[i] = "C";
            } else if (percentage >= 50) {
                grades[i] = "D";
            } else if (percentage >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }
        return grades;
    }

    // d. Display scorecard in tabular format
    public static void displayScoreCard(int[][] scores, double[][] results, String[] grades) {

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("-------------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                            scores[i][0] + "\t" +
                            scores[i][1] + "\t\t" +
                            scores[i][2] + "\t" +
                            (int) results[i][0] + "\t" +
                            results[i][1] + "\t" +
                            results[i][2] + "\t\t" +
                            grades[i]
            );
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {

        int numberOfStudents = 5; // you can change this

        int[][] scores = generateScores(numberOfStudents);
        double[][] results = calculateResults(scores);
        String[] grades = calculateGrades(results);

        displayScoreCard(scores, results, grades);
    }
}
