package javacollectionstreams.collections.insurancepolicysystem;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Policy {
    String policyNumber;
    String policyHolder;
    LocalDate expiryDate;
    String coverageType;
    double premium;

    public Policy(String policyNumber, String policyHolder, LocalDate expiryDate,
                  String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premium = premium;
    }

    @Override
    public String toString() {
        return String.format("%s | Holder: %s | Expiry: %s | Coverage: %s | Premium: %.2f",
                policyNumber, policyHolder, expiryDate, coverageType, premium);
    }
}

public class InsurancePolicySystem {

    // HashMap for quick lookup by policy number
    static Map<String, Policy> policyHashMap = new HashMap<>();

    // LinkedHashMap to maintain insertion order
    static Map<String, Policy> policyLinkedHashMap = new LinkedHashMap<>();

    // TreeMap to sort by expiry date
    static TreeMap<LocalDate, List<Policy>> policyTreeMap = new TreeMap<>();

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of policies to add: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nPolicy " + (i + 1) + ":");

            System.out.print("Policy Number: ");
            String number = sc.nextLine();

            System.out.print("Policy Holder Name: ");
            String holder = sc.nextLine();

            System.out.print("Expiry Date (yyyy-MM-dd): ");
            LocalDate expiry = LocalDate.parse(sc.nextLine(), formatter);

            System.out.print("Coverage Type: ");
            String coverage = sc.nextLine();

            System.out.print("Premium Amount: ");
            double premium = sc.nextDouble();
            sc.nextLine();

            Policy policy = new Policy(number, holder, expiry, coverage, premium);

            // Store in HashMap
            policyHashMap.put(number, policy);

            // Store in LinkedHashMap
            policyLinkedHashMap.put(number, policy);

            // Store in TreeMap (sorted by expiry)
            policyTreeMap.computeIfAbsent(expiry, k -> new ArrayList<>()).add(policy);
        }

        System.out.println("\nAll policies in HashMap (unordered):");
        policyHashMap.values().forEach(System.out::println);

        System.out.println("\nAll policies in LinkedHashMap (insertion order):");
        policyLinkedHashMap.values().forEach(System.out::println);

        System.out.println("\nAll policies in TreeMap (sorted by expiry):");
        policyTreeMap.values().forEach(list -> list.forEach(System.out::println));

        // Demonstrate retrieval by policy number
        System.out.print("\nEnter policy number to retrieve: ");
        String searchNumber = sc.nextLine();
        Policy found = policyHashMap.get(searchNumber);
        if (found != null) {
            System.out.println("Policy found: " + found);
        } else {
            System.out.println("Policy not found!");
        }

        // List policies expiring in next 30 days
        System.out.println("\nPolicies expiring in next 30 days:");
        LocalDate today = LocalDate.now();
        LocalDate next30 = today.plusDays(30);
        policyTreeMap.subMap(today, true, next30, true)
                .values()
                .forEach(list -> list.forEach(System.out::println));

        // List policies by policyholder
        System.out.print("\nEnter policyholder name to list policies: ");
        String holderName = sc.nextLine();
        policyHashMap.values().stream()
                .filter(p -> p.policyHolder.equalsIgnoreCase(holderName))
                .forEach(System.out::println);

        // Remove expired policies
        System.out.println("\nRemoving expired policies...");
        policyHashMap.values().removeIf(p -> p.expiryDate.isBefore(today));
        policyLinkedHashMap.values().removeIf(p -> p.expiryDate.isBefore(today));
        policyTreeMap.headMap(today, false).clear();

        System.out.println("Remaining policies in HashMap:");
        policyHashMap.values().forEach(System.out::println);
    }
}
