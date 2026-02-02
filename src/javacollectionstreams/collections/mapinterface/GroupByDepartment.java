package javacollectionstreams.collections.mapinterface;
import java.util.*;

class Employee {
    String name;
    String department;

    // Constructor
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupByDepartment {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Takes a list of Employee objects from the user
         * 2. Groups them by their department
         * 3. Displays Map<Department, List<Employee>>
         */

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEmployee " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Department: ");
            String dept = sc.nextLine();

            employees.add(new Employee(name, dept));
        }

        // Group employees by department
        Map<String, List<Employee>> grouped = groupByDepartment(employees);

        // Display grouped employees
        System.out.println("\nEmployees grouped by department:");
        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Method to group employees by department
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {

        /*
         * Logic:
         * For each employee:
         *  - If department key exists, add to existing list
         *  - Else, create new list and add employee
         */

        Map<String, List<Employee>> map = new HashMap<>();

        for (Employee emp : employees) {
            map.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
        }

        return map;
    }
}
