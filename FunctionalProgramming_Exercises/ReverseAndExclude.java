package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        int n = Integer.parseInt(reader.readLine());

        BiFunction<ArrayList<Integer>,Integer,ArrayList<Integer>> function = (listNum,v) -> {
            Collections.reverse(listNum);
           return listNum = listNum.stream().filter(e -> e % v !=0).collect(Collectors.toCollection(ArrayList::new));
        };
        Consumer<ArrayList<Integer>> printer = e -> e.forEach(x -> System.out.print(x + " "));

        printer.accept(function.apply(numbers,n));
    }
}
