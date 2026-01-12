import java.util.Scanner;

public class BMICalculationTeam {

    // Method to calculate BMI and status for all persons
    // Takes 2D array of weight (kg) and height (cm)
    // Returns 2D String array containing height, weight, BMI, and status
    public static String[][] calculateBMIAndStatus(double[][] data) {

        String[][] result = new String[10][4];

        for (int i = 0; i < 10; i++) {

            double weight = data[i][0];   // weight in kg
            double heightCm = data[i][1]; // height in cm

            // Convert height from cm to meters
            double heightM = heightCm / 100.0;

            // BMI formula
            double bmi = weight / (heightM * heightM);

            // Determine BMI status
            String status;
            if (bmi < 18.5) {
                status = "Underweight";
            } else if (bmi < 25) {
                status = "Normal";
            } else if (bmi < 30) {
                status = "Overweight";
            } else {
                status = "Obese";
            }

            // Store results
            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }

        return result;
    }

    // Method to display BMI details in tabular format
    public static void displayResult(String[][] result) {

        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            System.out.println(
                    result[i][0] + "\t\t" +
                            result[i][1] + "\t\t" +
                            result[i][2] + "\t\t" +
                            result[i][3]
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 2D array to store weight and height
        double[][] data = new double[10][2];

        // Taking input for 10 persons
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));

            System.out.print("Enter weight (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        // Calculate BMI and status
        String[][] bmiResult = calculateBMIAndStatus(data);

        // Display final result
        displayResult(bmiResult);

        sc.close();
    }
}
