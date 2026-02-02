package javacollectionstreams.javagenerics;
import java.util.ArrayList;   // Import ArrayList
import java.util.List;        // Import List
import java.util.Scanner;     // Import Scanner for user input

/*
 * This program simulates an AI-driven Resume Screening System.
 * Different job role resumes are processed using a generic Resume class.
 * Bounded generics ensure that only valid JobRole types are stored.
 * Wildcards allow screening resumes of different job roles using one method.
 * User input is taken to add resumes dynamically.
 */

// Abstract base class representing a job role
abstract class JobRole {

    // Abstract method to display role details
    abstract void roleDetails();
}

// Software Engineer job role
class SoftwareEngineer extends JobRole {

    // Implementation of roleDetails method
    public void roleDetails() {
        System.out.println("Software Engineer Resume");
    }
}

// Data Scientist job role
class DataScientist extends JobRole {

    // Implementation of roleDetails method
    public void roleDetails() {
        System.out.println("Data Scientist Resume");
    }
}

// Generic Resume class with bounded type
class Resume<T extends JobRole> {

    // List to store resumes
    List<T> resumes = new ArrayList<>();

    // Method to add resume
    void addResume(T resume) {
        resumes.add(resume);
    }

    // Method to return all resumes
    List<T> getResumes() {
        return resumes;
    }
}

// Main class
public class ResumeScreening {

    // Wildcard method to screen any job role resumes
    static void screenResumes(List<? extends JobRole> list) {

        // Loop through resumes and display role details
        for (JobRole r : list) {
            r.roleDetails();
        }
    }

    // Main method
    public static void main(String[] args) {

        // Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Create Resume objects for different job roles
        Resume<SoftwareEngineer> seResumes = new Resume<>();
        Resume<DataScientist> dsResumes = new Resume<>();

        // Ask user how many resumes to add
        System.out.print("Enter number of resumes: ");
        int n = sc.nextInt();

        // Loop to add resumes
        for (int i = 0; i < n; i++) {

            // Ask user to choose job role
            System.out.print("Choose job role (1-Software Engineer, 2-Data Scientist): ");
            int choice = sc.nextInt();

            // Add resume based on user choice
            if (choice == 1) {

                // Add Software Engineer resume
                seResumes.addResume(new SoftwareEngineer());

            } else if (choice == 2) {

                // Add Data Scientist resume
                dsResumes.addResume(new DataScientist());

            } else {

                // Handle invalid input
                System.out.println("Invalid choice!");
            }
        }

        // Screen Software Engineer resumes
        System.out.println("\n--- Software Engineer Resumes ---");
        screenResumes(seResumes.getResumes());

        // Screen Data Scientist resumes
        System.out.println("\n--- Data Scientist Resumes ---");
        screenResumes(dsResumes.getResumes());

        // Close scanner
        sc.close();
    }
}
