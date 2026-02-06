package javacollectionstreams.features.level2;
import java.util.*;
import java.util.stream.*;

/*
 Fraud Detection System
*/

public class FraudDetectionSystem {

    static class Transaction {
        int transactionId;
        String policyNumber;
        double amount;
        boolean isFraudulent;

        public Transaction(int transactionId, String policyNumber,
                           double amount, boolean isFraudulent) {
            this.transactionId = transactionId;
            this.policyNumber = policyNumber;
            this.amount = amount;
            this.isFraudulent = isFraudulent;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Transaction> transactions = new ArrayList<>();

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            // Transaction input
            System.out.print("Enter id, policyNumber, amount, isFraud(true/false): ");
            transactions.add(new Transaction(
                    sc.nextInt(), sc.next(),
                    sc.nextDouble(), sc.nextBoolean()));
        }

        /*
            Filter: fraudulent & amount > 10000
            Group: by policy
            Aggregate: count & sum
            Alert conditions
        */

        Map<String, List<Transaction>> fraudMap =
                transactions.stream()
                        .filter(t -> t.isFraudulent && t.amount > 10000)
                        .collect(Collectors.groupingBy(t -> t.policyNumber));

        fraudMap.forEach((policy, list) -> {
            double totalAmount =
                    list.stream().mapToDouble(t -> t.amount).sum();

            if (list.size() > 5 || totalAmount > 50000) {
                System.out.println("ALERT!");
                System.out.println("Policy: " + policy);
                System.out.println("Fraud Count: " + list.size());
                System.out.println("Total Fraud Amount: " + totalAmount);
            }
        });
    }
}

