package javacollectionstreams.features.level2;
import java.util.*;
import java.util.stream.*;

/*
 Policy Holder Risk Assessment System
*/

public class PolicyHolderRiskAssessment {

    static class PolicyHolder {
        int holderId, age;
        String name, policyType;
        double premiumAmount;

        public PolicyHolder(int holderId, String name,
                            int age, String policyType,
                            double premiumAmount) {
            this.holderId = holderId;
            this.name = name;
            this.age = age;
            this.policyType = policyType;
            this.premiumAmount = premiumAmount;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<PolicyHolder> holders = new ArrayList<>();

        System.out.print("Enter number of policy holders: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            // Input holder data
            System.out.print("Enter id, name, age, type, premium: ");
            holders.add(new PolicyHolder(
                    sc.nextInt(), sc.next(),
                    sc.nextInt(), sc.next(),
                    sc.nextDouble()));
        }

        /*
            Filter: Life & age > 60
            Transform: risk = premium / age
            Group: High Risk / Low Risk
        */

        Map<String, List<PolicyHolder>> riskGroup =
                holders.stream()
                        .filter(p -> p.policyType.equalsIgnoreCase("Life") && p.age > 60)
                        .collect(Collectors.groupingBy(p -> {
                            double risk = p.premiumAmount / p.age;
                            return risk > 0.5 ? "High Risk" : "Low Risk";
                        }));

        riskGroup.forEach((k, v) ->
                System.out.println(k + " -> " + v.size() + " holders"));
    }
}

