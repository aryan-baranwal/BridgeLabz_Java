public class BankAccountManagementSystem {

    // Base class BankAccount
    static class BankAccount {

        // Access modifiers as required
        public long accountNumber;        // public
        protected String accountHolder;   // protected
        private double balance;           // private

        // Constructor to initialize account details
        BankAccount(long accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }

        // Public getter to access balance
        public double getBalance() {
            return balance;
        }

        // Public setter to modify balance
        public void setBalance(double balance) {
            if (balance >= 0) {
                this.balance = balance;
            } else {
                System.out.println("Invalid balance amount.");
            }
        }

        // Method to display account details
        void displayAccountDetails() {
            System.out.println("Account Number : " + accountNumber);
            System.out.println("Account Holder : " + accountHolder);
            System.out.println("Balance        : " + balance);
        }
    }

    // Subclass SavingsAccount
    static class SavingsAccount extends BankAccount {

        double interestRate;

        // Constructor
        SavingsAccount(long accountNumber, String accountHolder, double balance, double interestRate) {
            super(accountNumber, accountHolder, balance);
            this.interestRate = interestRate;
        }

        // Method demonstrating access to public and protected members
        void displaySavingsAccountDetails() {
            System.out.println("Account Number : " + accountNumber);   // public access
            System.out.println("Account Holder : " + accountHolder);   // protected access
            System.out.println("Interest Rate  : " + interestRate + "%");
            System.out.println("Balance        : " + getBalance());    // private accessed via getter
        }
    }

    public static void main(String[] args) {

        // Creating BankAccount object
        BankAccount account = new BankAccount(1234567890L, "Aryan", 5000.0);
        System.out.println("Bank Account Details:");
        account.displayAccountDetails();

        System.out.println();

        // Modifying balance using public setter
        account.setBalance(7500.0);
        System.out.println("Updated Balance: " + account.getBalance());

        System.out.println();

        // Creating SavingsAccount object
        SavingsAccount savings = new SavingsAccount(9876543210L, "Rahul", 10000.0, 4.5);

        // Display savings account details
        System.out.println("Savings Account Details:");
        savings.displaySavingsAccountDetails();
    }
}
