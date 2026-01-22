/*
 This program implements a Singly Linked List for Student Record Management.
 It supports insert, delete, search, update, and display operations on student records.
*/

public class StudentLinkedListSystem {

    // Node class representing a student
    static class Node {
        int rollNo;
        String name;
        int age;
        char grade;
        Node next;

        // Constructor to initialize student record
        Node(int rollNo, String name, int age, char grade) {
            this.rollNo = rollNo;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    // Singly Linked List class
    static class StudentLinkedList {
        Node head;

        // Add student at beginning
        void addAtBeginning(int rollNo, String name, int age, char grade) {
            Node newNode = new Node(rollNo, name, age, grade);
            newNode.next = head;
            head = newNode;
        }

        // Add student at end
        void addAtEnd(int rollNo, String name, int age, char grade) {
            Node newNode = new Node(rollNo, name, age, grade);

            if (head == null) {
                head = newNode;
                return;
            }

            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        // Add student at specific position (1-based index)
        void addAtPosition(int position, int rollNo, String name, int age, char grade) {
            if (position == 1) {
                addAtBeginning(rollNo, name, age, grade);
                return;
            }

            Node newNode = new Node(rollNo, name, age, grade);
            Node temp = head;

            for (int i = 1; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }

            newNode.next = temp.next;
            temp.next = newNode;
        }

        // Delete student by roll number
        void deleteByRollNo(int rollNo) {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            if (head.rollNo == rollNo) {
                head = head.next;
                System.out.println("Student deleted");
                return;
            }

            Node temp = head;
            while (temp.next != null && temp.next.rollNo != rollNo) {
                temp = temp.next;
            }

            if (temp.next == null) {
                System.out.println("Student not found");
            } else {
                temp.next = temp.next.next;
                System.out.println("Student deleted");
            }
        }

        // Search student by roll number
        void searchByRollNo(int rollNo) {
            Node temp = head;

            while (temp != null) {
                if (temp.rollNo == rollNo) {
                    System.out.println("Student Found:");
                    displayStudent(temp);
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Student not found");
        }

        // Update student grade by roll number
        void updateGrade(int rollNo, char newGrade) {
            Node temp = head;

            while (temp != null) {
                if (temp.rollNo == rollNo) {
                    temp.grade = newGrade;
                    System.out.println("Grade updated");
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Student not found");
        }

        // Display all student records
        void displayAll() {
            if (head == null) {
                System.out.println("No student records available");
                return;
            }

            Node temp = head;
            while (temp != null) {
                displayStudent(temp);
                temp = temp.next;
            }
        }

        // Helper method to display a single student
        void displayStudent(Node node) {
            System.out.println("Roll No : " + node.rollNo);
            System.out.println("Name    : " + node.name);
            System.out.println("Age     : " + node.age);
            System.out.println("Grade   : " + node.grade);
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {

        StudentLinkedList list = new StudentLinkedList();

        // Adding student records
        list.addAtBeginning(101, "Aryan", 20, 'A');
        list.addAtEnd(102, "Rahul", 21, 'B');
        list.addAtEnd(103, "Neha", 19, 'A');
        list.addAtPosition(2, 104, "Kunal", 22, 'C');

        // Display all students
        list.displayAll();

        // Search a student
        list.searchByRollNo(102);

        // Update grade
        list.updateGrade(103, 'A');

        // Delete a student
        list.deleteByRollNo(101);

        // Display updated list
        list.displayAll();
    }
}
