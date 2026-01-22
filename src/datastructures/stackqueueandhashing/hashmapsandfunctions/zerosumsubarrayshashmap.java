package hashmapsandfunctions;

/*
 This program finds all subarrays whose sum is zero.
 It uses a HashMap to store cumulative sums and their indices.
*/

import java.util.HashMap;
import java.util.ArrayList;

public class zerosumsubarrayshashmap {

    // Method to find and display all zero-sum subarrays
    static void findZeroSumSubarrays(int[] arr) {

        // Map to store cumulative sum and list of indices
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            // Add current element to cumulative sum
            sum += arr[i];

            // If sum is zero, subarray from 0 to i has zero sum
            if (sum == 0) {
                System.out.println("Zero-sum subarray found: [0 to " + i + "]");
            }

            // If cumulative sum already exists, zero-sum subarrays exist
            if (map.containsKey(sum)) {
                for (int startIndex : map.get(sum)) {
                    System.out.println("Zero-sum subarray found: [" + (startIndex + 1) + " to " + i + "]");
                }
            }

            // Store current index for this cumulative sum
            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, -3, 1, 6, -6, 2, -2};

        System.out.println("Zero-sum subarrays:");
        findZeroSumSubarrays(arr);
    }
}

