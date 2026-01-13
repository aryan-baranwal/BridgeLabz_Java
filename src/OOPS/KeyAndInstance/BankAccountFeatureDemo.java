public class BankAccountFeatureDemo {

    // BankAccount class
    static class BankAccount {

        // Static variable shared across all accounts
        static String bankName = "National Bank";
        static int totalAccounts = 0;

        // Instance variables
        String accountHolderName;

        // Final variable (cannot be changed once assigned)
        final long accountNumber;

        // Constructor using 'this' keyword to resolve ambiguity
        BankAccount(String accountHolderName, long accountNumber) {
            this.accountHolderName = accountHolderName;
            this.accountNumber = accountNumber;
            totalAccounts++; // Increment total accounts
        }

        // Method to display account details
        void displayAccountDetails() {
            System.out.println("Bank Name          : " + bankName);
            System.out.println("Account Holder     : " + accountHolderName);
            System.out.println("Account Number     : " + accountNumber);
        }

        // Static method to display total number of accounts
        static void getTotalAccounts() {
            System.out.println("Total Accounts Created: " + totalAccounts);
        }
    }

    public static void main(String[] args) {

        // Creating BankAccount objects
        BankAccount acc1 = new BankAccount("Aryan", 1234567890L);
        BankAccount acc2 = new BankAccount("Rahul", 9876543210L);

        // Using instanceof to check object type before displaying details
        if (acc1 instanceof BankAccount) {
            System.out.println("Account 1 Details:");
            acc1.displayAccountDetails();
        }

        System.out.println();

        if (acc2 instanceof BankAccount) {
            System.out.println("Account 2 Details:");
            acc2.displayAccountDetails();
        }

        System.out.println();

        // Display total number of accounts using static method
        BankAccount.getTotalAccounts();
    }
}
