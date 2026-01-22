package hashmapsandfunctions;

/*
 This program solves the Two Sum Problem using a HashMap.
 It finds two indices whose values add up to a given target sum.
*/

import java.util.HashMap;

public class twosumhashmapsolution {

    // Method to find indices of two numbers that add up to target
    static int[] twoSum(int[] nums, int target) {

        // HashMap to store value -> index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            int required = target - nums[i];

            // Check if required value already exists
            if (map.containsKey(required)) {
                return new int[]{map.get(required), i};
            }

            // Store current value with its index
            map.put(nums[i], i);
        }

        // No solution found
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        if (result[0] != -1) {
            System.out.println("Indices found: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No valid pair found");
        }
    }
}
