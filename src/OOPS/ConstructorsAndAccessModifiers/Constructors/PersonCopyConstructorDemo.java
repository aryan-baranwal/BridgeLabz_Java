public class PersonCopyConstructorDemo {

    // Person class
    static class Person {

        // Attributes of Person
        String name;
        int age;

        // Parameterized constructor
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Copy constructor
        Person(Person other) {
            this.name = other.name;
            this.age = other.age;
        }

        // Method to display person details
        void displayDetails() {
            System.out.println("Name : " + name);
            System.out.println("Age  : " + age);
        }
    }

    public static void main(String[] args) {

        // Creating first Person object
        Person p1 = new Person("Aryan", 21);
        System.out.println("Original Person:");
        p1.displayDetails();

        System.out.println();

        // Creating second Person object using copy constructor
        Person p2 = new Person(p1);
        System.out.println("Copied Person:");
        p2.displayDetails();
    }
}
