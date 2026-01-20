/*
 This program demonstrates Association and Aggregation.
 A School aggregates Students, and Students are associated with Courses (many-to-many).
*/

import java.util.ArrayList;

public class SchoolStudentCourseSystem {

    // Course class (associated with Student)
    static class Course {
        String courseName;
        ArrayList<Student> students = new ArrayList<>();

        // Constructor to initialize course name
        Course(String courseName) {
            this.courseName = courseName;
        }

        // Method to add student to course
        void addStudent(Student student) {
            students.add(student);
        }

        // Method to display students enrolled in this course
        void displayEnrolledStudents() {
            System.out.println("Course: " + courseName);
            for (Student s : students) {
                System.out.println("Student: " + s.name);
            }
        }
    }

    // Student class (associated with Course)
    static class Student {
        String name;
        ArrayList<Course> courses = new ArrayList<>();

        // Constructor to initialize student name
        Student(String name) {
            this.name = name;
        }

        // Method to enroll student in a course
        void enrollCourse(Course course) {
            courses.add(course);
            course.addStudent(this);
        }

        // Method to view enrolled courses
        void viewCourses() {
            System.out.println("Student: " + name);
            for (Course c : courses) {
                System.out.println("Enrolled Course: " + c.courseName);
            }
        }
    }

    // School class (aggregates Student objects)
    static class School {
        String schoolName;
        ArrayList<Student> students = new ArrayList<>();

        // Constructor to initialize school name
        School(String schoolName) {
            this.schoolName = schoolName;
        }

        // Method to add student to school
        void addStudent(Student student) {
            students.add(student);
        }

        // Method to display students in school
        void displayStudents() {
            System.out.println("\nSchool: " + schoolName);
            for (Student s : students) {
                System.out.println("Student: " + s.name);
            }
        }
    }

    public static void main(String[] args) {

        // Creating School
        School school = new School("Green Valley School");

        // Creating Students
        Student s1 = new Student("Aryan");
        Student s2 = new Student("Rahul");

        // Creating Courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Computer Science");

        // Aggregation: adding students to school
        school.addStudent(s1);
        school.addStudent(s2);

        // Association: students enrolling in courses
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c2);

        // Displaying details
        school.displayStudents();
        System.out.println();
        s1.viewCourses();
        System.out.println();
        c2.displayEnrolledStudents();
    }
}
