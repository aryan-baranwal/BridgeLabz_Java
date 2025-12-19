import java.util.Scanner;

public class FeetToYardsMiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double distanceInFeet = input.nextDouble();

        double yards = distanceInFeet / 3;
        double miles = yards / 1760;

        System.out.println(
                "The distance in yards is " + yards +
                        " and in miles is " + miles
        );

        input.close();
    }
}
