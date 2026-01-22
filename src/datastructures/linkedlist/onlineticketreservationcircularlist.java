/*
 This program implements an Online Ticket Reservation System using a Circular Linked List.
 Each node represents a booked ticket, and the list loops circularly for easy traversal.
*/

public class onlineticketreservationcircularlist {

    // Node class representing a Ticket
    static class Node {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Node next;

        // Constructor to initialize ticket details
        Node(int ticketId, String customerName, String movieName,
             String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    // Circular Linked List for Ticket Management
    static class TicketList {
        Node head = null;
        Node tail = null;

        // Add a new ticket at the end
        void addTicket(int id, String customer, String movie,
                       String seat, String time) {
            Node newNode = new Node(id, customer, movie, seat, time);

            if (head == null) {
                head = tail = newNode;
                newNode.next = head;
                return;
            }

            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }

        // Remove ticket by Ticket ID
        void removeTicket(int id) {
            if (head == null) {
                System.out.println("No tickets booked");
                return;
            }

            Node curr = head;
            Node prev = tail;

            do {
                if (curr.ticketId == id) {

                    // If only one ticket exists
                    if (curr == head && curr == tail) {
                        head = tail = null;
                    }
                    // If removing head
                    else if (curr == head) {
                        head = head.next;
                        tail.next = head;
                    }
                    // If removing tail
                    else if (curr == tail) {
                        tail = prev;
                        tail.next = head;
                    }
                    // Removing middle node
                    else {
                        prev.next = curr.next;
                    }

                    System.out.println("Ticket removed successfully");
                    return;
                }

                prev = curr;
                curr = curr.next;
            } while (curr != head);

            System.out.println("Ticket not found");
        }

        // Display all tickets
        void displayTickets() {
            if (head == null) {
                System.out.println("No tickets to display");
                return;
            }

            Node temp = head;
            do {
                displayTicket(temp);
                temp = temp.next;
            } while (temp != head);
        }

        // Search ticket by Customer Name
        void searchByCustomer(String customerName) {
            if (head == null) {
                System.out.println("No tickets available");
                return;
            }

            Node temp = head;
            boolean found = false;

            do {
                if (temp.customerName.equalsIgnoreCase(customerName)) {
                    displayTicket(temp);
                    found = true;
                }
                temp = temp.next;
            } while (temp != head);

            if (!found) {
                System.out.println("No ticket found for customer: " + customerName);
            }
        }

        // Search ticket by Movie Name
        void searchByMovie(String movieName) {
            if (head == null) {
                System.out.println("No tickets available");
                return;
            }

            Node temp = head;
            boolean found = false;

            do {
                if (temp.movieName.equalsIgnoreCase(movieName)) {
                    displayTicket(temp);
                    found = true;
                }
                temp = temp.next;
            } while (temp != head);

            if (!found) {
                System.out.println("No ticket found for movie: " + movieName);
            }
        }

        // Count total booked tickets
        int countTickets() {
            if (head == null) return 0;

            int count = 0;
            Node temp = head;
            do {
                count++;
                temp = temp.next;
            } while (temp != head);

            return count;
        }

        // Helper method to display a single ticket
        void displayTicket(Node node) {
            System.out.println("Ticket ID    : " + node.ticketId);
            System.out.println("Customer     : " + node.customerName);
            System.out.println("Movie        : " + node.movieName);
            System.out.println("Seat No      : " + node.seatNumber);
            System.out.println("Booking Time : " + node.bookingTime);
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {

        TicketList tickets = new TicketList();

        // Adding ticket reservations
        tickets.addTicket(101, "Aryan", "Inception", "A10", "10:30 AM");
        tickets.addTicket(102, "Rahul", "Interstellar", "B5", "11:00 AM");
        tickets.addTicket(103, "Neha", "Inception", "A11", "11:15 AM");

        // Display all tickets
        System.out.println("Current Tickets:");
        tickets.displayTickets();

        // Search operations
        System.out.println("Search by Customer:");
        tickets.searchByCustomer("Aryan");

        System.out.println("Search by Movie:");
        tickets.searchByMovie("Inception");

        // Remove a ticket
        tickets.removeTicket(102);

        // Display updated tickets
        System.out.println("Updated Tickets:");
        tickets.displayTickets();

        // Count total tickets
        System.out.println("Total Booked Tickets: " + tickets.countTickets());
    }
}
