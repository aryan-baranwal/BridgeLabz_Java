package javacollectionstreams.collections.mapinterface;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MergeMaps {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Takes two Map<String, Integer> from the user
         * 2. Merges them into one map
         * 3. If a key exists in both, sum their values
         */

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        // Input Map 1
        System.out.print("Enter number of entries for Map 1: ");
        int n1 = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n1; i++) {
            System.out.print("Key: ");
            String key = sc.nextLine();

            System.out.print("Value: ");
            int value = sc.nextInt();
            sc.nextLine();

            map1.put(key, value);
        }

        // Input Map 2
        System.out.print("\nEnter number of entries for Map 2: ");
        int n2 = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n2; i++) {
            System.out.print("Key: ");
            String key = sc.nextLine();

            System.out.print("Value: ");
            int value = sc.nextInt();
            sc.nextLine();

            map2.put(key, value);
        }

        System.out.println("\nMap 1: " + map1);
        System.out.println("Map 2: " + map2);

        // Merge maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        System.out.println("\nMerged Map: " + mergedMap);
    }

    // Method to merge two maps
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {

        /*
         * Logic:
         * 1. Create a new map
         * 2. Add all entries from map1
         * 3. For map2, if key exists in new map, sum the values
         *    Otherwise, add key-value pair
         */

        Map<String, Integer> merged = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            merged.put(entry.getKey(), merged.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        return merged;
    }
}

