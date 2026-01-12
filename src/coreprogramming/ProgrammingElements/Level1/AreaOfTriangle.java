import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double base = input.nextDouble();    // in inches
        double height = input.nextDouble();  // in inches

        double areaInSqInches = 0.5 * base * height;
        double areaInSqCm = areaInSqInches * 2.54 * 2.54;

        System.out.println(
                "The area of the triangle is " + areaInSqInches +
                        " square inches and " + areaInSqCm + " square centimeters"
        );

        input.close();
    }
}
