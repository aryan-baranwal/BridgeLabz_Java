/*
 This program demonstrates Composition.
 A Company owns Departments, and Departments own Employees.
*/

import java.util.ArrayList;

public class CompanyComposition {

    // Employee class (cannot exist without Department)
    static class Employee {
        String name;

        // Constructor to initialize employee name
        Employee(String name) {
            this.name = name;
        }
    }

    // Department class (cannot exist without Company)
    static class Department {
        String departmentName;
        ArrayList<Employee> employees = new ArrayList<>();

        // Constructor to initialize department name
        Department(String departmentName) {
            this.departmentName = departmentName;
        }

        // Method to add employee to department
        void addEmployee(String employeeName) {
            employees.add(new Employee(employeeName));
        }

        // Method to display employees
        void displayEmployees() {
            System.out.println("Department: " + departmentName);
            for (Employee e : employees) {
                System.out.println("Employee: " + e.name);
            }
        }
    }

    // Company class (owns Departments)
    static class Company {
        String companyName;
        ArrayList<Department> departments = new ArrayList<>();

        // Constructor to initialize company name
        Company(String companyName) {
            this.companyName = companyName;
        }

        // Method to add department to company
        void addDepartment(Department department) {
            departments.add(department);
        }

        // Method to display company structure
        void displayCompanyDetails() {
            System.out.println("\nCompany: " + companyName);
            for (Department d : departments) {
                d.displayEmployees();
            }
        }

        // Method to delete company (composition effect)
        void deleteCompany() {
            departments.clear(); // removes all departments and employees
            System.out.println("\nCompany deleted along with all departments and employees.");
        }
    }

    public static void main(String[] args) {

        // Creating Company object
        Company company = new Company("Tech Solutions");

        // Creating Department objects
        Department dev = new Department("Development");
        Department hr = new Department("HR");

        // Adding employees to departments
        dev.addEmployee("Aryan");
        dev.addEmployee("Rahul");
        hr.addEmployee("Neha");

        // Adding departments to company
        company.addDepartment(dev);
        company.addDepartment(hr);

        // Display company details
        company.displayCompanyDetails();

        // Deleting company (composition)
        company.deleteCompany();
    }
}
