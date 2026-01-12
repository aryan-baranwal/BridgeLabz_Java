public class ATMSimulator {

    // BankAccount class
    static class BankAccount {

        // Attributes of BankAccount
        String accountHolder;
        long accountNumber;
        double balance;

        // Constructor to initialize account details
        BankAccount(String accountHolder, long accountNumber, double balance) {
            this.accountHolder = accountHolder;
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        // Method to deposit money
        void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Amount Deposited: " + amount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        // Method to withdraw money (only if sufficient balance exists)
        void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Amount Withdrawn: " + amount);
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        }

        // Method to display current balance
        void displayBalance() {
            System.out.println("Current Balance: " + balance);
        }
    }

    public static void main(String[] args) {

        // Creating a BankAccount object
        BankAccount account = new BankAccount("Aryan", 1234567890L, 5000.0);

        // ATM operations
        account.displayBalance();
        account.deposit(2000);
        account.withdraw(1500);
        account.displayBalance();
    }
}
