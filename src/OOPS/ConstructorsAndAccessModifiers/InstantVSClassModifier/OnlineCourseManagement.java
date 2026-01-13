public class OnlineCourseManagement {

    // Course class
    static class Course {

        // Instance variables
        String courseName;
        int duration;      // duration in weeks
        double fee;

        // Class variable (shared by all Course objects)
        static String instituteName = "Open Learning Institute";

        // Constructor to initialize course details
        Course(String courseName, int duration, double fee) {
            this.courseName = courseName;
            this.duration = duration;
            this.fee = fee;
        }

        // Instance method to display course details
        void displayCourseDetails() {
            System.out.println("Course Name   : " + courseName);
            System.out.println("Duration      : " + duration + " weeks");
            System.out.println("Fee           : " + fee);
            System.out.println("Institute     : " + instituteName);
        }

        // Class method to update institute name
        static void updateInstituteName(String newInstituteName) {
            instituteName = newInstituteName;
        }
    }

    public static void main(String[] args) {

        // Creating Course objects
        Course c1 = new Course("Java Programming", 8, 5000);
        Course c2 = new Course("Data Structures", 10, 6500);

        // Display course details before updating institute name
        System.out.println("Before Updating Institute Name:");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();

        // Update institute name using class method
        Course.updateInstituteName("Tech Academy");

        System.out.println("\nAfter Updating Institute Name:");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}
