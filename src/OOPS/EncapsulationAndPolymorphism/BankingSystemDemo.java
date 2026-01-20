/*
 This program demonstrates abstraction, interfaces, encapsulation, and polymorphism.
 Different bank account types calculate interest differently and support loan features.
*/

import java.util.ArrayList;

public class BankingSystemDemo {

    // Interface for loan-related behavior
    interface Loanable {
        void applyForLoan(double amount);
        boolean calculateLoanEligibility();
    }

    // Abstract class BankAccount
    static abstract class BankAccount {

        // Encapsulated fields
        private String accountNumber;
        private String holderName;
        private double balance;

        // Constructor to initialize account details
        BankAccount(String accountNumber, String holderName, double balance) {
            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.balance = balance;
        }

        // Getter methods (encapsulation)
        public String getAccountNumber() {
            return accountNumber;
        }

        public String getHolderName() {
            return holderName;
        }

        public double getBalance() {
            return balance;
        }

        // Concrete method to deposit money
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        // Concrete method to withdraw money
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            }
        }

        // Abstract method for interest calculation
        abstract double calculateInterest();

        // Method to display account details
        void displayDetails() {
            System.out.println("Account Number : " + accountNumber);
            System.out.println("Holder Name    : " + holderName);
            System.out.println("Balance        : " + balance);
            System.out.println("Interest       : " + calculateInterest());
        }
    }

    // SavingsAccount subclass
    static class SavingsAccount extends BankAccount implements Loanable {

        private static final double INTEREST_RATE = 0.04; // 4%

        SavingsAccount(String accNo, String name, double balance) {
            super(accNo, name, balance);
        }

        // Interest calculation for savings account
        @Override
        double calculateInterest() {
            return getBalance() * INTEREST_RATE;
        }

        // Loan-related methods
        @Override
        public void applyForLoan(double amount) {
            System.out.println("Savings Account loan applied for: " + amount);
        }

        @Override
        public boolean calculateLoanEligibility() {
            return getBalance() >= 50000;
        }
    }

    // CurrentAccount subclass
    static class CurrentAccount extends BankAccount implements Loanable {

        private static final double INTEREST_RATE = 0.02; // 2%

        CurrentAccount(String accNo, String name, double balance) {
            super(accNo, name, balance);
        }

        // Interest calculation for current account
        @Override
        double calculateInterest() {
            return getBalance() * INTEREST_RATE;
        }

        // Loan-related methods
        @Override
        public void applyForLoan(double amount) {
            System.out.println("Current Account loan applied for: " + amount);
        }

        @Override
        public boolean calculateLoanEligibility() {
            return getBalance() >= 100000;
        }
    }

    public static void main(String[] args) {

        // Creating a list of different account types (polymorphism)
        ArrayList<BankAccount> accounts = new ArrayList<>();

        BankAccount sa = new SavingsAccount("SA101", "Aryan", 60000);
        BankAccount ca = new CurrentAccount("CA201", "Rahul", 120000);

        accounts.add(sa);
        accounts.add(ca);

        // Processing accounts polymorphically
        for (BankAccount acc : accounts) {
            acc.displayDetails();

            // Loan processing using interface
            if (acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                loan.applyForLoan(50000);
                System.out.println("Loan Eligible : " + loan.calculateLoanEligibility());
            }

            System.out.println();
        }
    }
}
