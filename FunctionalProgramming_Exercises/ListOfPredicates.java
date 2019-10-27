package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());

        ArrayList<Integer> newNumbers = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            newNumbers.add(i);
        }
        ArrayList<Integer> num = Arrays.stream(reader.readLine()
                .split(" ")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        Predicate<Integer> divisible = element -> {
            for (Integer integer : num) {
                if (integer == 0) {
                    continue;
                }
                if (element % integer != 0) {
                    return false;
                }
            }
            return true;
        };
        for (Integer newNumber : newNumbers) {
            if (divisible.test(newNumber)) {
                System.out.print(newNumber + " ");
            }
        }
    }
}
