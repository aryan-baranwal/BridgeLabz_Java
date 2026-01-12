public class EmployeeDetailsDisplay {

    // Employee class
    static class Employee {

        // Attributes of Employee
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
            System.out.println("Employee Name  : " + name);
            System.out.println("Employee ID    : " + id);
            System.out.println("Employee Salary: " + salary);
        }
    }

    public static void main(String[] args) {

        // Creating an Employee object
        Employee emp = new Employee("Aryan", 101, 55000);

        // Displaying employee details
        emp.displayDetails();
    }
}
