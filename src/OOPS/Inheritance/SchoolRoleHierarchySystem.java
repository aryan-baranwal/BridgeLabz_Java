/*
 This program demonstrates hierarchical inheritance.
 Person is the superclass, and Teacher, Student, and Staff are subclasses.
*/

public class SchoolRoleHierarchySystem {

    // Superclass Person
    static class Person {
        String name;
        int age;

        // Constructor to initialize common details
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Method to display basic person info
        void displayPersonInfo() {
            System.out.println("Name : " + name);
            System.out.println("Age  : " + age);
        }
    }

    // Teacher subclass
    static class Teacher extends Person {
        String subject;

        // Constructor
        Teacher(String name, int age, String subject) {
            super(name, age);
            this.subject = subject;
        }

        // Method to describe role
        void displayRole() {
            System.out.println("Role    : Teacher");
            displayPersonInfo();
            System.out.println("Subject : " + subject);
        }
    }

    // Student subclass
    static class Student extends Person {
        String grade;

        // Constructor
        Student(String name, int age, String grade) {
            super(name, age);
            this.grade = grade;
        }

        // Method to describe role
        void displayRole() {
            System.out.println("Role  : Student");
            displayPersonInfo();
            System.out.println("Grade : " + grade);
        }
    }

    // Staff subclass
    static class Staff extends Person {
        String department;

        // Constructor
        Staff(String name, int age, String department) {
            super(name, age);
            this.department = department;
        }

        // Method to describe role
        void displayRole() {
            System.out.println("Role       : Staff");
            displayPersonInfo();
            System.out.println("Department : " + department);
        }
    }

    public static void main(String[] args) {

        // Creating different school roles
        Teacher t = new Teacher("Mr. Sharma", 40, "Mathematics");
        Student s = new Student("Aryan", 18, "12th Grade");
        Staff st = new Staff("Ramesh", 45, "Administration");

        // Displaying role details
        t.displayRole();
        System.out.println();

        s.displayRole();
        System.out.println();

        st.displayRole();
    }
}
