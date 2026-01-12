public class MovieTicketBookingSystem {

    // MovieTicket class
    static class MovieTicket {

        // Attributes of MovieTicket
        String movieName;
        int seatNumber;
        double price;
        boolean isBooked;

        // Constructor to initialize movie name
        MovieTicket(String movieName) {
            this.movieName = movieName;
            this.isBooked = false;
        }

        // Method to book a ticket (assign seat and update price)
        void bookTicket(int seatNumber, double price) {

            if (!isBooked) {
                this.seatNumber = seatNumber;
                this.price = price;
                this.isBooked = true;
                System.out.println("Ticket booked successfully!");
            } else {
                System.out.println("Ticket is already booked.");
            }
        }

        // Method to display ticket details
        void displayTicketDetails() {

            if (isBooked) {
                System.out.println("Movie Name : " + movieName);
                System.out.println("Seat Number: " + seatNumber);
                System.out.println("Price      : " + price);
            } else {
                System.out.println("No ticket booked yet.");
            }
        }
    }

    public static void main(String[] args) {

        // Creating a MovieTicket object
        MovieTicket ticket = new MovieTicket("Inception");

        // Booking the ticket
        ticket.bookTicket(15, 250.0);

        // Displaying ticket details
        ticket.displayTicketDetails();
    }
}
