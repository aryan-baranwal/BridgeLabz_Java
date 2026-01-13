public class UniversityStudentManagementSystem {

    // Student class
    static class Student {

        // Static variable shared across all students
        static String universityName = "Global University";
        static int totalStudents = 0;

        // Instance variables
        String name;
        String grade;

        // Final variable (cannot be changed once assigned)
        final int rollNumber;

        // Constructor using 'this' keyword
        Student(String name, int rollNumber, String grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
            totalStudents++; // Increment student count
        }

        // Method to update grade
        void updateGrade(String newGrade) {
            this.grade = newGrade;
        }

        // Method to display student details
        void displayStudentDetails() {
            System.out.println("University Name : " + universityName);
            System.out.println("Roll Number     : " + rollNumber);
            System.out.println("Name            : " + name);
            System.out.println("Grade           : " + grade);
        }

        // Static method to display total students
        static void displayTotalStudents() {
            System.out.println("Total Students Enrolled: " + totalStudents);
        }
    }

    public static void main(String[] args) {

        // Creating Student objects
        Student s1 = new Student("Aryan", 101, "A");
        Student s2 = new Student("Rahul", 102, "B");

        // Using instanceof before performing operations
        if (s1 instanceof Student) {
            System.out.println("Student 1 Details:");
            s1.displayStudentDetails();
            s1.updateGrade("A+");
        }

        System.out.println();

        if (s2 instanceof Student) {
            System.out.println("Student 2 Details:");
            s2.displayStudentDetails();
        }

        System.out.println();

        // Display total students using static method
        Student.displayTotalStudents();
    }
}
