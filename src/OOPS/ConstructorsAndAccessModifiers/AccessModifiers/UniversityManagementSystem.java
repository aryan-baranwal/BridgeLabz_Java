public class UniversityManagementSystem {

    // Base class Student
    static class Student {

        // Access specifiers as required
        public int rollNumber;     // public
        protected String name;     // protected
        private double CGPA;       // private

        // Constructor to initialize student details
        Student(int rollNumber, String name, double CGPA) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.CGPA = CGPA;
        }

        // Public getter method to access CGPA
        public double getCGPA() {
            return CGPA;
        }

        // Public setter method to modify CGPA
        public void setCGPA(double CGPA) {
            if (CGPA >= 0 && CGPA <= 10) {
                this.CGPA = CGPA;
            } else {
                System.out.println("Invalid CGPA value.");
            }
        }

        // Method to display student details
        void displayStudentDetails() {
            System.out.println("Roll Number : " + rollNumber);
            System.out.println("Name        : " + name);
            System.out.println("CGPA        : " + CGPA);
        }
    }

    // Subclass to demonstrate use of protected member
    static class PostgraduateStudent extends Student {

        String specialization;

        // Constructor
        PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
            super(rollNumber, name, CGPA);
            this.specialization = specialization;
        }

        // Method accessing protected member 'name'
        void displayPostgraduateDetails() {
            System.out.println("Postgraduate Student Name : " + name); // protected access
            System.out.println("Specialization            : " + specialization);
            System.out.println("CGPA                      : " + getCGPA());
        }
    }

    public static void main(String[] args) {

        // Creating Student object
        Student s1 = new Student(101, "Aryan", 8.5);
        System.out.println("Student Details:");
        s1.displayStudentDetails();

        System.out.println();

        // Modifying CGPA using public setter
        s1.setCGPA(9.0);
        System.out.println("Updated CGPA: " + s1.getCGPA());

        System.out.println();

        // Creating PostgraduateStudent object
        PostgraduateStudent pg = new PostgraduateStudent(201, "Rahul", 8.8, "Computer Science");

        // Display postgraduate student details
        System.out.println("Postgraduate Student Details:");
        pg.displayPostgraduateDetails();
    }
}
