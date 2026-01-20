/*
 This program demonstrates abstraction, encapsulation, interfaces, and polymorphism.
 Employee is an abstract class with FullTimeEmployee and PartTimeEmployee implementations.
*/

import java.util.ArrayList;

public class EmployeeManagementAbstractSystem {

    // Interface Department
    interface Department {
        void assignDepartment(String departmentName);
        String getDepartmentDetails();
    }

    // Abstract class Employee
    static abstract class Employee {

        // Encapsulated fields (private access)
        private int employeeId;
        private String name;
        private double baseSalary;
        protected String department; // accessible to subclasses

        // Constructor to initialize employee details
        Employee(int employeeId, String name, double baseSalary) {
            this.employeeId = employeeId;
            this.name = name;
            this.baseSalary = baseSalary;
        }

        // Getter and Setter methods (encapsulation)
        public int getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public double getBaseSalary() {
            return baseSalary;
        }

        public void setBaseSalary(double baseSalary) {
            this.baseSalary = baseSalary;
        }

        // Abstract method (to be implemented by subclasses)
        abstract double calculateSalary();

        // Concrete method
        void displayDetails() {
            System.out.println("Employee ID : " + employeeId);
            System.out.println("Name        : " + name);
            System.out.println("Department  : " + department);
            System.out.println("Salary      : " + calculateSalary());
        }
    }

    // FullTimeEmployee subclass
    static class FullTimeEmployee extends Employee implements Department {

        // Constructor
        FullTimeEmployee(int id, String name, double fixedSalary) {
            super(id, name, fixedSalary);
        }

        // Implementing salary calculation (fixed salary)
        @Override
        double calculateSalary() {
            return getBaseSalary();
        }

        // Implementing Department interface
        @Override
        public void assignDepartment(String departmentName) {
            this.department = departmentName;
        }

        @Override
        public String getDepartmentDetails() {
            return department;
        }
    }

    // PartTimeEmployee subclass
    static class PartTimeEmployee extends Employee implements Department {

        int workHours;
        double hourlyRate;

        // Constructor
        PartTimeEmployee(int id, String name, int workHours, double hourlyRate) {
            super(id, name, 0);
            this.workHours = workHours;
            this.hourlyRate = hourlyRate;
        }

        // Implementing salary calculation (hours × rate)
        @Override
        double calculateSalary() {
            return workHours * hourlyRate;
        }

        // Implementing Department interface
        @Override
        public void assignDepartment(String departmentName) {
            this.department = departmentName;
        }

        @Override
        public String getDepartmentDetails() {
            return department;
        }
    }

    public static void main(String[] args) {

        // Creating list of employees (polymorphism)
        ArrayList<Employee> employees = new ArrayList<>();

        Employee e1 = new FullTimeEmployee(101, "Aryan", 60000);
        Employee e2 = new PartTimeEmployee(102, "Rahul", 80, 500);

        // Assigning departments
        ((Department) e1).assignDepartment("IT");
        ((Department) e2).assignDepartment("Support");

        // Adding employees to list
        employees.add(e1);
        employees.add(e2);

        // Processing employees using Employee reference
        for (Employee e : employees) {
            e.displayDetails();
            System.out.println();
        }
    }
}
