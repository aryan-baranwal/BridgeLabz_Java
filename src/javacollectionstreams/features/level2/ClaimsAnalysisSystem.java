package javacollectionstreams.features.level2;
import java.util.*;
import java.util.stream.*;

/*
 Claims Analysis System
*/

public class ClaimsAnalysisSystem {

    static class Claim {
        int claimId;
        String policyNumber, status;
        double claimAmount;

        public Claim(int claimId, String policyNumber,
                     double claimAmount, String status) {
            this.claimId = claimId;
            this.policyNumber = policyNumber;
            this.claimAmount = claimAmount;
            this.status = status;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Claim> claims = new ArrayList<>();

        System.out.print("Enter number of claims: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            // Claim input
            System.out.print("Enter id, policyNumber, amount, status: ");
            claims.add(new Claim(sc.nextInt(), sc.next(),
                    sc.nextDouble(), sc.next()));
        }

        /*
            Filter: Approved & amount > 5000
            Group: by policy
            Aggregate: total amount
            Top 3 policies
        */

        Map<String, Double> totalClaims =
                claims.stream()
                        .filter(c -> c.status.equalsIgnoreCase("Approved") && c.claimAmount > 5000)
                        .collect(Collectors.groupingBy(
                                c -> c.policyNumber,
                                Collectors.summingDouble(c -> c.claimAmount)
                        ));

        totalClaims.entrySet().stream()
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .limit(3)
                .forEach(System.out::println);
    }
}
