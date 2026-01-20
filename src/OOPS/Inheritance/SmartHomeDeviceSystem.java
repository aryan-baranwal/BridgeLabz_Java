/*
 This program demonstrates single inheritance.
 Thermostat extends Device and adds temperature-specific behavior.
*/

public class SmartHomeDeviceSystem {

    // Superclass Device
    static class Device {
        String deviceId;
        String status; // ON or OFF

        // Constructor to initialize device details
        Device(String deviceId, String status) {
            this.deviceId = deviceId;
            this.status = status;
        }

        // Method to display device status
        void displayStatus() {
            System.out.println("Device ID : " + deviceId);
            System.out.println("Status    : " + status);
        }
    }

    // Subclass Thermostat
    static class Thermostat extends Device {
        int temperatureSetting;

        // Constructor to initialize thermostat details
        Thermostat(String deviceId, String status, int temperatureSetting) {
            super(deviceId, status);
            this.temperatureSetting = temperatureSetting;
        }

        // Overriding displayStatus()
        @Override
        void displayStatus() {
            super.displayStatus();
            System.out.println("Temperature Setting : " + temperatureSetting + "°C");
        }
    }

    public static void main(String[] args) {

        // Creating Thermostat object
        Device thermostat = new Thermostat("TH-101", "ON", 24);

        // Polymorphic call
        thermostat.displayStatus();
    }
}
