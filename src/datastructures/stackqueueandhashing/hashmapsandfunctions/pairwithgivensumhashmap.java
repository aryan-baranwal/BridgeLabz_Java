package hashmapsandfunctions;

/*
 This program checks whether a pair with a given sum exists in an array.
 It uses a HashMap to store visited elements for efficient lookup.
*/

import java.util.HashMap;

public class pairwithgivensumhashmap {

    // Method to check if a pair with given sum exists
    static boolean hasPairWithSum(int[] arr, int targetSum) {

        // HashMap to store visited numbers
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int num : arr) {

            int required = targetSum - num;

            // Check if required number already exists
            if (map.containsKey(required)) {
                System.out.println("Pair found: " + num + " + " + required + " = " + targetSum);
                return true;
            }

            // Store current number
            map.put(num, true);
        }

        // No pair found
        return false;
    }

    public static void main(String[] args) {

        int[] arr = {8, 7, 2, 5, 3, 1};
        int targetSum = 10;

        boolean result = hasPairWithSum(arr, targetSum);

        if (!result) {
            System.out.println("No pair found with sum " + targetSum);
        }
    }
}
