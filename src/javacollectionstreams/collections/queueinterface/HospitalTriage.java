package javacollectionstreams.collections.queueinterface;
import java.util.PriorityQueue;
import java.util.Scanner;

class Patient implements Comparable<Patient> {
    String name;
    int severity; // Higher severity = higher priority

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // Override compareTo for PriorityQueue ordering
    @Override
    public int compareTo(Patient other) {
        // Higher severity comes first
        return other.severity - this.severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {

    public static void main(String[] args) {

        /*
         * This program simulates a hospital triage system.
         * Patients with higher severity are treated first.
         */

        Scanner sc = new Scanner(System.in);

        // PriorityQueue of patients
        PriorityQueue<Patient> pq = new PriorityQueue<>();

        // Input number of patients
        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Input patient details
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of patient " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Severity (1-10): ");
            int severity = sc.nextInt();
            sc.nextLine(); // Consume newline

            pq.add(new Patient(name, severity));
        }

        // Display treatment order
        System.out.println("\nTreatment order based on severity:");

        while (!pq.isEmpty()) {
            Patient p = pq.poll();
            System.out.println(p);
        }
    }
}
