package javacollectionstreams.features.level1;
import java.util.*;

/*
 Sort Person objects by age
*/

public class SortPersonByAge {

    static class Person {
        String name;
        int age;
        double salary;

        Person(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            people.add(new Person(sc.next(), sc.nextInt(), sc.nextDouble()));
        }

        people.sort((p1, p2) -> p1.age - p2.age);

        people.forEach(p ->
                System.out.println(p.name + " " + p.age + " " + p.salary));
    }
}
