package javacollectionstreams.features.level1;
import java.util.*;
import java.util.stream.*;

/*
 Filter strings starting with letter A
*/

public class FilterStringsStartingWithA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }

        list.stream()
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);
    }
}
