package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        Consumer<String> print = e -> System.out.println("Sir " + e);

//        for (String s : input) {
//            print.accept(s);
//        }
        Arrays.stream(input).forEach(print);
    }
}
