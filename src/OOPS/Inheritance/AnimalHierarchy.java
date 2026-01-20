/*
 This program demonstrates inheritance and polymorphism.
 Animal is the superclass, and Dog, Cat, and Bird override makeSound().
*/

public class AnimalHierarchy {

    // Superclass Animal
    static class Animal {
        String name;
        int age;

        // Constructor to initialize animal details
        Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Method to be overridden by subclasses
        void makeSound() {
            System.out.println("Animal makes a sound");
        }
    }

    // Dog subclass
    static class Dog extends Animal {

        // Constructor
        Dog(String name, int age) {
            super(name, age);
        }

        // Overriding makeSound()
        @Override
        void makeSound() {
            System.out.println(name + " says: Woof!");
        }
    }

    // Cat subclass
    static class Cat extends Animal {

        // Constructor
        Cat(String name, int age) {
            super(name, age);
        }

        // Overriding makeSound()
        @Override
        void makeSound() {
            System.out.println(name + " says: Meow!");
        }
    }

    // Bird subclass
    static class Bird extends Animal {

        // Constructor
        Bird(String name, int age) {
            super(name, age);
        }

        // Overriding makeSound()
        @Override
        void makeSound() {
            System.out.println(name + " says: Chirp!");
        }
    }

    public static void main(String[] args) {

        // Polymorphism: Animal reference, subclass objects
        Animal a1 = new Dog("Buddy", 3);
        Animal a2 = new Cat("Whiskers", 2);
        Animal a3 = new Bird("Tweety", 1);

        // Calling overridden methods
        a1.makeSound();
        a2.makeSound();
        a3.makeSound();
    }
}
