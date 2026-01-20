/*
 This program demonstrates Composition and Aggregation.
 University owns Departments (composition) and aggregates Faculty (aggregation).
*/

import java.util.ArrayList;

public class UniversityCompositionAggregation {

    // Faculty class (can exist independently)
    static class Faculty {
        String name;
        String subject;

        // Constructor to initialize faculty details
        Faculty(String name, String subject) {
            this.name = name;
            this.subject = subject;
        }

        // Method to display faculty details
        void displayFaculty() {
            System.out.println("Faculty Name : " + name);
            System.out.println("Subject      : " + subject);
        }
    }

    // Department class (cannot exist without University)
    static class Department {
        String departmentName;

        // Constructor to initialize department name
        Department(String departmentName) {
            this.departmentName = departmentName;
        }

        // Method to display department details
        void displayDepartment() {
            System.out.println("Department: " + departmentName);
        }
    }

    // University class
    static class University {
        String universityName;
        ArrayList<Department> departments = new ArrayList<>();
        ArrayList<Faculty> facultyMembers = new ArrayList<>();

        // Constructor to initialize university name
        University(String universityName) {
            this.universityName = universityName;
        }

        // Method to add department (composition)
        void addDepartment(String departmentName) {
            departments.add(new Department(departmentName));
        }

        // Method to add faculty (aggregation)
        void addFaculty(Faculty faculty) {
            facultyMembers.add(faculty);
        }

        // Method to display university structure
        void displayUniversityDetails() {
            System.out.println("\nUniversity: " + universityName);

            System.out.println("Departments:");
            for (Department d : departments) {
                d.displayDepartment();
            }

            System.out.println("\nFaculty Members:");
            for (Faculty f : facultyMembers) {
                f.displayFaculty();
                System.out.println();
            }
        }

        // Method to delete university (composition effect)
        void deleteUniversity() {
            departments.clear(); // deletes all departments
            System.out.println("\nUniversity deleted along with all departments.");
        }
    }

    public static void main(String[] args) {

        // Creating independent Faculty objects
        Faculty f1 = new Faculty("Dr. Aryan", "Computer Science");
        Faculty f2 = new Faculty("Dr. Rahul", "Mathematics");

        // Creating University
        University uni = new University("Global Tech University");

        // Adding departments (composition)
        uni.addDepartment("Engineering");
        uni.addDepartment("Science");

        // Adding faculty (aggregation)
        uni.addFaculty(f1);
        uni.addFaculty(f2);

        // Display university details
        uni.displayUniversityDetails();

        // Deleting university (removes departments only)
        uni.deleteUniversity();

        // Faculty still exists independently
        System.out.println("\nFaculty still exists independently:");
        f1.displayFaculty();
    }
}
