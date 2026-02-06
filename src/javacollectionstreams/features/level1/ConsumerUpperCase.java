package javacollectionstreams.features.level1;
import java.util.*;
import java.util.function.*;

/*
 Consumer interface demo
*/

public class ConsumerUpperCase {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "python", "spring");

        Consumer<String> printUpper =
                s -> System.out.println(s.toUpperCase());

        list.forEach(printUpper);
    }
}

