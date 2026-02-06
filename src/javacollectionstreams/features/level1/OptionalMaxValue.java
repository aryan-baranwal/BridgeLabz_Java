package javacollectionstreams.features.level1;
import java.util.*;

/*
 Optional handling example
*/

public class OptionalMaxValue {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 30, 5, 60);

        Optional<Integer> max =
                list.stream().max(Integer::compareTo);

        System.out.println(max.orElse(0));
    }
}
