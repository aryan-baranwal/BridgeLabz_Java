public class HospitalManagementSystem {

    // Patient class
    static class Patient {

        // Static variable shared among all patients
        static String hospitalName = "City Care Hospital";
        static int totalPatients = 0;

        // Instance variables
        String name;
        int age;
        String ailment;

        // Final variable (cannot be changed once assigned)
        final int patientID;

        // Constructor using 'this' keyword
        Patient(int patientID, String name, int age, String ailment) {
            this.patientID = patientID;
            this.name = name;
            this.age = age;
            this.ailment = ailment;
            totalPatients++; // Increment patient count
        }

        // Method to display patient details
        void displayPatientDetails() {
            System.out.println("Hospital Name : " + hospitalName);
            System.out.println("Patient ID    : " + patientID);
            System.out.println("Name          : " + name);
            System.out.println("Age           : " + age);
            System.out.println("Ailment       : " + ailment);
        }

        // Static method to display total patients
        static void getTotalPatients() {
            System.out.println("Total Patients Admitted: " + totalPatients);
        }
    }

    public static void main(String[] args) {

        // Creating Patient objects
        Patient p1 = new Patient(1001, "Aryan", 22, "Fever");
        Patient p2 = new Patient(1002, "Rahul", 30, "Fracture");

        // Using instanceof before displaying details
        if (p1 instanceof Patient) {
            System.out.println("Patient 1 Details:");
            p1.displayPatientDetails();
        }

        System.out.println();

        if (p2 instanceof Patient) {
            System.out.println("Patient 2 Details:");
            p2.displayPatientDetails();
        }

        System.out.println();

        // Display total patients using static method
        Patient.getTotalPatients();
    }
}
