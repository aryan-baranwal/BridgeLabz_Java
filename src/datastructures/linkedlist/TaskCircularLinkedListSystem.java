/*
 This program implements a Circular Linked List for a Task Scheduler.
 Tasks are managed in a circular manner so scheduling can loop continuously.
*/

public class TaskCircularLinkedListSystem {

    // Node class representing a Task
    static class Node {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Node next;

        // Constructor to initialize task details
        Node(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

    // Circular Linked List class
    static class TaskScheduler {
        Node head = null;
        Node current = null; // for tracking current task

        // Add task at beginning
        void addAtBeginning(int id, String name, int priority, String date) {
            Node newNode = new Node(id, name, priority, date);

            if (head == null) {
                head = newNode;
                newNode.next = head;
                current = head;
                return;
            }

            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }

            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }

        // Add task at end
        void addAtEnd(int id, String name, int priority, String date) {
            Node newNode = new Node(id, name, priority, date);

            if (head == null) {
                head = newNode;
                newNode.next = head;
                current = head;
                return;
            }

            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
        }

        // Add task at specific position (1-based)
        void addAtPosition(int pos, int id, String name, int priority, String date) {
            if (pos == 1) {
                addAtBeginning(id, name, priority, date);
                return;
            }

            Node temp = head;
            for (int i = 1; i < pos - 1 && temp.next != head; i++) {
                temp = temp.next;
            }

            Node newNode = new Node(id, name, priority, date);
            newNode.next = temp.next;
            temp.next = newNode;
        }

        // Remove task by Task ID
        void removeByTaskId(int id) {
            if (head == null) {
                System.out.println("Task list is empty");
                return;
            }

            Node temp = head, prev = null;

            do {
                if (temp.taskId == id) {
                    if (temp == head) {
                        Node last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = temp.next;
                    }
                    System.out.println("Task removed successfully");
                    return;
                }
                prev = temp;
                temp = temp.next;
            } while (temp != head);

            System.out.println("Task not found");
        }

        // View current task and move to next
        void viewNextTask() {
            if (current == null) {
                System.out.println("No tasks available");
                return;
            }

            displayTask(current);
            current = current.next;
        }

        // Display all tasks starting from head
        void displayAllTasks() {
            if (head == null) {
                System.out.println("No tasks to display");
                return;
            }

            Node temp = head;
            do {
                displayTask(temp);
                temp = temp.next;
            } while (temp != head);
        }

        // Search tasks by priority
        void searchByPriority(int priority) {
            if (head == null) {
                System.out.println("No tasks available");
                return;
            }

            Node temp = head;
            boolean found = false;

            do {
                if (temp.priority == priority) {
                    displayTask(temp);
                    found = true;
                }
                temp = temp.next;
            } while (temp != head);

            if (!found) {
                System.out.println("No task found with priority: " + priority);
            }
        }

        // Helper method to display a task
        void displayTask(Node node) {
            System.out.println("Task ID   : " + node.taskId);
            System.out.println("Task Name : " + node.taskName);
            System.out.println("Priority  : " + node.priority);
            System.out.println("Due Date  : " + node.dueDate);
            System.out.println("---------------------");
        }
    }

    public static void main(String[] args) {

        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks
        scheduler.addAtBeginning(1, "Design Module", 1, "2024-10-01");
        scheduler.addAtEnd(2, "Write Code", 2, "2024-10-05");
        scheduler.addAtEnd(3, "Testing", 1, "2024-10-10");
        scheduler.addAtPosition(2, 4, "Review", 3, "2024-10-03");

        // Display all tasks
        System.out.println("All Tasks:");
        scheduler.displayAllTasks();

        // View tasks circularly
        System.out.println("Current & Next Tasks:");
        scheduler.viewNextTask();
        scheduler.viewNextTask();

        // Search by priority
        System.out.println("Search by Priority 1:");
        scheduler.searchByPriority(1);

        // Remove a task
        scheduler.removeByTaskId(2);

        // Display updated task list
        System.out.println("Updated Task List:");
        scheduler.displayAllTasks();
    }
}
