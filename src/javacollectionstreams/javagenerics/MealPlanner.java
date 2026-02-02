package javacollectionstreams.javagenerics;
import java.util.Scanner;   // Import Scanner for user input

/*
 * This program generates personalized meal plans for users.
 * A MealPlan interface represents different meal types.
 * A generic Meal class ensures that only valid meal plans are generated.
 * User input is used to select the type of meal dynamically.
 */

// MealPlan interface
interface MealPlan {

    // Method to display meal details
    void showMeal();
}

// Vegetarian meal implementation
class VegetarianMeal implements MealPlan {

    // Implementation of showMeal method
    public void showMeal() {
        System.out.println("Vegetarian Meal Plan Selected");
    }
}

// Vegan meal implementation
class VeganMeal implements MealPlan {

    // Implementation of showMeal method
    public void showMeal() {
        System.out.println("Vegan Meal Plan Selected");
    }
}

// Generic Meal class with bounded type
class Meal<T extends MealPlan> {

    // Method to generate meal plan
    void generateMeal(T meal) {
        meal.showMeal();
    }
}

// Main class
public class MealPlanner {

    // Main method
    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Display meal options
        System.out.println("Choose Meal Type:");
        System.out.println("1. Vegetarian");
        System.out.println("2. Vegan");

        // Take user choice
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        // Create Meal object
        Meal<MealPlan> meal = new Meal<>();

        // Generate meal based on user choice
        if (choice == 1) {

            // Generate Vegetarian meal
            meal.generateMeal(new VegetarianMeal());

        } else if (choice == 2) {

            // Generate Vegan meal
            meal.generateMeal(new VeganMeal());

        } else {

            // Handle invalid input
            System.out.println("Invalid choice!");
        }

        // Close scanner
        sc.close();
    }
}
