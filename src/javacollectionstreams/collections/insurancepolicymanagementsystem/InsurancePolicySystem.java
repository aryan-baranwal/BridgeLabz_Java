package javacollectionstreams.collections.insurancepolicymanagementsystem;
import java.time.LocalDate;
import java.util.*;

/*
 * Insurance Policy Management System
 * Demonstrates usage of HashSet, LinkedHashSet, TreeSet
 */

class Policy {
    int policyNumber;
    String holderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    // Constructor
    public Policy(int policyNumber, String holderName,
                  LocalDate expiryDate, String coverageType,
                  double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Override equals to ensure uniqueness by policy number
    @Override
    public boolean equals(Object obj) {
        Policy p = (Policy) obj;
        return this.policyNumber == p.policyNumber;
    }

    // Override hashCode for HashSet
    @Override
    public int hashCode() {
        return policyNumber;
    }

    // Display policy
    @Override
    public String toString() {
        return policyNumber + " | " + holderName + " | " +
                expiryDate + " | " + coverageType +
                " | ₹" + premiumAmount;
    }
}

public class InsurancePolicySystem {

    public static void main(String[] args) {

        /*
         * HashSet   -> Fast lookup
         * LinkedHashSet -> Maintains insertion order
         * TreeSet  -> Sorted by expiry date
         */

        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>(
                Comparator.comparing(p -> p.expiryDate)
        );

        Scanner sc = new Scanner(System.in);

        // Taking number of policies
        System.out.print("Enter number of policies: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter Policy " + (i + 1) + " details:");

            System.out.print("Policy Number: ");
            int num = sc.nextInt();
            sc.nextLine();

            System.out.print("Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Expiry Date (yyyy-mm-dd): ");
            LocalDate date = LocalDate.parse(sc.next());

            System.out.print("Coverage Type: ");
            String type = sc.next();

            System.out.print("Premium Amount: ");
            double premium = sc.nextDouble();

            Policy p = new Policy(num, name, date, type, premium);

            // Add to all sets
            hashSet.add(p);
            linkedHashSet.add(p);
            treeSet.add(p);
        }

        // Display all policies
        System.out.println("\nAll Unique Policies (HashSet):");
        displayPolicies(hashSet);

        System.out.println("\nPolicies in Insertion Order (LinkedHashSet):");
        displayPolicies(linkedHashSet);

        System.out.println("\nPolicies Sorted by Expiry Date (TreeSet):");
        displayPolicies(treeSet);

        // Policies expiring in next 30 days
        System.out.println("\nPolicies Expiring in Next 30 Days:");
        findExpiringSoon(hashSet);

        // Policies by coverage type
        sc.nextLine();
        System.out.print("\nEnter coverage type to search: ");
        String searchType = sc.nextLine();
        findByCoverageType(hashSet, searchType);

        // Duplicate detection demo
        System.out.println("\nDuplicate Policy Numbers Check:");
        findDuplicates(hashSet, n);

        // Performance comparison
        comparePerformance();
    }

    // Display all policies
    public static void displayPolicies(Set<Policy> set) {
        for (Policy p : set) {
            System.out.println(p);
        }
    }

    // Find policies expiring in next 30 days
    public static void findExpiringSoon(Set<Policy> set) {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        for (Policy p : set) {
            if (p.expiryDate.isAfter(today)
                    && p.expiryDate.isBefore(limit)) {
                System.out.println(p);
            }
        }
    }

    // Find by coverage type
    public static void findByCoverageType(Set<Policy> set, String type) {
        for (Policy p : set) {
            if (p.coverageType.equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    // Duplicate detection (based on policy number)
    public static void findDuplicates(Set<Policy> set, int inputSize) {
        if (set.size() < inputSize) {
            System.out.println("Duplicate policies found!");
        } else {
            System.out.println("No duplicate policies.");
        }
    }

    // Performance comparison
    public static void comparePerformance() {

        /*
         * Compare time for add, search, remove
         */

        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        int size = 100000;

        // Add performance
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) hashSet.add(i);
        long hashTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < size; i++) linkedHashSet.add(i);
        long linkedTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < size; i++) treeSet.add(i);
        long treeTime = System.nanoTime() - start;

        System.out.println("\nPerformance Comparison (Add Operation):");
        System.out.println("HashSet: " + hashTime + " ns");
        System.out.println("LinkedHashSet: " + linkedTime + " ns");
        System.out.println("TreeSet: " + treeTime + " ns");
    }
}
