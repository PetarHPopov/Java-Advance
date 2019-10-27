package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        String[] name = reader.readLine().split("\\s+");

        BiPredicate<String, Integer> checkNameLength = (names, lengthLimit) -> names.length() <= lengthLimit;

        Consumer<String> printer = System.out::println;

        for (String s : name) {
            if (checkNameLength.test(s, number)) {
                printer.accept(s);
            }
        }
    }
}
