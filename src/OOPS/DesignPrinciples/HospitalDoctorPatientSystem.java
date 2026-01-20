/*
 This program demonstrates Association and Communication.
 Doctors and Patients interact through consultations in a Hospital.
*/

import java.util.ArrayList;

public class HospitalDoctorPatientSystem {

    // Doctor class
    static class Doctor {
        String name;
        ArrayList<Patient> patients = new ArrayList<>();

        // Constructor to initialize doctor name
        Doctor(String name) {
            this.name = name;
        }

        // Method to consult a patient (communication)
        void consult(Patient patient) {
            patients.add(patient);
            patient.doctors.add(this);
            System.out.println("Doctor " + name + " is consulting Patient " + patient.name);
        }
    }

    // Patient class
    static class Patient {
        String name;
        ArrayList<Doctor> doctors = new ArrayList<>();

        // Constructor to initialize patient name
        Patient(String name) {
            this.name = name;
        }

        // Method to view consulted doctors
        void viewDoctors() {
            System.out.println("Patient: " + name);
            for (Doctor d : doctors) {
                System.out.println("Consulted Doctor: " + d.name);
            }
        }
    }

    // Hospital class
    static class Hospital {
        String hospitalName;
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Patient> patients = new ArrayList<>();

        // Constructor to initialize hospital name
        Hospital(String hospitalName) {
            this.hospitalName = hospitalName;
        }

        // Method to add doctor
        void addDoctor(Doctor doctor) {
            doctors.add(doctor);
        }

        // Method to add patient
        void addPatient(Patient patient) {
            patients.add(patient);
        }
    }

    public static void main(String[] args) {

        // Creating Hospital
        Hospital hospital = new Hospital("City Hospital");

        // Creating Doctors
        Doctor d1 = new Doctor("Dr. Aryan");
        Doctor d2 = new Doctor("Dr. Rahul");

        // Creating Patients
        Patient p1 = new Patient("Neha");
        Patient p2 = new Patient("Rohan");

        // Adding doctors and patients to hospital
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        // Doctor-patient consultations (association + communication)
        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);

        System.out.println();

        // Patient viewing consulted doctors
        p1.viewDoctors();
    }
}
