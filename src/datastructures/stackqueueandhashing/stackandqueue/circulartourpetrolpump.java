package stackandqueue;

/*
 This program solves the Circular Tour (Petrol Pump) Problem.
 It finds the starting petrol pump index to complete a circular tour using a queue-like approach.
*/

public class circulartourpetrolpump {

    // Method to find starting petrol pump index
    static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;

        int start = 0;      // starting index
        int surplus = 0;   // current petrol surplus
        int deficit = 0;   // total deficit petrol

        // Traverse all petrol pumps once
        for (int i = 0; i < n; i++) {
            surplus += petrol[i] - distance[i];

            // If surplus becomes negative, cannot start from current start
            if (surplus < 0) {
                deficit += surplus;
                start = i + 1;
                surplus = 0;
            }
        }

        // Check if total petrol is sufficient
        if (surplus + deficit >= 0) {
            return start;
        } else {
            return -1; // No possible tour
        }
    }

    public static void main(String[] args) {

        // Petrol available at each pump
        int[] petrol = {6, 3, 7};

        // Distance to next pump
        int[] distance = {4, 6, 3};

        int startIndex = findStartingPoint(petrol, distance);

        if (startIndex != -1) {
            System.out.println("Start the tour at petrol pump index: " + startIndex);
        } else {
            System.out.println("No possible circular tour");
        }
    }
}
