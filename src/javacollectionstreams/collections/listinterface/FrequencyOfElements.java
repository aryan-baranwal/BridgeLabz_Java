package javacollectionstreams.collections.listinterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyOfElements {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Takes a list of strings from the user
         * 2. Counts the frequency of each element
         * 3. Stores the result in a Map<String, Integer>
         */

        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        // Taking number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        // Taking string inputs
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            String value = sc.nextLine();
            list.add(value);
        }

        // Display original list
        System.out.println("\nInput List: " + list);

        // Find frequency
        Map<String, Integer> frequencyMap = findFrequency(list);

        // Display result
        System.out.println("Frequency Map: " + frequencyMap);
    }

    // Method to find frequency of elements
    public static Map<String, Integer> findFrequency(ArrayList<String> list) {

        /*
         * This method iterates through the list
         * and counts occurrences of each element
         * using a HashMap.
         */

        Map<String, Integer> map = new HashMap<>();

        for (String item : list) {

            // If element already exists, increase count
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            }
            // If element appears first time, set count = 1
            else {
                map.put(item, 1);
            }
        }

        return map;
    }
}
