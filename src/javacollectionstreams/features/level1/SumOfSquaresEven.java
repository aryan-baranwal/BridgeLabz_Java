package javacollectionstreams.features.level1;
import java.util.*;
import java.util.stream.*;

/*
 Sum of squares of even numbers
*/

public class SumOfSquaresEven {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();

        System.out.print("Enter count: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
            nums.add(sc.nextInt());

        int result =
                nums.stream()
                        .filter(x -> x % 2 == 0)
                        .map(x -> x * x)
                        .reduce(0, Integer::sum);

        System.out.println("Sum = " + result);
    }
}
