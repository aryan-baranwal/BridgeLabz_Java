package javacollectionstreams.features.level1;
import java.util.*;

/*
 Custom Functional Interface to add two numbers
*/

@FunctionalInterface
interface SumOperation {
    int add(int a, int b);
}

public class SumFunctionalInterface {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Lambda implementation
        SumOperation sum = (a, b) -> a + b;

        System.out.print("Enter two numbers: ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println("Sum = " + sum.add(x, y));
    }
}
