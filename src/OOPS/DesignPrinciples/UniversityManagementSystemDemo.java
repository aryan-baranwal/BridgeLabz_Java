/*
 This program demonstrates Association and Aggregation.
 Students enroll in Courses, and Professors teach Courses in a University system.
*/

import java.util.ArrayList;

public class UniversityManagementSystemDemo {

    // Course class (aggregates Students and associated with Professor)
    static class Course {
        String courseName;
        Professor professor;                  // Association with Professor
        ArrayList<Student> students = new ArrayList<>();

        // Constructor to initialize course name
        Course(String courseName) {
            this.courseName = courseName;
        }

        // Method to assign professor to course (communication)
        void assignProfessor(Professor professor) {
            this.professor = professor;
            professor.courses.add(this);
        }

        // Method to add student to course
        void addStudent(Student student) {
            students.add(student);
        }

        // Method to display course details
        void displayCourseDetails() {
            System.out.println("\nCourse: " + courseName);
            if (professor != null) {
                System.out.println("Professor: " + professor.name);
            }
            System.out.println("Enrolled Students:");
            for (Student s : students) {
                System.out.println("- " + s.name);
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

        // Method to enroll in a course (communication)
        void enrollCourse(Course course) {
            courses.add(course);
            course.addStudent(this);
        }

        // Method to view enrolled courses
        void viewCourses() {
            System.out.println("\nStudent: " + name);
            for (Course c : courses) {
                System.out.println("Enrolled Course: " + c.courseName);
            }
        }
    }

    // Professor class (associated with Course)
    static class Professor {
        String name;
        ArrayList<Course> courses = new ArrayList<>();

        // Constructor to initialize professor name
        Professor(String name) {
            this.name = name;
        }

        // Method to view courses taught
        void viewCoursesTaught() {
            System.out.println("\nProfessor: " + name);
            for (Course c : courses) {
                System.out.println("Teaching Course: " + c.courseName);
            }
        }
    }

    public static void main(String[] args) {

        // Creating students
        Student s1 = new Student("Aryan");
        Student s2 = new Student("Rahul");

        // Creating professor
        Professor p1 = new Professor("Dr. Sharma");

        // Creating courses
        Course c1 = new Course("Data Structures");
        Course c2 = new Course("Operating Systems");

        // Assigning professor to courses
        c1.assignProfessor(p1);
        c2.assignProfessor(p1);

        // Students enrolling in courses
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);

        // Displaying interactions
        s1.viewCourses();
        s2.viewCourses();
        p1.viewCoursesTaught();
        c1.displayCourseDetails();
    }
}
