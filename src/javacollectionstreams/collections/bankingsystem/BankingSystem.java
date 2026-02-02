package javacollectionstreams.collections.bankingsystem;
import java.util.*;

class WithdrawalRequest {
    String accountNumber;
    double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber + ", Amount: " + amount;
    }
}

public class BankingSystem {

    public static void main(String[] args) {

        /*
         * This program simulates a banking system:
         * - HashMap stores account balances
         * - TreeMap sorts accounts by balance
         * - Queue processes withdrawal requests
         */

        Scanner sc = new Scanner(System.in);

        // HashMap to store accounts and balances
        HashMap<String, Double> accounts = new HashMap<>();

        System.out.print("Enter number of customers/accounts: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nCustomer " + (i + 1) + ":");
            System.out.print("Account Number: ");
            String acc = sc.nextLine();

            System.out.print("Balance: ");
            double balance = sc.nextDouble();
            sc.nextLine(); // consume newline

            accounts.put(acc, balance);
        }

        System.out.println("\nAccounts (HashMap): " + accounts);

        // TreeMap to sort accounts by balance
        TreeMap<Double, List<String>> sortedByBalance = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sortedByBalance.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        System.out.println("\nAccounts sorted by balance (TreeMap):");
        for (Map.Entry<Double, List<String>> entry : sortedByBalance.entrySet()) {
            System.out.println("Balance: " + entry.getKey() + " -> Accounts: " + entry.getValue());
        }

        // Queue for withdrawal requests
        Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

        System.out.print("\nEnter number of withdrawal requests: ");
        int w = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < w; i++) {
            System.out.println("\nWithdrawal Request " + (i + 1) + ":");
            System.out.print("Account Number: ");
            String acc = sc.nextLine();

            System.out.print("Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            withdrawalQueue.add(new WithdrawalRequest(acc, amount));
        }

        // Process withdrawal requests
        System.out.println("\nProcessing withdrawal requests...");
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();
            if (accounts.containsKey(req.accountNumber)) {
                double currentBalance = accounts.get(req.accountNumber);
                if (currentBalance >= req.amount) {
                    accounts.put(req.accountNumber, currentBalance - req.amount);
                    System.out.println("Withdrawal successful: " + req);
                } else {
                    System.out.println("Insufficient balance: " + req);
                }
            } else {
                System.out.println("Account not found: " + req);
            }
        }

        System.out.println("\nUpdated account balances (HashMap): " + accounts);
    }
}

