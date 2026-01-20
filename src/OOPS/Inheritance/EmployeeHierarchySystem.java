/*
 This program demonstrates inheritance and method overriding.
 Manager, Developer, and Intern extend the Employee class with unique attributes.
*/

public class EmployeeHierarchySystem {

    // Base class Employee
    static class Employee {
        String name;
        int id;
        double salary;

        // Constructor to initialize employee details
        Employee(String name, int id, double salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        // Method to display employee details
        void displayDetails() {
            System.out.println("Employee Name : " + name);
            System.out.println("Employee ID   : " + id);
            System.out.println("Salary        : " + salary);
        }
    }

    // Manager subclass
    static class Manager extends Employee {
        int teamSize;

        // Constructor
        Manager(String name, int id, double salary, int teamSize) {
            super(name, id, salary);
            this.teamSize = teamSize;
        }

        // Overriding displayDetails()
        @Override
        void displayDetails() {
            super.displayDetails();
            System.out.println("Team Size     : " + teamSize);
        }
    }

    // Developer subclass
    static class Developer extends Employee {
        String programmingLanguage;

        // Constructor
        Developer(String name, int id, double salary, String programmingLanguage) {
            super(name, id, salary);
            this.programmingLanguage = programmingLanguage;
        }

        // Overriding displayDetails()
        @Override
        void displayDetails() {
            super.displayDetails();
            System.out.println("Language      : " + programmingLanguage);
        }
    }

    // Intern subclass
    static class Intern extends Employee {
        int duration; // internship duration in months

        // Constructor
        Intern(String name, int id, double salary, int duration) {
            super(name, id, salary);
            this.duration = duration;
        }

        // Overriding displayDetails()
        @Override
        void displayDetails() {
            super.displayDetails();
            System.out.println("Internship    : " + duration + " months");
        }
    }

    public static void main(String[] args) {

        // Creating different employee types
        Employee e1 = new Manager("Aryan", 101, 80000, 10);
        Employee e2 = new Developer("Rahul", 102, 60000, "Java");
        Employee e3 = new Intern("Neha", 103, 15000, 6);

        // Polymorphic behavior
        e1.displayDetails();
        System.out.println();
        e2.displayDetails();
        System.out.println();
        e3.displayDetails();
    }
}
