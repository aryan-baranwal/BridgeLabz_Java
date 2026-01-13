public class EmployeeRecordsSystem {

    // Base class Employee
    static class Employee {

        // Access modifiers as required
        public int employeeID;          // public
        protected String department;    // protected
        private double salary;           // private

        // Constructor to initialize employee details
        Employee(int employeeID, String department, double salary) {
            this.employeeID = employeeID;
            this.department = department;
            this.salary = salary;
        }

        // Public method to modify salary
        public void setSalary(double salary) {
            if (salary >= 0) {
                this.salary = salary;
            } else {
                System.out.println("Invalid salary amount.");
            }
        }

        // Public method to access salary
        public double getSalary() {
            return salary;
        }

        // Method to display employee details
        void displayEmployeeDetails() {
            System.out.println("Employee ID : " + employeeID);
            System.out.println("Department  : " + department);
            System.out.println("Salary      : " + salary);
        }
    }

    // Subclass Manager
    static class Manager extends Employee {

        String designation;

        // Constructor
        Manager(int employeeID, String department, double salary, String designation) {
            super(employeeID, department, salary);
            this.designation = designation;
        }

        // Method demonstrating access to public and protected members
        void displayManagerDetails() {
            System.out.println("Employee ID : " + employeeID);    // public access
            System.out.println("Department  : " + department);    // protected access
            System.out.println("Designation : " + designation);
            System.out.println("Salary      : " + getSalary());   // private accessed via getter
        }
    }

    public static void main(String[] args) {

        // Creating Employee object
        Employee emp = new Employee(101, "IT", 50000.0);
        System.out.println("Employee Details:");
        emp.displayEmployeeDetails();

        System.out.println();

        // Modifying salary using public method
        emp.setSalary(60000.0);
        System.out.println("Updated Salary: " + emp.getSalary());

        System.out.println();

        // Creating Manager object
        Manager manager = new Manager(201, "HR", 80000.0, "Team Lead");

        // Display manager details
        System.out.println("Manager Details:");
        manager.displayManagerDetails();
    }
}
