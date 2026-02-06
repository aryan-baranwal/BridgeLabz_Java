package javacollectionstreams.features.level1;
import java.util.*;
import java.util.stream.*;

/*
 Most frequent words in text
*/

public class MostFrequentWords {

    public static void main(String[] args) {

        String text = "java is easy and java is powerful";

        Map<String, Long> freq =
                Arrays.stream(text.toLowerCase().split(" "))
                        .collect(Collectors.groupingBy(
                                w -> w, Collectors.counting()));

        freq.entrySet().stream()
                .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .limit(3)
                .forEach(System.out::println);
    }
}

