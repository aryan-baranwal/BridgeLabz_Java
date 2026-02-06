package javacollectionstreams.features.level1;
/*
 Custom functional interface with default method
*/

@FunctionalInterface
interface SquareOperation {
    int square(int x);

    default void printResult(int x) {
        System.out.println("Square of " + x + " is " + square(x));
    }
}

public class SquareFunctionalInterface {

    public static void main(String[] args) {
        SquareOperation sq = x -> x * x;
        sq.printResult(5);
    }
}

