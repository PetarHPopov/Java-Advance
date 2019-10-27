package FunctionalProgramming_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BiPredicate<Map.Entry<String, Integer>, Integer> olderThen = (person, ageLimit) -> person.getValue() >= ageLimit;
        BiPredicate<Map.Entry<String, Integer>, Integer> youngerThen = (person, ageLimit) -> person.getValue() < ageLimit;

        Consumer<String> printName = System.out::println;
        Consumer<Integer> printAge = System.out::println;
        Consumer<Map.Entry<String, Integer>> printNameWhitAge = person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(", ");
            people.put(tokens[0], Integer.parseInt(tokens[1]));
        }
        String condition = reader.readLine();
        int ageLimit = Integer.parseInt(reader.readLine());
        String printFormat = reader.readLine();

        people.entrySet().stream().filter(person -> {
            return condition.equals("older") ? olderThen.test(person, ageLimit) : youngerThen.test(person, ageLimit);
        }).forEach(person -> {
            if (printFormat.equals("name")){
                printName.accept(person.getKey());
            }else if (printFormat.equals("age")){
                printAge.accept(person.getValue());
            }else {
                printNameWhitAge.accept(person);
            }
        });
    }
}
