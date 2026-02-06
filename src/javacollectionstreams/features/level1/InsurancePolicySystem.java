package javacollectionstreams.features.level1;
import java.util.*;
import java.util.stream.*;

/*
 Insurance Policy System using Java 8
*/

public class InsurancePolicySystem {

    static class Policy {
        String policyNumber;
        String holderName;
        double premium;

        Policy(String p, String h, double pr) {
            policyNumber = p;
            holderName = h;
            premium = pr;
        }
    }

    public static void main(String[] args) {

        List<Policy> policies = Arrays.asList(
                new Policy("P1","Smith",1500),
                new Policy("P2","Alex",900),
                new Policy("P3","John",2200),
                new Policy("P4","Smithson",1800)
        );

        // Filter premium > 1200
        policies.stream()
                .filter(p -> p.premium > 1200)
                .forEach(p -> System.out.println(p.holderName));

        // Total premium
        double total =
                policies.stream()
                        .mapToDouble(p -> p.premium)
                        .sum();
        System.out.println("Total = " + total);

        // Highest premium
        Policy max =
                policies.stream()
                        .max(Comparator.comparing(p -> p.premium))
                        .get();
        System.out.println("Highest = " + max.holderName);

        // Group by initial
        Map<Character, List<Policy>> map =
                policies.stream()
                        .collect(Collectors.groupingBy(
                                p -> p.holderName.charAt(0)));

        System.out.println(map);
    }
}

