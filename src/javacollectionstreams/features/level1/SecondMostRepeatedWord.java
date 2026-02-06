package javacollectionstreams.features.level1;
import java.util.*;
import java.util.stream.*;

/*
 Second most repeated word
*/

public class SecondMostRepeatedWord {

    public static void main(String[] args) {

        String text = "java java python python python spring spring";

        Map<String, Long> freq =
                Arrays.stream(text.split(" "))
                        .collect(Collectors.groupingBy(
                                w -> w, Collectors.counting()));

        freq.entrySet().stream()
                .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
