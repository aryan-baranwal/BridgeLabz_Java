/*
 This program demonstrates abstraction, interfaces, encapsulation, and polymorphism.
 Different patient types calculate hospital bills differently and manage medical records securely.
*/

import java.util.ArrayList;

public class HospitalPatientManagementSystem {

    // Interface for medical record handling
    interface MedicalRecord {
        void addRecord(String record);
        void viewRecords();
    }

    // Abstract class Patient
    static abstract class Patient {

        // Encapsulated fields
        private int patientId;
        private String name;
        private int age;
        protected ArrayList<String> medicalHistory = new ArrayList<>();

        // Constructor to initialize patient details
        Patient(int patientId, String name, int age) {
            this.patientId = patientId;
            this.name = name;
            this.age = age;
        }

        // Getter methods (encapsulation)
        public int getPatientId() {
            return patientId;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        // Abstract method for bill calculation
        abstract double calculateBill();

        // Concrete method to display patient details
        void getPatientDetails() {
            System.out.println("Patient ID : " + patientId);
            System.out.println("Name       : " + name);
            System.out.println("Age        : " + age);
            System.out.println("Bill Amount: " + calculateBill());
        }
    }

    // InPatient subclass
    static class InPatient extends Patient implements MedicalRecord {

        private int daysAdmitted;
        private double dailyCharge;

        // Constructor
        InPatient(int id, String name, int age, int daysAdmitted, double dailyCharge) {
            super(id, name, age);
            this.daysAdmitted = daysAdmitted;
            this.dailyCharge = dailyCharge;
        }

        // Billing logic for in-patient
        @Override
        double calculateBill() {
            return daysAdmitted * dailyCharge;
        }

        // Medical record methods
        @Override
        public void addRecord(String record) {
            medicalHistory.add(record);
        }

        @Override
        public void viewRecords() {
            System.out.println("Medical Records (In-Patient): " + medicalHistory);
        }
    }

    // OutPatient subclass
    static class OutPatient extends Patient implements MedicalRecord {

        private double consultationFee;

        // Constructor
        OutPatient(int id, String name, int age, double consultationFee) {
            super(id, name, age);
            this.consultationFee = consultationFee;
        }

        // Billing logic for out-patient
        @Override
        double calculateBill() {
            return consultationFee;
        }

        // Medical record methods
        @Override
        public void addRecord(String record) {
            medicalHistory.add(record);
        }

        @Override
        public void viewRecords() {
            System.out.println("Medical Records (Out-Patient): " + medicalHistory);
        }
    }

    public static void main(String[] args) {

        // Creating patients using polymorphism
        Patient p1 = new InPatient(101, "Aryan", 22, 5, 3000);
        Patient p2 = new OutPatient(102, "Rahul", 30, 800);

        // Adding medical records
        ((MedicalRecord) p1).addRecord("Appendectomy");
        ((MedicalRecord) p2).addRecord("General Checkup");

        // Displaying patient details dynamically
        p1.getPatientDetails();
        ((MedicalRecord) p1).viewRecords();

        System.out.println();

        p2.getPatientDetails();
        ((MedicalRecord) p2).viewRecords();
    }
}
