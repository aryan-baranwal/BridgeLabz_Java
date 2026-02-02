package javacollectionstreams.collections.votingsystem;
import java.util.*;

public class VotingSystem {

    public static void main(String[] args) {
        /*
         * This program simulates a voting system:
         * - HashMap stores votes (Candidate -> Vote count)
         * - LinkedHashMap maintains order of voting
         * - TreeMap displays results sorted by candidate name
         */

        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> votesMap = new HashMap<>();
        LinkedHashMap<String, Integer> voteOrderMap = new LinkedHashMap<>();

        System.out.print("Enter number of votes to cast: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter candidate name for vote " + (i + 1) + ": ");
            String candidate = sc.nextLine();

            // Update HashMap
            votesMap.put(candidate, votesMap.getOrDefault(candidate, 0) + 1);

            // Update LinkedHashMap (maintain vote order)
            voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);
        }

        System.out.println("\nVotes stored in HashMap (unordered): " + votesMap);

        System.out.println("\nVotes stored in LinkedHashMap (vote order maintained): " + voteOrderMap);

        // TreeMap to sort by candidate name
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(votesMap);
        System.out.println("\nVotes sorted by candidate name (TreeMap): " + sortedVotes);
    }
}
