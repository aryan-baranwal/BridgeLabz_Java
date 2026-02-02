package javacollectionstreams.collections.mapinterface;
import java.util.*;

public class InvertMap {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Takes a Map<K, V> from the user
         * 2. Inverts it to Map<V, List<K>>
         * 3. Handles duplicate values by storing keys in a list
         */

        Scanner sc = new Scanner(System.in);

        Map<String, String> originalMap = new HashMap<>();

        System.out.print("Enter number of entries in the map: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEntry " + (i + 1) + ":");

            System.out.print("Key: ");
            String key = sc.nextLine();

            System.out.print("Value: ");
            String value = sc.nextLine();

            originalMap.put(key, value);
        }

        System.out.println("\nOriginal Map: " + originalMap);

        // Invert the map
        Map<String, List<String>> invertedMap = invertMap(originalMap);

        System.out.println("\nInverted Map: " + invertedMap);
    }

    // Method to invert map
    public static Map<String, List<String>> invertMap(Map<String, String> map) {

        /*
         * Logic:
         * For each entry (K, V):
         *   If V is not already a key in inverted map:
         *       Create a new list and add K
         *   Else:
         *       Add K to existing list
         */

        Map<String, List<String>> inverted = new HashMap<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (!inverted.containsKey(value)) {
                List<String> list = new ArrayList<>();
                list.add(key);
                inverted.put(value, list);
            } else {
                inverted.get(value).add(key);
            }
        }

        return inverted;
    }
}
