package javacollectionstreams.features.level2;
import java.util.*;
import java.util.stream.*;

/*
 Employee Data Processing System
 Demonstrates filtering, sorting, grouping and aggregation
 using Java 8 Streams.
*/

public class EmployeeDataProcessing {

    // Model class
    static class Employee {
        int id;
        String name, department;
        double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        // User input
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            // Single-line comment: reading employee data
            System.out.print("Enter id, name, department, salary: ");
            int id = sc.nextInt();
            String name = sc.next();
            String dept = sc.next();
            double salary = sc.nextDouble();

            employees.add(new Employee(id, name, dept, salary));
        }

        /*
            1. Filter: Engineering & salary > 80000
            2. Sort: salary descending
            3. Group: by department
            4. Aggregate: average salary
        */

        Map<String, Double> avgSalary =
                employees.stream()
                        .filter(e -> e.department.equalsIgnoreCase("Engineering") && e.salary > 80000)
                        .sorted((a, b) -> Double.compare(b.salary, a.salary))
                        .collect(Collectors.groupingBy(
                                e -> e.department,
                                Collectors.averagingDouble(e -> e.salary)
                        ));

        System.out.println("Average Salary by Department:");
        avgSalary.forEach((k, v) ->
                System.out.println(k + " -> " + v));
    }
}


