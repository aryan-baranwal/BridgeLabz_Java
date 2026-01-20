/*
 This program demonstrates multilevel inheritance.
 Course → OnlineCourse → PaidOnlineCourse adds features step by step.
*/

public class EducationalCourseHierarchy {

    // Base class Course
    static class Course {
        String courseName;
        int duration; // in weeks

        // Constructor to initialize course details
        Course(String courseName, int duration) {
            this.courseName = courseName;
            this.duration = duration;
        }
    }

    // Subclass OnlineCourse (extends Course)
    static class OnlineCourse extends Course {
        String platform;
        boolean isRecorded;

        // Constructor
        OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
            super(courseName, duration);
            this.platform = platform;
            this.isRecorded = isRecorded;
        }
    }

    // Subclass PaidOnlineCourse (extends OnlineCourse)
    static class PaidOnlineCourse extends OnlineCourse {
        double fee;
        double discount;

        // Constructor
        PaidOnlineCourse(String courseName, int duration, String platform,
                         boolean isRecorded, double fee, double discount) {
            super(courseName, duration, platform, isRecorded);
            this.fee = fee;
            this.discount = discount;
        }

        // Method to calculate final fee
        double getFinalFee() {
            return fee - (fee * discount / 100);
        }
    }

    public static void main(String[] args) {

        // Creating PaidOnlineCourse object
        PaidOnlineCourse course = new PaidOnlineCourse(
                "Java Programming",
                8,
                "Coursera",
                true,
                5000,
                10
        );

        // Displaying course details
        System.out.println("Course Name  : " + course.courseName);
        System.out.println("Duration     : " + course.duration + " weeks");
        System.out.println("Platform     : " + course.platform);
        System.out.println("Recorded     : " + course.isRecorded);
        System.out.println("Final Fee    : " + course.getFinalFee());
    }
}
