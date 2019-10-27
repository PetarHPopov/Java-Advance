package FunctionalProgramming_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split(", ");

        Function<String, Integer> parsInt = Integer::parseInt;

        System.out.println("Count = " + Arrays.stream(line).map(parsInt).count());
        // int sum = Arrays.stream(line).map(parsInt).reduce(0, (a, b) -> a + b);
        Arrays.stream(line).map(parsInt).reduce(Integer::sum).ifPresent(e -> System.out.println("Sum = " + e));
//        int sum = 0;
//        for (String s : line) {
//            int number = parsInt.apply(s);
//            sum += number;
//        }

    }
}
