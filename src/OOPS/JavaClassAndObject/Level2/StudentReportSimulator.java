public class StudentReportSimulator {

    // Student class
    static class Student {

        // Attributes of Student
        String name;
        int rollNumber;
        int marks;

        // Constructor to initialize student details
        Student(String name, int rollNumber, int marks) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.marks = marks;
        }

        // Method to calculate grade based on marks
        char calculateGrade() {
            if (marks >= 90) {
                return 'A';
            } else if (marks >= 75) {
                return 'B';
            } else if (marks >= 60) {
                return 'C';
            } else if (marks >= 40) {
                return 'D';
            } else {
                return 'F';
            }
        }

        // Method to display student details and grade
        void displayReport() {
            System.out.println("Student Name   : " + name);
            System.out.println("Roll Number    : " + rollNumber);
            System.out.println("Marks          : " + marks);
            System.out.println("Grade          : " + calculateGrade());
        }
    }

    public static void main(String[] args) {

        // Creating a Student object
        Student student = new Student("Aryan", 101, 82);

        // Displaying student report
        student.displayReport();
    }
}
