package javacollectionstreams.features.level1;
import java.util.*;
import java.util.function.*;

/*
 Function interface example
*/

public class CircleAreaFunction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Function<Double, Double> area =
                r -> 3.141 * r * r;

        System.out.print("Enter radius: ");
        double r = sc.nextDouble();

        System.out.println("Area = " + area.apply(r));
    }
}

