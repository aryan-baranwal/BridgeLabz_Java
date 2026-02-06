package javacollectionstreams.features.level1;
import java.util.*;
import java.util.function.*;

/*
 BiFunction example
*/

public class BiFunctionConcat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BiFunction<String, String, String> concat =
                (a, b) -> a + " " + b;

        System.out.print("Enter two strings: ");
        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(concat.apply(s1, s2));
    }
}
