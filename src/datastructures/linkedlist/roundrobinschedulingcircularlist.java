/*
 This program implements Round Robin CPU Scheduling using a Circular Linked List.
 Processes execute in fixed time quantum and rotate in a circular manner.
*/

public class roundrobinschedulingcircularlist {

    // Node class representing a Process
    static class Node {
        int pid;
        int burstTime;
        int remainingTime;
        int priority;
        int waitingTime;
        int turnAroundTime;
        Node next;

        // Constructor
        Node(int pid, int burstTime, int priority) {
            this.pid = pid;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
            this.waitingTime = 0;
            this.turnAroundTime = 0;
            this.next = null;
        }
    }

    // Circular Linked List for Round Robin Scheduling
    static class RoundRobinScheduler {
        Node head = null;
        Node tail = null;

        // Add process at end
        void addProcess(int pid, int burstTime, int priority) {
            Node newNode = new Node(pid, burstTime, priority);

            if (head == null) {
                head = tail = newNode;
                newNode.next = head;
            } else {
                tail.next = newNode;
                newNode.next = head;
                tail = newNode;
            }
        }

        // Remove process by PID
        void removeProcess(int pid) {
            if (head == null) return;

            Node curr = head, prev = tail;

            do {
                if (curr.pid == pid) {
                    if (curr == head) {
                        head = head.next;
                        tail.next = head;
                    } else if (curr == tail) {
                        tail = prev;
                        tail.next = head;
                    } else {
                        prev.next = curr.next;
                    }
                    return;
                }
                prev = curr;
                curr = curr.next;
            } while (curr != head);
        }

        // Display circular process list
        void displayProcesses() {
            if (head == null) {
                System.out.println("No processes in queue");
                return;
            }

            Node temp = head;
            do {
                System.out.println("PID: " + temp.pid +
                        " | Remaining Time: " + temp.remainingTime +
                        " | Priority: " + temp.priority);
                temp = temp.next;
            } while (temp != head);
            System.out.println("---------------------------");
        }

        // Simulate Round Robin Scheduling
        void simulate(int timeQuantum) {
            if (head == null) return;

            Node current = head;
            int time = 0;
            int completed = 0;
            int totalProcesses = countProcesses();

            while (completed < totalProcesses) {

                if (current.remainingTime > 0) {

                    int execTime = Math.min(timeQuantum, current.remainingTime);
                    current.remainingTime -= execTime;
                    time += execTime;

                    // Update waiting time for other processes
                    Node temp = head;
                    do {
                        if (temp != current && temp.remainingTime > 0) {
                            temp.waitingTime += execTime;
                        }
                        temp = temp.next;
                    } while (temp != head);

                    // If process completes
                    if (current.remainingTime == 0) {
                        current.turnAroundTime = time;
                        completed++;
                        removeProcess(current.pid);
                        current = head;
                        displayProcesses();
                        continue;
                    }
                }

                current = current.next;
                displayProcesses();
            }

            calculateAverageTimes();
        }

        // Count number of processes
        int countProcesses() {
            if (head == null) return 0;
            int count = 0;
            Node temp = head;
            do {
                count++;
                temp = temp.next;
            } while (temp != head);
            return count;
        }

        // Calculate and display average waiting & turnaround time
        void calculateAverageTimes() {
            double totalWT = 0, totalTAT = 0;
            int count = countProcesses();

            Node temp = head;
            if (temp == null) return;

            do {
                totalWT += temp.waitingTime;
                totalTAT += temp.turnAroundTime;
                temp = temp.next;
            } while (temp != head);

            System.out.println("Average Waiting Time: " + (totalWT / count));
            System.out.println("Average Turnaround Time: " + (totalTAT / count));
        }
    }

    public static void main(String[] args) {

        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Adding processes
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);

        int timeQuantum = 3;

        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();

        // Simulate Round Robin Scheduling
        scheduler.simulate(timeQuantum);
    }
}
