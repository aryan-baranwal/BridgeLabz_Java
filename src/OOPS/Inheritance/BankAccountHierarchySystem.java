/*
 This program demonstrates hierarchical inheritance.
 BankAccount is the superclass with Savings, Checking, and Fixed Deposit accounts as subclasses.
*/

public class BankAccountHierarchySystem {

    // Superclass BankAccount
    static class BankAccount {
        int accountNumber;
        double balance;

        // Constructor to initialize account details
        BankAccount(int accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        // Method to display basic account info
        void displayAccountInfo() {
            System.out.println("Account Number : " + accountNumber);
            System.out.println("Balance        : " + balance);
        }
    }

    // SavingsAccount subclass
    static class SavingsAccount extends BankAccount {
        double interestRate;

        // Constructor
        SavingsAccount(int accountNumber, double balance, double interestRate) {
            super(accountNumber, balance);
            this.interestRate = interestRate;
        }

        // Method to display account type
        void displayAccountType() {
            System.out.println("Account Type   : Savings Account");
            displayAccountInfo();
            System.out.println("Interest Rate : " + interestRate + "%");
        }
    }

    // CheckingAccount subclass
    static class CheckingAccount extends BankAccount {
        double withdrawalLimit;

        // Constructor
        CheckingAccount(int accountNumber, double balance, double withdrawalLimit) {
            super(accountNumber, balance);
            this.withdrawalLimit = withdrawalLimit;
        }

        // Method to display account type
        void displayAccountType() {
            System.out.println("Account Type      : Checking Account");
            displayAccountInfo();
            System.out.println("Withdrawal Limit : " + withdrawalLimit);
        }
    }

    // FixedDepositAccount subclass
    static class FixedDepositAccount extends BankAccount {
        int lockInPeriod; // in months

        // Constructor
        FixedDepositAccount(int accountNumber, double balance, int lockInPeriod) {
            super(accountNumber, balance);
            this.lockInPeriod = lockInPeriod;
        }

        // Method to display account type
        void displayAccountType() {
            System.out.println("Account Type   : Fixed Deposit Account");
            displayAccountInfo();
            System.out.println("Lock-in Period: " + lockInPeriod + " months");
        }
    }

    public static void main(String[] args) {

        // Creating different account types
        SavingsAccount sa = new SavingsAccount(101, 50000, 4.5);
        CheckingAccount ca = new CheckingAccount(102, 30000, 20000);
        FixedDepositAccount fd = new FixedDepositAccount(103, 100000, 12);

        // Displaying account details
        sa.displayAccountType();
        System.out.println();

        ca.displayAccountType();
        System.out.println();

        fd.displayAccountType();
    }
}
