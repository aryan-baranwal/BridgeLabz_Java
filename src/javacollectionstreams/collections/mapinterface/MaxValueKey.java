package javacollectionstreams.collections.mapinterface;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxValueKey {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Takes a Map<String, Integer> from the user
         * 2. Finds the key with the maximum value
         */

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();

        System.out.print("Enter number of entries in the map: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEntry " + (i + 1) + ":");

            System.out.print("Key: ");
            String key = sc.nextLine();

            System.out.print("Value: ");
            int value = sc.nextInt();
            sc.nextLine(); // consume newline

            map.put(key, value);
        }

        System.out.println("\nOriginal Map: " + map);

        // Find key with max value
        String maxKey = findMaxKey(map);

        System.out.println("\nKey with maximum value: " + maxKey);
    }

    // Method to find key with max value
    public static String findMaxKey(Map<String, Integer> map) {

        /*
         * Logic:
         * Iterate through all entries
         * Keep track of maximum value and corresponding key
         */

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }
}

