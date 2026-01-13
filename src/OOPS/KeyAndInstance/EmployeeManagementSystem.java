public class EmployeeManagementSystem {

    // Employee class
    static class Employee {

        // Static variable shared by all employees
        static String companyName = "Tech Solutions Pvt Ltd";
        static int totalEmployees = 0;

        // Instance variables
        String name;
        String designation;

        // Final variable (cannot be changed once assigned)
        final int id;

        // Constructor using 'this' keyword
        Employee(String name, int id, String designation) {
            this.name = name;
            this.id = id;
            this.designation = designation;
            totalEmployees++; // Increment employee count
        }

        // Method to display employee details
        void displayEmployeeDetails() {
            System.out.println("Company Name : " + companyName);
            System.out.println("Employee ID  : " + id);
            System.out.println("Name         : " + name);
            System.out.println("Designation  : " + designation);
        }

        // Static method to display total number of employees
        static void displayTotalEmployees() {
            System.out.println("Total Employees: " + totalEmployees);
        }
    }

    public static void main(String[] args) {

        // Creating Employee objects
        Employee emp1 = new Employee("Aryan", 101, "Software Engineer");
        Employee emp2 = new Employee("Rahul", 102, "Data Analyst");

        // Using instanceof before displaying details
        if (emp1 instanceof Employee) {
            System.out.println("Employee 1 Details:");
            emp1.displayEmployeeDetails();
        }

        System.out.println();

        if (emp2 instanceof Employee) {
            System.out.println("Employee 2 Details:");
            emp2.displayEmployeeDetails();
        }

        System.out.println();

        // Display total employees
        Employee.displayTotalEmployees();
    }
}
