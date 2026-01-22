package hashmapsandfunctions;

/*
 This program finds the length of the Longest Consecutive Sequence in an array.
 It uses hashing to check consecutive elements efficiently in linear time.
*/

import java.util.HashSet;

public class longestconsecutivesequencehashing {

    // Method to find longest consecutive sequence length
    static int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        // Add all elements to hash set
        for (int num : arr) {
            set.add(num);
        }

        int longest = 0;

        // Check for sequence starts
        for (int num : arr) {

            // Only start counting if num is the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] arr = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(arr);

        System.out.println("Length of Longest Consecutive Sequence: " + result);
    }
}
