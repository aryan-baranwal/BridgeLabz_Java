package javacollectionstreams.features.level1;
import java.util.*;
import java.util.function.*;

/*
 Predicate composition example
*/

public class PredicateCompositionDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        System.out.print("Enter strings count: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
            list.add(sc.next());

        Predicate<String> lengthCheck = s -> s.length() > 5;
        Predicate<String> containsCheck = s -> s.contains("Java");

        list.stream()
                .filter(lengthCheck.and(containsCheck))
                .forEach(System.out::println);
    }
}
