/*
 This program demonstrates hybrid inheritance.
 Chef and Waiter extend Person and implement the Worker interface.
*/

public class RestaurantHybridInheritanceSystem {

    // Worker interface
    interface Worker {
        // Method that must be implemented by all workers
        void performDuties();
    }

    // Superclass Person
    static class Person {
        String name;
        int id;

        // Constructor to initialize person details
        Person(String name, int id) {
            this.name = name;
            this.id = id;
        }

        // Method to display basic person info
        void displayInfo() {
            System.out.println("Name : " + name);
            System.out.println("ID   : " + id);
        }
    }

    // Chef class (inherits Person, implements Worker)
    static class Chef extends Person implements Worker {

        String specialty;

        // Constructor
        Chef(String name, int id, String specialty) {
            super(name, id);
            this.specialty = specialty;
        }

        // Implementing performDuties()
        @Override
        public void performDuties() {
            System.out.println("Chef Duty : Cooking " + specialty + " dishes");
        }
    }

    // Waiter class (inherits Person, implements Worker)
    static class Waiter extends Person implements Worker {

        int tablesAssigned;

        // Constructor
        Waiter(String name, int id, int tablesAssigned) {
            super(name, id);
            this.tablesAssigned = tablesAssigned;
        }

        // Implementing performDuties()
        @Override
        public void performDuties() {
            System.out.println("Waiter Duty : Serving " + tablesAssigned + " tables");
        }
    }

    public static void main(String[] args) {

        // Creating Chef and Waiter objects
        Worker chef = new Chef("Amit", 101, "Italian");
        Worker waiter = new Waiter("Rahul", 102, 5);

        // Performing duties (polymorphism via interface)
        chef.performDuties();
        waiter.performDuties();
    }
}
