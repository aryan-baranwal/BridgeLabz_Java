/*
 This program demonstrates Association.
 A Bank and Customer are associated, and customers hold accounts in a bank.
*/

public class BankCustomerAssociation {

    // Bank class
    static class Bank {
        String bankName;

        // Constructor to initialize bank name
        Bank(String bankName) {
            this.bankName = bankName;
        }

        // Method to open an account for a customer
        void openAccount(Customer customer, double initialBalance) {
            customer.balance = initialBalance;
            customer.bank = this;
            System.out.println("Account opened for " + customer.name + " in " + bankName);
        }
    }

    // Customer class
    static class Customer {
        String name;
        double balance;
        Bank bank; // Association with Bank

        // Constructor to initialize customer name
        Customer(String name) {
            this.name = name;
        }

        // Method to view account balance
        void viewBalance() {
            if (bank != null) {
                System.out.println("Customer Name : " + name);
                System.out.println("Bank          : " + bank.bankName);
                System.out.println("Balance       : " + balance);
            } else {
                System.out.println(name + " does not have an account yet.");
            }
        }
    }

    public static void main(String[] args) {

        // Creating Bank object
        Bank bank = new Bank("State Bank");

        // Creating Customer objects
        Customer c1 = new Customer("Aryan");
        Customer c2 = new Customer("Rahul");

        // Opening accounts (association)
        bank.openAccount(c1, 5000);
        bank.openAccount(c2, 10000);

        // Customers viewing their balances
        c1.viewBalance();
        System.out.println();
        c2.viewBalance();
    }
}
